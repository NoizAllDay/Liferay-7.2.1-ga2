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

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for ResourceBlock. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceBlockServiceUtil
 * @deprecated
 * @generated
 */
@AccessControlled
@Deprecated
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ResourceBlockService extends BaseService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResourceBlockServiceUtil} to access the resource block remote service. Add custom service methods to <code>com.liferay.portal.service.impl.ResourceBlockServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void addCompanyScopePermission(
			long scopeGroupId, long companyId, String name, long roleId,
			String actionId)
		throws PortalException;

	public void addGroupScopePermission(
			long scopeGroupId, long companyId, long groupId, String name,
			long roleId, String actionId)
		throws PortalException;

	public void addIndividualScopePermission(
			long companyId, long groupId, String name, long primKey,
			long roleId, String actionId)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public void removeAllGroupScopePermissions(
			long scopeGroupId, long companyId, String name, long roleId,
			String actionId)
		throws PortalException;

	public void removeCompanyScopePermission(
			long scopeGroupId, long companyId, String name, long roleId,
			String actionId)
		throws PortalException;

	public void removeGroupScopePermission(
			long scopeGroupId, long companyId, long groupId, String name,
			long roleId, String actionId)
		throws PortalException;

	public void removeIndividualScopePermission(
			long companyId, long groupId, String name, long primKey,
			long roleId, String actionId)
		throws PortalException;

	public void setCompanyScopePermissions(
			long scopeGroupId, long companyId, String name, long roleId,
			List<String> actionIds)
		throws PortalException;

	public void setGroupScopePermissions(
			long scopeGroupId, long companyId, long groupId, String name,
			long roleId, List<String> actionIds)
		throws PortalException;

	public void setIndividualScopePermissions(
			long companyId, long groupId, String name, long primKey,
			long roleId, List<String> actionIds)
		throws PortalException;

	public void setIndividualScopePermissions(
			long companyId, long groupId, String name, long primKey,
			Map<Long, String[]> roleIdsToActionIds)
		throws PortalException;

}