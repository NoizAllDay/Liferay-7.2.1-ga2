/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.repository.liferayrepository;

import com.liferay.document.library.kernel.util.DLValidatorUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.DocumentRepository;
import com.liferay.portal.kernel.repository.LocalRepository;
import com.liferay.portal.kernel.repository.Repository;
import com.liferay.portal.kernel.repository.RepositoryFactory;
import com.liferay.portal.kernel.repository.capabilities.BulkOperationCapability;
import com.liferay.portal.kernel.repository.capabilities.CommentCapability;
import com.liferay.portal.kernel.repository.capabilities.DynamicCapability;
import com.liferay.portal.kernel.repository.capabilities.PortalCapabilityLocator;
import com.liferay.portal.kernel.repository.capabilities.ProcessorCapability;
import com.liferay.portal.kernel.repository.capabilities.RelatedModelCapability;
import com.liferay.portal.kernel.repository.capabilities.SyncCapability;
import com.liferay.portal.kernel.repository.capabilities.ThumbnailCapability;
import com.liferay.portal.kernel.repository.capabilities.TrashCapability;
import com.liferay.portal.kernel.repository.capabilities.WorkflowCapability;
import com.liferay.portal.kernel.repository.model.FileContentReference;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.repository.registry.BaseRepositoryDefiner;
import com.liferay.portal.kernel.repository.registry.CapabilityRegistry;
import com.liferay.portal.kernel.repository.registry.RepositoryDefiner;
import com.liferay.portal.kernel.repository.registry.RepositoryFactoryRegistry;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsValues;

import java.util.function.BiFunction;

/**
 * @author Adolfo Pérez
 */
public class LiferayRepositoryDefiner extends BaseRepositoryDefiner {

	public static final String CLASS_NAME = LiferayRepository.class.getName();

	public static BiFunction
		<PortalCapabilityLocator, RepositoryFactory, RepositoryDefiner>
			getFactoryBiFunction() {

		return LiferayRepositoryDefiner::new;
	}

	public LiferayRepositoryDefiner(
		PortalCapabilityLocator portalCapabilityLocator,
		RepositoryFactory repositoryFactory) {

		_portalCapabilityLocator = portalCapabilityLocator;
		_repositoryFactory = new LiferayRepositoryFactoryWrapper(
			repositoryFactory);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public boolean isExternalRepository() {
		return false;
	}

	@Override
	public void registerCapabilities(
		CapabilityRegistry<DocumentRepository> capabilityRegistry) {

		DocumentRepository documentRepository = capabilityRegistry.getTarget();

		capabilityRegistry.addExportedCapability(
			BulkOperationCapability.class,
			_portalCapabilityLocator.getBulkOperationCapability(
				documentRepository));

		if (PropsValues.DL_FILE_ENTRY_COMMENTS_ENABLED) {
			capabilityRegistry.addExportedCapability(
				CommentCapability.class,
				_portalCapabilityLocator.getCommentCapability(
					documentRepository));
		}

		capabilityRegistry.addExportedCapability(
			RelatedModelCapability.class,
			_portalCapabilityLocator.getRelatedModelCapability(
				documentRepository));
		capabilityRegistry.addExportedCapability(
			ThumbnailCapability.class,
			_portalCapabilityLocator.getThumbnailCapability(
				documentRepository));
		capabilityRegistry.addExportedCapability(
			TrashCapability.class,
			_portalCapabilityLocator.getTrashCapability(documentRepository));
		capabilityRegistry.addExportedCapability(
			WorkflowCapability.class,
			_portalCapabilityLocator.getWorkflowCapability(
				documentRepository, WorkflowCapability.OperationMode.FULL));

		capabilityRegistry.addSupportedCapability(
			DynamicCapability.class,
			_portalCapabilityLocator.getDynamicCapability(
				documentRepository, getClassName()));
		capabilityRegistry.addSupportedCapability(
			ProcessorCapability.class,
			_portalCapabilityLocator.getProcessorCapability(
				documentRepository,
				ProcessorCapability.ResourceGenerationStrategy.REUSE));
		capabilityRegistry.addSupportedCapability(
			SyncCapability.class,
			_portalCapabilityLocator.getSyncCapability(documentRepository));
	}

	@Override
	public void registerRepositoryFactory(
		RepositoryFactoryRegistry repositoryFactoryRegistry) {

		repositoryFactoryRegistry.setRepositoryFactory(_repositoryFactory);
	}

	private final PortalCapabilityLocator _portalCapabilityLocator;
	private RepositoryFactory _repositoryFactory;

	private static class LiferayRepositoryFactoryWrapper
		implements RepositoryFactory {

		public LiferayRepositoryFactoryWrapper(
			RepositoryFactory repositoryFactory) {

			_repositoryFactory = repositoryFactory;
		}

		@Override
		public LocalRepository createLocalRepository(long repositoryId)
			throws PortalException {

			return new ModelValidatorLocalRepositoryWrapper(
				_repositoryFactory.createLocalRepository(repositoryId),
				_modelValidator);
		}

		@Override
		public Repository createRepository(long repositoryId)
			throws PortalException {

			return new ModelValidatorRepositoryWrapper(
				_repositoryFactory.createRepository(repositoryId),
				_modelValidator);
		}

		private static final ModelValidator<FileContentReference>
			_modelValidator = fileContentReference -> {
				if (Validator.isNotNull(
						fileContentReference.getSourceFileName())) {

					DLValidatorUtil.validateFileName(
						fileContentReference.getSourceFileName());
				}

				if ((fileContentReference.getFileEntryId() == 0) ||
					Validator.isNotNull(
						fileContentReference.getSourceFileName())) {

					DLValidatorUtil.validateFileExtension(
						fileContentReference.getSourceFileName());

					DLValidatorUtil.validateSourceFileExtension(
						fileContentReference.getExtension(),
						fileContentReference.getSourceFileName());
				}

				DLValidatorUtil.validateFileSize(
					fileContentReference.getSourceFileName(),
					fileContentReference.getSize());
			};

		private final RepositoryFactory _repositoryFactory;

	}

}