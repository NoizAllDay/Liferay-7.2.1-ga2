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

package com.liferay.portal.kernel.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.model.ResourceTypePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the resource type permission service. This utility wraps <code>com.liferay.portal.service.persistence.impl.ResourceTypePermissionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTypePermissionPersistence
 * @deprecated As of Judson (7.1.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ResourceTypePermissionUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		ResourceTypePermission resourceTypePermission) {

		getPersistence().clearCache(resourceTypePermission);
	}

	/**
	 * @see BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ResourceTypePermission> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ResourceTypePermission> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ResourceTypePermission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ResourceTypePermission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ResourceTypePermission> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ResourceTypePermission update(
		ResourceTypePermission resourceTypePermission) {

		return getPersistence().update(resourceTypePermission);
	}

	/**
	 * @see BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ResourceTypePermission update(
		ResourceTypePermission resourceTypePermission,
		ServiceContext serviceContext) {

		return getPersistence().update(resourceTypePermission, serviceContext);
	}

	/**
	 * Returns all the resource type permissions where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the matching resource type permissions
	 */
	public static List<ResourceTypePermission> findByRoleId(long roleId) {
		return getPersistence().findByRoleId(roleId);
	}

	/**
	 * Returns a range of all the resource type permissions where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of resource type permissions
	 * @param end the upper bound of the range of resource type permissions (not inclusive)
	 * @return the range of matching resource type permissions
	 */
	public static List<ResourceTypePermission> findByRoleId(
		long roleId, int start, int end) {

		return getPersistence().findByRoleId(roleId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource type permissions where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of resource type permissions
	 * @param end the upper bound of the range of resource type permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource type permissions
	 */
	public static List<ResourceTypePermission> findByRoleId(
		long roleId, int start, int end,
		OrderByComparator<ResourceTypePermission> orderByComparator) {

		return getPersistence().findByRoleId(
			roleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource type permissions where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of resource type permissions
	 * @param end the upper bound of the range of resource type permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource type permissions
	 */
	public static List<ResourceTypePermission> findByRoleId(
		long roleId, int start, int end,
		OrderByComparator<ResourceTypePermission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRoleId(
			roleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource type permission in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type permission
	 * @throws NoSuchResourceTypePermissionException if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission findByRoleId_First(
			long roleId,
			OrderByComparator<ResourceTypePermission> orderByComparator)
		throws com.liferay.portal.kernel.exception.
			NoSuchResourceTypePermissionException {

		return getPersistence().findByRoleId_First(roleId, orderByComparator);
	}

	/**
	 * Returns the first resource type permission in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type permission, or <code>null</code> if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission fetchByRoleId_First(
		long roleId,
		OrderByComparator<ResourceTypePermission> orderByComparator) {

		return getPersistence().fetchByRoleId_First(roleId, orderByComparator);
	}

	/**
	 * Returns the last resource type permission in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type permission
	 * @throws NoSuchResourceTypePermissionException if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission findByRoleId_Last(
			long roleId,
			OrderByComparator<ResourceTypePermission> orderByComparator)
		throws com.liferay.portal.kernel.exception.
			NoSuchResourceTypePermissionException {

		return getPersistence().findByRoleId_Last(roleId, orderByComparator);
	}

	/**
	 * Returns the last resource type permission in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type permission, or <code>null</code> if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission fetchByRoleId_Last(
		long roleId,
		OrderByComparator<ResourceTypePermission> orderByComparator) {

		return getPersistence().fetchByRoleId_Last(roleId, orderByComparator);
	}

	/**
	 * Returns the resource type permissions before and after the current resource type permission in the ordered set where roleId = &#63;.
	 *
	 * @param resourceTypePermissionId the primary key of the current resource type permission
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource type permission
	 * @throws NoSuchResourceTypePermissionException if a resource type permission with the primary key could not be found
	 */
	public static ResourceTypePermission[] findByRoleId_PrevAndNext(
			long resourceTypePermissionId, long roleId,
			OrderByComparator<ResourceTypePermission> orderByComparator)
		throws com.liferay.portal.kernel.exception.
			NoSuchResourceTypePermissionException {

		return getPersistence().findByRoleId_PrevAndNext(
			resourceTypePermissionId, roleId, orderByComparator);
	}

	/**
	 * Removes all the resource type permissions where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 */
	public static void removeByRoleId(long roleId) {
		getPersistence().removeByRoleId(roleId);
	}

	/**
	 * Returns the number of resource type permissions where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching resource type permissions
	 */
	public static int countByRoleId(long roleId) {
		return getPersistence().countByRoleId(roleId);
	}

	/**
	 * Returns all the resource type permissions where companyId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 * @return the matching resource type permissions
	 */
	public static List<ResourceTypePermission> findByC_N_R(
		long companyId, String name, long roleId) {

		return getPersistence().findByC_N_R(companyId, name, roleId);
	}

	/**
	 * Returns a range of all the resource type permissions where companyId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 * @param start the lower bound of the range of resource type permissions
	 * @param end the upper bound of the range of resource type permissions (not inclusive)
	 * @return the range of matching resource type permissions
	 */
	public static List<ResourceTypePermission> findByC_N_R(
		long companyId, String name, long roleId, int start, int end) {

		return getPersistence().findByC_N_R(
			companyId, name, roleId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource type permissions where companyId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 * @param start the lower bound of the range of resource type permissions
	 * @param end the upper bound of the range of resource type permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource type permissions
	 */
	public static List<ResourceTypePermission> findByC_N_R(
		long companyId, String name, long roleId, int start, int end,
		OrderByComparator<ResourceTypePermission> orderByComparator) {

		return getPersistence().findByC_N_R(
			companyId, name, roleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource type permissions where companyId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 * @param start the lower bound of the range of resource type permissions
	 * @param end the upper bound of the range of resource type permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource type permissions
	 */
	public static List<ResourceTypePermission> findByC_N_R(
		long companyId, String name, long roleId, int start, int end,
		OrderByComparator<ResourceTypePermission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_N_R(
			companyId, name, roleId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first resource type permission in the ordered set where companyId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type permission
	 * @throws NoSuchResourceTypePermissionException if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission findByC_N_R_First(
			long companyId, String name, long roleId,
			OrderByComparator<ResourceTypePermission> orderByComparator)
		throws com.liferay.portal.kernel.exception.
			NoSuchResourceTypePermissionException {

		return getPersistence().findByC_N_R_First(
			companyId, name, roleId, orderByComparator);
	}

	/**
	 * Returns the first resource type permission in the ordered set where companyId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type permission, or <code>null</code> if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission fetchByC_N_R_First(
		long companyId, String name, long roleId,
		OrderByComparator<ResourceTypePermission> orderByComparator) {

		return getPersistence().fetchByC_N_R_First(
			companyId, name, roleId, orderByComparator);
	}

	/**
	 * Returns the last resource type permission in the ordered set where companyId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type permission
	 * @throws NoSuchResourceTypePermissionException if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission findByC_N_R_Last(
			long companyId, String name, long roleId,
			OrderByComparator<ResourceTypePermission> orderByComparator)
		throws com.liferay.portal.kernel.exception.
			NoSuchResourceTypePermissionException {

		return getPersistence().findByC_N_R_Last(
			companyId, name, roleId, orderByComparator);
	}

	/**
	 * Returns the last resource type permission in the ordered set where companyId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type permission, or <code>null</code> if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission fetchByC_N_R_Last(
		long companyId, String name, long roleId,
		OrderByComparator<ResourceTypePermission> orderByComparator) {

		return getPersistence().fetchByC_N_R_Last(
			companyId, name, roleId, orderByComparator);
	}

	/**
	 * Returns the resource type permissions before and after the current resource type permission in the ordered set where companyId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * @param resourceTypePermissionId the primary key of the current resource type permission
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource type permission
	 * @throws NoSuchResourceTypePermissionException if a resource type permission with the primary key could not be found
	 */
	public static ResourceTypePermission[] findByC_N_R_PrevAndNext(
			long resourceTypePermissionId, long companyId, String name,
			long roleId,
			OrderByComparator<ResourceTypePermission> orderByComparator)
		throws com.liferay.portal.kernel.exception.
			NoSuchResourceTypePermissionException {

		return getPersistence().findByC_N_R_PrevAndNext(
			resourceTypePermissionId, companyId, name, roleId,
			orderByComparator);
	}

	/**
	 * Removes all the resource type permissions where companyId = &#63; and name = &#63; and roleId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 */
	public static void removeByC_N_R(long companyId, String name, long roleId) {
		getPersistence().removeByC_N_R(companyId, name, roleId);
	}

	/**
	 * Returns the number of resource type permissions where companyId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param roleId the role ID
	 * @return the number of matching resource type permissions
	 */
	public static int countByC_N_R(long companyId, String name, long roleId) {
		return getPersistence().countByC_N_R(companyId, name, roleId);
	}

	/**
	 * Returns the resource type permission where companyId = &#63; and groupId = &#63; and name = &#63; and roleId = &#63; or throws a <code>NoSuchResourceTypePermissionException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param roleId the role ID
	 * @return the matching resource type permission
	 * @throws NoSuchResourceTypePermissionException if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission findByC_G_N_R(
			long companyId, long groupId, String name, long roleId)
		throws com.liferay.portal.kernel.exception.
			NoSuchResourceTypePermissionException {

		return getPersistence().findByC_G_N_R(companyId, groupId, name, roleId);
	}

	/**
	 * Returns the resource type permission where companyId = &#63; and groupId = &#63; and name = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param roleId the role ID
	 * @return the matching resource type permission, or <code>null</code> if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission fetchByC_G_N_R(
		long companyId, long groupId, String name, long roleId) {

		return getPersistence().fetchByC_G_N_R(
			companyId, groupId, name, roleId);
	}

	/**
	 * Returns the resource type permission where companyId = &#63; and groupId = &#63; and name = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource type permission, or <code>null</code> if a matching resource type permission could not be found
	 */
	public static ResourceTypePermission fetchByC_G_N_R(
		long companyId, long groupId, String name, long roleId,
		boolean useFinderCache) {

		return getPersistence().fetchByC_G_N_R(
			companyId, groupId, name, roleId, useFinderCache);
	}

	/**
	 * Removes the resource type permission where companyId = &#63; and groupId = &#63; and name = &#63; and roleId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param roleId the role ID
	 * @return the resource type permission that was removed
	 */
	public static ResourceTypePermission removeByC_G_N_R(
			long companyId, long groupId, String name, long roleId)
		throws com.liferay.portal.kernel.exception.
			NoSuchResourceTypePermissionException {

		return getPersistence().removeByC_G_N_R(
			companyId, groupId, name, roleId);
	}

	/**
	 * Returns the number of resource type permissions where companyId = &#63; and groupId = &#63; and name = &#63; and roleId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param roleId the role ID
	 * @return the number of matching resource type permissions
	 */
	public static int countByC_G_N_R(
		long companyId, long groupId, String name, long roleId) {

		return getPersistence().countByC_G_N_R(
			companyId, groupId, name, roleId);
	}

	/**
	 * Caches the resource type permission in the entity cache if it is enabled.
	 *
	 * @param resourceTypePermission the resource type permission
	 */
	public static void cacheResult(
		ResourceTypePermission resourceTypePermission) {

		getPersistence().cacheResult(resourceTypePermission);
	}

	/**
	 * Caches the resource type permissions in the entity cache if it is enabled.
	 *
	 * @param resourceTypePermissions the resource type permissions
	 */
	public static void cacheResult(
		List<ResourceTypePermission> resourceTypePermissions) {

		getPersistence().cacheResult(resourceTypePermissions);
	}

	/**
	 * Creates a new resource type permission with the primary key. Does not add the resource type permission to the database.
	 *
	 * @param resourceTypePermissionId the primary key for the new resource type permission
	 * @return the new resource type permission
	 */
	public static ResourceTypePermission create(long resourceTypePermissionId) {
		return getPersistence().create(resourceTypePermissionId);
	}

	/**
	 * Removes the resource type permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceTypePermissionId the primary key of the resource type permission
	 * @return the resource type permission that was removed
	 * @throws NoSuchResourceTypePermissionException if a resource type permission with the primary key could not be found
	 */
	public static ResourceTypePermission remove(long resourceTypePermissionId)
		throws com.liferay.portal.kernel.exception.
			NoSuchResourceTypePermissionException {

		return getPersistence().remove(resourceTypePermissionId);
	}

	public static ResourceTypePermission updateImpl(
		ResourceTypePermission resourceTypePermission) {

		return getPersistence().updateImpl(resourceTypePermission);
	}

	/**
	 * Returns the resource type permission with the primary key or throws a <code>NoSuchResourceTypePermissionException</code> if it could not be found.
	 *
	 * @param resourceTypePermissionId the primary key of the resource type permission
	 * @return the resource type permission
	 * @throws NoSuchResourceTypePermissionException if a resource type permission with the primary key could not be found
	 */
	public static ResourceTypePermission findByPrimaryKey(
			long resourceTypePermissionId)
		throws com.liferay.portal.kernel.exception.
			NoSuchResourceTypePermissionException {

		return getPersistence().findByPrimaryKey(resourceTypePermissionId);
	}

	/**
	 * Returns the resource type permission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceTypePermissionId the primary key of the resource type permission
	 * @return the resource type permission, or <code>null</code> if a resource type permission with the primary key could not be found
	 */
	public static ResourceTypePermission fetchByPrimaryKey(
		long resourceTypePermissionId) {

		return getPersistence().fetchByPrimaryKey(resourceTypePermissionId);
	}

	/**
	 * Returns all the resource type permissions.
	 *
	 * @return the resource type permissions
	 */
	public static List<ResourceTypePermission> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the resource type permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type permissions
	 * @param end the upper bound of the range of resource type permissions (not inclusive)
	 * @return the range of resource type permissions
	 */
	public static List<ResourceTypePermission> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the resource type permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type permissions
	 * @param end the upper bound of the range of resource type permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resource type permissions
	 */
	public static List<ResourceTypePermission> findAll(
		int start, int end,
		OrderByComparator<ResourceTypePermission> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource type permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type permissions
	 * @param end the upper bound of the range of resource type permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resource type permissions
	 */
	public static List<ResourceTypePermission> findAll(
		int start, int end,
		OrderByComparator<ResourceTypePermission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the resource type permissions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of resource type permissions.
	 *
	 * @return the number of resource type permissions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ResourceTypePermissionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence =
				(ResourceTypePermissionPersistence)PortalBeanLocatorUtil.locate(
					ResourceTypePermissionPersistence.class.getName());
		}

		return _persistence;
	}

	private static ResourceTypePermissionPersistence _persistence;

}