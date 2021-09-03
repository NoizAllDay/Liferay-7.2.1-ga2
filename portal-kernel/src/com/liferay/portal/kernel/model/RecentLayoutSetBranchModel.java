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

package com.liferay.portal.kernel.model;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the RecentLayoutSetBranch service. Represents a row in the &quot;RecentLayoutSetBranch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.model.impl.RecentLayoutSetBranchModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.model.impl.RecentLayoutSetBranchImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecentLayoutSetBranch
 * @generated
 */
@ProviderType
public interface RecentLayoutSetBranchModel
	extends BaseModel<RecentLayoutSetBranch>, MVCCModel, ShardedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a recent layout set branch model instance should use the {@link RecentLayoutSetBranch} interface instead.
	 */

	/**
	 * Returns the primary key of this recent layout set branch.
	 *
	 * @return the primary key of this recent layout set branch
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this recent layout set branch.
	 *
	 * @param primaryKey the primary key of this recent layout set branch
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this recent layout set branch.
	 *
	 * @return the mvcc version of this recent layout set branch
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this recent layout set branch.
	 *
	 * @param mvccVersion the mvcc version of this recent layout set branch
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the recent layout set branch ID of this recent layout set branch.
	 *
	 * @return the recent layout set branch ID of this recent layout set branch
	 */
	public long getRecentLayoutSetBranchId();

	/**
	 * Sets the recent layout set branch ID of this recent layout set branch.
	 *
	 * @param recentLayoutSetBranchId the recent layout set branch ID of this recent layout set branch
	 */
	public void setRecentLayoutSetBranchId(long recentLayoutSetBranchId);

	/**
	 * Returns the group ID of this recent layout set branch.
	 *
	 * @return the group ID of this recent layout set branch
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this recent layout set branch.
	 *
	 * @param groupId the group ID of this recent layout set branch
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this recent layout set branch.
	 *
	 * @return the company ID of this recent layout set branch
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this recent layout set branch.
	 *
	 * @param companyId the company ID of this recent layout set branch
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this recent layout set branch.
	 *
	 * @return the user ID of this recent layout set branch
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this recent layout set branch.
	 *
	 * @param userId the user ID of this recent layout set branch
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this recent layout set branch.
	 *
	 * @return the user uuid of this recent layout set branch
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this recent layout set branch.
	 *
	 * @param userUuid the user uuid of this recent layout set branch
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the layout set branch ID of this recent layout set branch.
	 *
	 * @return the layout set branch ID of this recent layout set branch
	 */
	public long getLayoutSetBranchId();

	/**
	 * Sets the layout set branch ID of this recent layout set branch.
	 *
	 * @param layoutSetBranchId the layout set branch ID of this recent layout set branch
	 */
	public void setLayoutSetBranchId(long layoutSetBranchId);

	/**
	 * Returns the layout set ID of this recent layout set branch.
	 *
	 * @return the layout set ID of this recent layout set branch
	 */
	public long getLayoutSetId();

	/**
	 * Sets the layout set ID of this recent layout set branch.
	 *
	 * @param layoutSetId the layout set ID of this recent layout set branch
	 */
	public void setLayoutSetId(long layoutSetId);

}