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

/**
 * @author Brian Wing Shun Chan
 * @deprecated As of Judson (7.1.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ResourceBlockFinderUtil {

	public static
		com.liferay.portal.kernel.security.permission.ResourceBlockIdsBag
			findByC_G_N_R(
				long companyId, long groupId, String name, long[] roleIds) {

		return getFinder().findByC_G_N_R(companyId, groupId, name, roleIds);
	}

	public static ResourceBlockFinder getFinder() {
		if (_finder == null) {
			_finder = (ResourceBlockFinder)PortalBeanLocatorUtil.locate(
				ResourceBlockFinder.class.getName());
		}

		return _finder;
	}

	public void setFinder(ResourceBlockFinder finder) {
		_finder = finder;
	}

	private static ResourceBlockFinder _finder;

}