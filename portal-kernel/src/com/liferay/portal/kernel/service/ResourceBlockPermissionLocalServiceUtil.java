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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the local service utility for ResourceBlockPermission. This utility wraps
 * <code>com.liferay.portal.service.impl.ResourceBlockPermissionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceBlockPermissionLocalService
 * @deprecated As of Judson (7.1.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ResourceBlockPermissionLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.ResourceBlockPermissionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the resource block permission to the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceBlockPermission the resource block permission
	 * @return the resource block permission that was added
	 */
	public static com.liferay.portal.kernel.model.ResourceBlockPermission
		addResourceBlockPermission(
			com.liferay.portal.kernel.model.ResourceBlockPermission
				resourceBlockPermission) {

		return getService().addResourceBlockPermission(resourceBlockPermission);
	}

	public static void addResourceBlockPermissions(
		long resourceBlockId,
		com.liferay.portal.kernel.model.ResourceBlockPermissionsContainer
			resourceBlockPermissionsContainer) {

		getService().addResourceBlockPermissions(
			resourceBlockId, resourceBlockPermissionsContainer);
	}

	/**
	 * Creates a new resource block permission with the primary key. Does not add the resource block permission to the database.
	 *
	 * @param resourceBlockPermissionId the primary key for the new resource block permission
	 * @return the new resource block permission
	 */
	public static com.liferay.portal.kernel.model.ResourceBlockPermission
		createResourceBlockPermission(long resourceBlockPermissionId) {

		return getService().createResourceBlockPermission(
			resourceBlockPermissionId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the resource block permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceBlockPermissionId the primary key of the resource block permission
	 * @return the resource block permission that was removed
	 * @throws PortalException if a resource block permission with the primary key could not be found
	 */
	public static com.liferay.portal.kernel.model.ResourceBlockPermission
			deleteResourceBlockPermission(long resourceBlockPermissionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteResourceBlockPermission(
			resourceBlockPermissionId);
	}

	/**
	 * Deletes the resource block permission from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceBlockPermission the resource block permission
	 * @return the resource block permission that was removed
	 */
	public static com.liferay.portal.kernel.model.ResourceBlockPermission
		deleteResourceBlockPermission(
			com.liferay.portal.kernel.model.ResourceBlockPermission
				resourceBlockPermission) {

		return getService().deleteResourceBlockPermission(
			resourceBlockPermission);
	}

	public static void deleteResourceBlockPermissions(long resourceBlockId) {
		getService().deleteResourceBlockPermissions(resourceBlockId);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.model.impl.ResourceBlockPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.model.impl.ResourceBlockPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.portal.kernel.model.ResourceBlockPermission
		fetchResourceBlockPermission(long resourceBlockPermissionId) {

		return getService().fetchResourceBlockPermission(
			resourceBlockPermissionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.Map<Long, java.util.Set<String>>
			getAvailableResourceBlockPermissionActionIds(
				String name, long primKey, java.util.List<String> actionIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAvailableResourceBlockPermissionActionIds(
			name, primKey, actionIds);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the resource block permission with the primary key.
	 *
	 * @param resourceBlockPermissionId the primary key of the resource block permission
	 * @return the resource block permission
	 * @throws PortalException if a resource block permission with the primary key could not be found
	 */
	public static com.liferay.portal.kernel.model.ResourceBlockPermission
			getResourceBlockPermission(long resourceBlockPermissionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getResourceBlockPermission(
			resourceBlockPermissionId);
	}

	/**
	 * Returns a range of all the resource block permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.model.impl.ResourceBlockPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource block permissions
	 * @param end the upper bound of the range of resource block permissions (not inclusive)
	 * @return the range of resource block permissions
	 */
	public static java.util.List
		<com.liferay.portal.kernel.model.ResourceBlockPermission>
			getResourceBlockPermissions(int start, int end) {

		return getService().getResourceBlockPermissions(start, end);
	}

	public static
		com.liferay.portal.kernel.model.ResourceBlockPermissionsContainer
			getResourceBlockPermissionsContainer(long resourceBlockId) {

		return getService().getResourceBlockPermissionsContainer(
			resourceBlockId);
	}

	/**
	 * Returns the number of resource block permissions.
	 *
	 * @return the number of resource block permissions
	 */
	public static int getResourceBlockPermissionsCount() {
		return getService().getResourceBlockPermissionsCount();
	}

	public static int getResourceBlockPermissionsCount(
		long resourceBlockId, long roleId) {

		return getService().getResourceBlockPermissionsCount(
			resourceBlockId, roleId);
	}

	public static void updateResourceBlockPermission(
		long resourceBlockId, long roleId, long actionIdsLong, int operator) {

		getService().updateResourceBlockPermission(
			resourceBlockId, roleId, actionIdsLong, operator);
	}

	/**
	 * Updates the resource block permission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param resourceBlockPermission the resource block permission
	 * @return the resource block permission that was updated
	 */
	public static com.liferay.portal.kernel.model.ResourceBlockPermission
		updateResourceBlockPermission(
			com.liferay.portal.kernel.model.ResourceBlockPermission
				resourceBlockPermission) {

		return getService().updateResourceBlockPermission(
			resourceBlockPermission);
	}

	public static ResourceBlockPermissionLocalService getService() {
		if (_service == null) {
			_service =
				(ResourceBlockPermissionLocalService)
					PortalBeanLocatorUtil.locate(
						ResourceBlockPermissionLocalService.class.getName());
		}

		return _service;
	}

	private static ResourceBlockPermissionLocalService _service;

}