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

package com.liferay.portal.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LayoutSet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LayoutSetCacheModel
	implements CacheModel<LayoutSet>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LayoutSetCacheModel)) {
			return false;
		}

		LayoutSetCacheModel layoutSetCacheModel = (LayoutSetCacheModel)obj;

		if ((layoutSetId == layoutSetCacheModel.layoutSetId) &&
			(mvccVersion == layoutSetCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, layoutSetId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", headId=");
		sb.append(headId);
		sb.append(", layoutSetId=");
		sb.append(layoutSetId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", privateLayout=");
		sb.append(privateLayout);
		sb.append(", logoId=");
		sb.append(logoId);
		sb.append(", themeId=");
		sb.append(themeId);
		sb.append(", colorSchemeId=");
		sb.append(colorSchemeId);
		sb.append(", css=");
		sb.append(css);
		sb.append(", pageCount=");
		sb.append(pageCount);
		sb.append(", settings=");
		sb.append(settings);
		sb.append(", layoutSetPrototypeUuid=");
		sb.append(layoutSetPrototypeUuid);
		sb.append(", layoutSetPrototypeLinkEnabled=");
		sb.append(layoutSetPrototypeLinkEnabled);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LayoutSet toEntityModel() {
		LayoutSetImpl layoutSetImpl = new LayoutSetImpl();

		layoutSetImpl.setMvccVersion(mvccVersion);
		layoutSetImpl.setHeadId(headId);
		layoutSetImpl.setHead(head);
		layoutSetImpl.setLayoutSetId(layoutSetId);
		layoutSetImpl.setGroupId(groupId);
		layoutSetImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			layoutSetImpl.setCreateDate(null);
		}
		else {
			layoutSetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			layoutSetImpl.setModifiedDate(null);
		}
		else {
			layoutSetImpl.setModifiedDate(new Date(modifiedDate));
		}

		layoutSetImpl.setPrivateLayout(privateLayout);
		layoutSetImpl.setLogoId(logoId);

		if (themeId == null) {
			layoutSetImpl.setThemeId("");
		}
		else {
			layoutSetImpl.setThemeId(themeId);
		}

		if (colorSchemeId == null) {
			layoutSetImpl.setColorSchemeId("");
		}
		else {
			layoutSetImpl.setColorSchemeId(colorSchemeId);
		}

		if (css == null) {
			layoutSetImpl.setCss("");
		}
		else {
			layoutSetImpl.setCss(css);
		}

		layoutSetImpl.setPageCount(pageCount);

		if (settings == null) {
			layoutSetImpl.setSettings("");
		}
		else {
			layoutSetImpl.setSettings(settings);
		}

		if (layoutSetPrototypeUuid == null) {
			layoutSetImpl.setLayoutSetPrototypeUuid("");
		}
		else {
			layoutSetImpl.setLayoutSetPrototypeUuid(layoutSetPrototypeUuid);
		}

		layoutSetImpl.setLayoutSetPrototypeLinkEnabled(
			layoutSetPrototypeLinkEnabled);

		layoutSetImpl.resetOriginalValues();

		layoutSetImpl.setCompanyFallbackVirtualHostname(
			_companyFallbackVirtualHostname);

		layoutSetImpl.setVirtualHostname(_virtualHostname);

		return layoutSetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		mvccVersion = objectInput.readLong();

		headId = objectInput.readLong();

		head = objectInput.readBoolean();

		layoutSetId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		privateLayout = objectInput.readBoolean();

		logoId = objectInput.readLong();
		themeId = objectInput.readUTF();
		colorSchemeId = objectInput.readUTF();
		css = objectInput.readUTF();

		pageCount = objectInput.readInt();
		settings = objectInput.readUTF();
		layoutSetPrototypeUuid = objectInput.readUTF();

		layoutSetPrototypeLinkEnabled = objectInput.readBoolean();

		_companyFallbackVirtualHostname = (String)objectInput.readObject();
		_virtualHostname = (String)objectInput.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(headId);

		objectOutput.writeBoolean(head);

		objectOutput.writeLong(layoutSetId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(privateLayout);

		objectOutput.writeLong(logoId);

		if (themeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(themeId);
		}

		if (colorSchemeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(colorSchemeId);
		}

		if (css == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(css);
		}

		objectOutput.writeInt(pageCount);

		if (settings == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(settings);
		}

		if (layoutSetPrototypeUuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(layoutSetPrototypeUuid);
		}

		objectOutput.writeBoolean(layoutSetPrototypeLinkEnabled);

		objectOutput.writeObject(_companyFallbackVirtualHostname);
		objectOutput.writeObject(_virtualHostname);
	}

	public long mvccVersion;
	public long headId;
	public boolean head;
	public long layoutSetId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public boolean privateLayout;
	public long logoId;
	public String themeId;
	public String colorSchemeId;
	public String css;
	public int pageCount;
	public String settings;
	public String layoutSetPrototypeUuid;
	public boolean layoutSetPrototypeLinkEnabled;
	public String _companyFallbackVirtualHostname;
	public String _virtualHostname;

}