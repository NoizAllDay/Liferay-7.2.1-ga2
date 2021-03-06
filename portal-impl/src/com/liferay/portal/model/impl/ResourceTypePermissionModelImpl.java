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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.ResourceTypePermission;
import com.liferay.portal.kernel.model.ResourceTypePermissionModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ResourceTypePermission service. Represents a row in the &quot;ResourceTypePermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ResourceTypePermissionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ResourceTypePermissionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTypePermissionImpl
 * @deprecated As of Judson (7.1.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ResourceTypePermissionModelImpl
	extends BaseModelImpl<ResourceTypePermission>
	implements ResourceTypePermissionModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a resource type permission model instance should use the <code>ResourceTypePermission</code> interface instead.
	 */
	public static final String TABLE_NAME = "ResourceTypePermission";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT},
		{"resourceTypePermissionId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"roleId", Types.BIGINT}, {"actionIds", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("resourceTypePermissionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("roleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("actionIds", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ResourceTypePermission (mvccVersion LONG default 0 not null,resourceTypePermissionId LONG not null primary key,companyId LONG,groupId LONG,name VARCHAR(75) null,roleId LONG,actionIds LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table ResourceTypePermission";

	public static final String ORDER_BY_JPQL =
		" ORDER BY resourceTypePermission.resourceTypePermissionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ResourceTypePermission.resourceTypePermissionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.ResourceTypePermission"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.ResourceTypePermission"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.ResourceTypePermission"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long NAME_COLUMN_BITMASK = 4L;

	public static final long ROLEID_COLUMN_BITMASK = 8L;

	public static final long RESOURCETYPEPERMISSIONID_COLUMN_BITMASK = 16L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.ResourceTypePermission"));

	public ResourceTypePermissionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _resourceTypePermissionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setResourceTypePermissionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _resourceTypePermissionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ResourceTypePermission.class;
	}

	@Override
	public String getModelClassName() {
		return ResourceTypePermission.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ResourceTypePermission, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ResourceTypePermission, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ResourceTypePermission, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ResourceTypePermission)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ResourceTypePermission, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ResourceTypePermission, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ResourceTypePermission)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ResourceTypePermission, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ResourceTypePermission, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ResourceTypePermission>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ResourceTypePermission.class.getClassLoader(),
			ResourceTypePermission.class, ModelWrapper.class);

		try {
			Constructor<ResourceTypePermission> constructor =
				(Constructor<ResourceTypePermission>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<ResourceTypePermission, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ResourceTypePermission, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ResourceTypePermission, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ResourceTypePermission, Object>>();
		Map<String, BiConsumer<ResourceTypePermission, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<ResourceTypePermission, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", ResourceTypePermission::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<ResourceTypePermission, Long>)
				ResourceTypePermission::setMvccVersion);
		attributeGetterFunctions.put(
			"resourceTypePermissionId",
			ResourceTypePermission::getResourceTypePermissionId);
		attributeSetterBiConsumers.put(
			"resourceTypePermissionId",
			(BiConsumer<ResourceTypePermission, Long>)
				ResourceTypePermission::setResourceTypePermissionId);
		attributeGetterFunctions.put(
			"companyId", ResourceTypePermission::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ResourceTypePermission, Long>)
				ResourceTypePermission::setCompanyId);
		attributeGetterFunctions.put(
			"groupId", ResourceTypePermission::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ResourceTypePermission, Long>)
				ResourceTypePermission::setGroupId);
		attributeGetterFunctions.put("name", ResourceTypePermission::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<ResourceTypePermission, String>)
				ResourceTypePermission::setName);
		attributeGetterFunctions.put(
			"roleId", ResourceTypePermission::getRoleId);
		attributeSetterBiConsumers.put(
			"roleId",
			(BiConsumer<ResourceTypePermission, Long>)
				ResourceTypePermission::setRoleId);
		attributeGetterFunctions.put(
			"actionIds", ResourceTypePermission::getActionIds);
		attributeSetterBiConsumers.put(
			"actionIds",
			(BiConsumer<ResourceTypePermission, Long>)
				ResourceTypePermission::setActionIds);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getResourceTypePermissionId() {
		return _resourceTypePermissionId;
	}

	@Override
	public void setResourceTypePermissionId(long resourceTypePermissionId) {
		_resourceTypePermissionId = resourceTypePermissionId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_columnBitmask |= ROLEID_COLUMN_BITMASK;

		if (!_setOriginalRoleId) {
			_setOriginalRoleId = true;

			_originalRoleId = _roleId;
		}

		_roleId = roleId;
	}

	public long getOriginalRoleId() {
		return _originalRoleId;
	}

	@Override
	public long getActionIds() {
		return _actionIds;
	}

	@Override
	public void setActionIds(long actionIds) {
		_actionIds = actionIds;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ResourceTypePermission.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ResourceTypePermission toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ResourceTypePermission>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ResourceTypePermissionImpl resourceTypePermissionImpl =
			new ResourceTypePermissionImpl();

		resourceTypePermissionImpl.setMvccVersion(getMvccVersion());
		resourceTypePermissionImpl.setResourceTypePermissionId(
			getResourceTypePermissionId());
		resourceTypePermissionImpl.setCompanyId(getCompanyId());
		resourceTypePermissionImpl.setGroupId(getGroupId());
		resourceTypePermissionImpl.setName(getName());
		resourceTypePermissionImpl.setRoleId(getRoleId());
		resourceTypePermissionImpl.setActionIds(getActionIds());

		resourceTypePermissionImpl.resetOriginalValues();

		return resourceTypePermissionImpl;
	}

	@Override
	public int compareTo(ResourceTypePermission resourceTypePermission) {
		long primaryKey = resourceTypePermission.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResourceTypePermission)) {
			return false;
		}

		ResourceTypePermission resourceTypePermission =
			(ResourceTypePermission)obj;

		long primaryKey = resourceTypePermission.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ResourceTypePermissionModelImpl resourceTypePermissionModelImpl = this;

		resourceTypePermissionModelImpl._originalCompanyId =
			resourceTypePermissionModelImpl._companyId;

		resourceTypePermissionModelImpl._setOriginalCompanyId = false;

		resourceTypePermissionModelImpl._originalGroupId =
			resourceTypePermissionModelImpl._groupId;

		resourceTypePermissionModelImpl._setOriginalGroupId = false;

		resourceTypePermissionModelImpl._originalName =
			resourceTypePermissionModelImpl._name;

		resourceTypePermissionModelImpl._originalRoleId =
			resourceTypePermissionModelImpl._roleId;

		resourceTypePermissionModelImpl._setOriginalRoleId = false;

		resourceTypePermissionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ResourceTypePermission> toCacheModel() {
		ResourceTypePermissionCacheModel resourceTypePermissionCacheModel =
			new ResourceTypePermissionCacheModel();

		resourceTypePermissionCacheModel.mvccVersion = getMvccVersion();

		resourceTypePermissionCacheModel.resourceTypePermissionId =
			getResourceTypePermissionId();

		resourceTypePermissionCacheModel.companyId = getCompanyId();

		resourceTypePermissionCacheModel.groupId = getGroupId();

		resourceTypePermissionCacheModel.name = getName();

		String name = resourceTypePermissionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			resourceTypePermissionCacheModel.name = null;
		}

		resourceTypePermissionCacheModel.roleId = getRoleId();

		resourceTypePermissionCacheModel.actionIds = getActionIds();

		return resourceTypePermissionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ResourceTypePermission, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ResourceTypePermission, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ResourceTypePermission, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((ResourceTypePermission)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ResourceTypePermission, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ResourceTypePermission, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ResourceTypePermission, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((ResourceTypePermission)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ResourceTypePermission>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _resourceTypePermissionId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _name;
	private String _originalName;
	private long _roleId;
	private long _originalRoleId;
	private boolean _setOriginalRoleId;
	private long _actionIds;
	private long _columnBitmask;
	private ResourceTypePermission _escapedModel;

}