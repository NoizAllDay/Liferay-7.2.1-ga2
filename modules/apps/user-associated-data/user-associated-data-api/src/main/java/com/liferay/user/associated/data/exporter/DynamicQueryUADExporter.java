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

package com.liferay.user.associated.data.exporter;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.petra.xml.XMLUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.zip.ZipWriter;
import com.liferay.portal.kernel.zip.ZipWriterFactoryUtil;
import com.liferay.user.associated.data.util.UADDynamicQueryUtil;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Provides the base implementation of {@link UADExporter} for entities
 * generated with Service Builder. The count and batch actions are based on the
 * {@code ActionableDynamicQuery}, which is available in the local service
 * generated by Service Builder.
 *
 * @author William Newbury
 */
public abstract class DynamicQueryUADExporter<T extends BaseModel>
	implements UADExporter<T> {

	@Override
	public long count(long userId) throws PortalException {
		ActionableDynamicQuery actionableDynamicQuery =
			getActionableDynamicQuery(userId);

		return actionableDynamicQuery.performCount();
	}

	@Override
	public byte[] export(T baseModel) throws PortalException {
		String xml = toXmlString(baseModel);

		xml = formatXML(xml);

		try {
			return xml.getBytes(StringPool.UTF8);
		}
		catch (UnsupportedEncodingException uee) {
			throw new PortalException(uee);
		}
	}

	@Override
	public File exportAll(long userId) throws PortalException {
		ActionableDynamicQuery actionableDynamicQuery =
			getActionableDynamicQuery(userId);

		Class<T> clazz = getTypeClass();

		ZipWriter zipWriter = getZipWriter(userId, clazz.getName());

		actionableDynamicQuery.setPerformActionMethod(
			(T baseModel) -> {
				try {
					writeToZip(baseModel, zipWriter);
				}
				catch (Exception e) {
					throw new PortalException(e);
				}
			});

		actionableDynamicQuery.performActions();

		return zipWriter.getFile();
	}

	protected File createFolder(long userId) {
		StringBundler sb = new StringBundler(3);

		sb.append(SystemProperties.get(SystemProperties.TMP_DIR));
		sb.append("/liferay/uad/");
		sb.append(userId);

		File file = new File(sb.toString());

		file.mkdirs();

		return file;
	}

	/**
	 * Returns an {@code ActionableDynamicQuery} for type {@code T}. This can be
	 * retrieved from the service.
	 *
	 * @return an {@code ActionableDynamicQuery} for type {@code T}
	 */
	protected abstract ActionableDynamicQuery doGetActionableDynamicQuery();

	/**
	 * Returns names identifying fields on the type {@code T} entity that
	 * contain the primary key of a user.
	 *
	 * @return the fields that may contain the primary key of a user
	 */
	protected abstract String[] doGetUserIdFieldNames();

	protected String formatXML(String xml) {
		return XMLUtil.formatXML(xml);
	}

	/**
	 * Returns an {@code ActionableDynamicQuery} for type {@code T}. It should
	 * be populated with criteria and ready for use by the service.
	 *
	 * @param  userId the primary key of the user used to pre-filter the {@code
	 *         ActionableDynamicQuery}
	 * @return a pre-filtered {@code ActionableDynamicQuery}
	 */
	protected ActionableDynamicQuery getActionableDynamicQuery(long userId) {
		return UADDynamicQueryUtil.addActionableDynamicQueryCriteria(
			doGetActionableDynamicQuery(), doGetUserIdFieldNames(), userId);
	}

	/**
	 * Returns a {@code ZipWriter} to write the data to. Each individual type
	 * {@code T} entity is written as a file in the resulting ZIP file.
	 *
	 * @param  userId the the primary key of the user whose data to export
	 * @param  modelClassName the string representation of the model class name
	 * @return a {@code ZipWriter} where each piece of data is written
	 */
	protected ZipWriter getZipWriter(long userId, String modelClassName) {
		File file = createFolder(userId);

		StringBundler sb = new StringBundler(6);

		sb.append(file.getAbsolutePath());
		sb.append(StringPool.SLASH);
		sb.append(modelClassName);
		sb.append(StringPool.UNDERLINE);
		sb.append(Time.getShortTimestamp());
		sb.append(".zip");

		return ZipWriterFactoryUtil.getZipWriter(new File(sb.toString()));
	}

	/**
	 * Converts the type {@code T} base model to an XML string to be written to
	 * a file.
	 *
	 * @param  baseModel the base model to be converted into an XML string
	 * @return an XML string representation of the base model
	 */
	protected String toXmlString(T baseModel) {
		return baseModel.toXmlString();
	}

	/**
	 * Converts the type {@code T} base model to a byte array and writes it to
	 * the {@code ZipWriter}.
	 *
	 * @param  baseModel the baseModel to write to the ZIP
	 * @param  zipWriter the {@code ZipWriter} to write to
	 * @throws Exception if an exception occurred
	 */
	protected void writeToZip(T baseModel, ZipWriter zipWriter)
		throws Exception {

		byte[] data = export(baseModel);

		zipWriter.addEntry(baseModel.getPrimaryKeyObj() + ".xml", data);
	}

}