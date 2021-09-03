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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.version.VersionModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the LayoutSetVersion service. Represents a row in the &quot;LayoutSetVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.model.impl.LayoutSetVersionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.model.impl.LayoutSetVersionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetVersion
 * @generated
 */
@ProviderType
public interface LayoutSetVersionModel
	extends BaseModel<LayoutSetVersion>, ShardedModel, VersionModel<LayoutSet> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a layout set version model instance should use the {@link LayoutSetVersion} interface instead.
	 */

	/**
	 * Returns the primary key of this layout set version.
	 *
	 * @return the primary key of this layout set version
	 */
	@Override
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this layout set version.
	 *
	 * @param primaryKey the primary key of this layout set version
	 */
	@Override
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the layout set version ID of this layout set version.
	 *
	 * @return the layout set version ID of this layout set version
	 */
	public long getLayoutSetVersionId();

	/**
	 * Sets the layout set version ID of this layout set version.
	 *
	 * @param layoutSetVersionId the layout set version ID of this layout set version
	 */
	public void setLayoutSetVersionId(long layoutSetVersionId);

	/**
	 * Returns the version of this layout set version.
	 *
	 * @return the version of this layout set version
	 */
	@Override
	public int getVersion();

	/**
	 * Sets the version of this layout set version.
	 *
	 * @param version the version of this layout set version
	 */
	@Override
	public void setVersion(int version);

	/**
	 * Returns the layout set ID of this layout set version.
	 *
	 * @return the layout set ID of this layout set version
	 */
	public long getLayoutSetId();

	/**
	 * Sets the layout set ID of this layout set version.
	 *
	 * @param layoutSetId the layout set ID of this layout set version
	 */
	public void setLayoutSetId(long layoutSetId);

	/**
	 * Returns the group ID of this layout set version.
	 *
	 * @return the group ID of this layout set version
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this layout set version.
	 *
	 * @param groupId the group ID of this layout set version
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this layout set version.
	 *
	 * @return the company ID of this layout set version
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this layout set version.
	 *
	 * @param companyId the company ID of this layout set version
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this layout set version.
	 *
	 * @return the create date of this layout set version
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this layout set version.
	 *
	 * @param createDate the create date of this layout set version
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this layout set version.
	 *
	 * @return the modified date of this layout set version
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this layout set version.
	 *
	 * @param modifiedDate the modified date of this layout set version
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the private layout of this layout set version.
	 *
	 * @return the private layout of this layout set version
	 */
	public boolean getPrivateLayout();

	/**
	 * Returns <code>true</code> if this layout set version is private layout.
	 *
	 * @return <code>true</code> if this layout set version is private layout; <code>false</code> otherwise
	 */
	public boolean isPrivateLayout();

	/**
	 * Sets whether this layout set version is private layout.
	 *
	 * @param privateLayout the private layout of this layout set version
	 */
	public void setPrivateLayout(boolean privateLayout);

	/**
	 * Returns the logo ID of this layout set version.
	 *
	 * @return the logo ID of this layout set version
	 */
	public long getLogoId();

	/**
	 * Sets the logo ID of this layout set version.
	 *
	 * @param logoId the logo ID of this layout set version
	 */
	public void setLogoId(long logoId);

	/**
	 * Returns the theme ID of this layout set version.
	 *
	 * @return the theme ID of this layout set version
	 */
	@AutoEscape
	public String getThemeId();

	/**
	 * Sets the theme ID of this layout set version.
	 *
	 * @param themeId the theme ID of this layout set version
	 */
	public void setThemeId(String themeId);

	/**
	 * Returns the color scheme ID of this layout set version.
	 *
	 * @return the color scheme ID of this layout set version
	 */
	@AutoEscape
	public String getColorSchemeId();

	/**
	 * Sets the color scheme ID of this layout set version.
	 *
	 * @param colorSchemeId the color scheme ID of this layout set version
	 */
	public void setColorSchemeId(String colorSchemeId);

	/**
	 * Returns the css of this layout set version.
	 *
	 * @return the css of this layout set version
	 */
	@AutoEscape
	public String getCss();

	/**
	 * Sets the css of this layout set version.
	 *
	 * @param css the css of this layout set version
	 */
	public void setCss(String css);

	/**
	 * Returns the page count of this layout set version.
	 *
	 * @return the page count of this layout set version
	 */
	public int getPageCount();

	/**
	 * Sets the page count of this layout set version.
	 *
	 * @param pageCount the page count of this layout set version
	 */
	public void setPageCount(int pageCount);

	/**
	 * Returns the settings of this layout set version.
	 *
	 * @return the settings of this layout set version
	 */
	@AutoEscape
	public String getSettings();

	/**
	 * Sets the settings of this layout set version.
	 *
	 * @param settings the settings of this layout set version
	 */
	public void setSettings(String settings);

	/**
	 * Returns the layout set prototype uuid of this layout set version.
	 *
	 * @return the layout set prototype uuid of this layout set version
	 */
	@AutoEscape
	public String getLayoutSetPrototypeUuid();

	/**
	 * Sets the layout set prototype uuid of this layout set version.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid of this layout set version
	 */
	public void setLayoutSetPrototypeUuid(String layoutSetPrototypeUuid);

	/**
	 * Returns the layout set prototype link enabled of this layout set version.
	 *
	 * @return the layout set prototype link enabled of this layout set version
	 */
	public boolean getLayoutSetPrototypeLinkEnabled();

	/**
	 * Returns <code>true</code> if this layout set version is layout set prototype link enabled.
	 *
	 * @return <code>true</code> if this layout set version is layout set prototype link enabled; <code>false</code> otherwise
	 */
	public boolean isLayoutSetPrototypeLinkEnabled();

	/**
	 * Sets whether this layout set version is layout set prototype link enabled.
	 *
	 * @param layoutSetPrototypeLinkEnabled the layout set prototype link enabled of this layout set version
	 */
	public void setLayoutSetPrototypeLinkEnabled(
		boolean layoutSetPrototypeLinkEnabled);

}