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

package com.liferay.journal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.journal.model.JournalArticleResource;
import com.liferay.journal.model.JournalArticleResourceModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
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
 * The base model implementation for the JournalArticleResource service. Represents a row in the &quot;JournalArticleResource&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>JournalArticleResourceModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JournalArticleResourceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleResourceImpl
 * @generated
 */
public class JournalArticleResourceModelImpl
	extends BaseModelImpl<JournalArticleResource>
	implements JournalArticleResourceModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a journal article resource model instance should use the <code>JournalArticleResource</code> interface instead.
	 */
	public static final String TABLE_NAME = "JournalArticleResource";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"resourcePrimKey", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"articleId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("resourcePrimKey", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("articleId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table JournalArticleResource (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,resourcePrimKey LONG not null primary key,groupId LONG,companyId LONG,articleId VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table JournalArticleResource";

	public static final String ORDER_BY_JPQL =
		" ORDER BY journalArticleResource.resourcePrimKey ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY JournalArticleResource.resourcePrimKey ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long ARTICLEID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long RESOURCEPRIMKEY_COLUMN_BITMASK = 16L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public JournalArticleResourceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _resourcePrimKey;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setResourcePrimKey(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _resourcePrimKey;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JournalArticleResource.class;
	}

	@Override
	public String getModelClassName() {
		return JournalArticleResource.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<JournalArticleResource, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<JournalArticleResource, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JournalArticleResource, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((JournalArticleResource)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<JournalArticleResource, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<JournalArticleResource, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(JournalArticleResource)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<JournalArticleResource, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<JournalArticleResource, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, JournalArticleResource>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			JournalArticleResource.class.getClassLoader(),
			JournalArticleResource.class, ModelWrapper.class);

		try {
			Constructor<JournalArticleResource> constructor =
				(Constructor<JournalArticleResource>)proxyClass.getConstructor(
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

	private static final Map<String, Function<JournalArticleResource, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<JournalArticleResource, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<JournalArticleResource, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<JournalArticleResource, Object>>();
		Map<String, BiConsumer<JournalArticleResource, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<JournalArticleResource, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", JournalArticleResource::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<JournalArticleResource, Long>)
				JournalArticleResource::setMvccVersion);
		attributeGetterFunctions.put("uuid", JournalArticleResource::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<JournalArticleResource, String>)
				JournalArticleResource::setUuid);
		attributeGetterFunctions.put(
			"resourcePrimKey", JournalArticleResource::getResourcePrimKey);
		attributeSetterBiConsumers.put(
			"resourcePrimKey",
			(BiConsumer<JournalArticleResource, Long>)
				JournalArticleResource::setResourcePrimKey);
		attributeGetterFunctions.put(
			"groupId", JournalArticleResource::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<JournalArticleResource, Long>)
				JournalArticleResource::setGroupId);
		attributeGetterFunctions.put(
			"companyId", JournalArticleResource::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<JournalArticleResource, Long>)
				JournalArticleResource::setCompanyId);
		attributeGetterFunctions.put(
			"articleId", JournalArticleResource::getArticleId);
		attributeSetterBiConsumers.put(
			"articleId",
			(BiConsumer<JournalArticleResource, String>)
				JournalArticleResource::setArticleId);

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
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
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
	public String getArticleId() {
		if (_articleId == null) {
			return "";
		}
		else {
			return _articleId;
		}
	}

	@Override
	public void setArticleId(String articleId) {
		_columnBitmask |= ARTICLEID_COLUMN_BITMASK;

		if (_originalArticleId == null) {
			_originalArticleId = _articleId;
		}

		_articleId = articleId;
	}

	public String getOriginalArticleId() {
		return GetterUtil.getString(_originalArticleId);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), JournalArticleResource.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JournalArticleResource toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, JournalArticleResource>
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
		JournalArticleResourceImpl journalArticleResourceImpl =
			new JournalArticleResourceImpl();

		journalArticleResourceImpl.setMvccVersion(getMvccVersion());
		journalArticleResourceImpl.setUuid(getUuid());
		journalArticleResourceImpl.setResourcePrimKey(getResourcePrimKey());
		journalArticleResourceImpl.setGroupId(getGroupId());
		journalArticleResourceImpl.setCompanyId(getCompanyId());
		journalArticleResourceImpl.setArticleId(getArticleId());

		journalArticleResourceImpl.resetOriginalValues();

		return journalArticleResourceImpl;
	}

	@Override
	public int compareTo(JournalArticleResource journalArticleResource) {
		long primaryKey = journalArticleResource.getPrimaryKey();

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

		if (!(obj instanceof JournalArticleResource)) {
			return false;
		}

		JournalArticleResource journalArticleResource =
			(JournalArticleResource)obj;

		long primaryKey = journalArticleResource.getPrimaryKey();

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
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		JournalArticleResourceModelImpl journalArticleResourceModelImpl = this;

		journalArticleResourceModelImpl._originalUuid =
			journalArticleResourceModelImpl._uuid;

		journalArticleResourceModelImpl._originalGroupId =
			journalArticleResourceModelImpl._groupId;

		journalArticleResourceModelImpl._setOriginalGroupId = false;

		journalArticleResourceModelImpl._originalCompanyId =
			journalArticleResourceModelImpl._companyId;

		journalArticleResourceModelImpl._setOriginalCompanyId = false;

		journalArticleResourceModelImpl._originalArticleId =
			journalArticleResourceModelImpl._articleId;

		journalArticleResourceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JournalArticleResource> toCacheModel() {
		JournalArticleResourceCacheModel journalArticleResourceCacheModel =
			new JournalArticleResourceCacheModel();

		journalArticleResourceCacheModel.mvccVersion = getMvccVersion();

		journalArticleResourceCacheModel.uuid = getUuid();

		String uuid = journalArticleResourceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			journalArticleResourceCacheModel.uuid = null;
		}

		journalArticleResourceCacheModel.resourcePrimKey = getResourcePrimKey();

		journalArticleResourceCacheModel.groupId = getGroupId();

		journalArticleResourceCacheModel.companyId = getCompanyId();

		journalArticleResourceCacheModel.articleId = getArticleId();

		String articleId = journalArticleResourceCacheModel.articleId;

		if ((articleId != null) && (articleId.length() == 0)) {
			journalArticleResourceCacheModel.articleId = null;
		}

		return journalArticleResourceCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<JournalArticleResource, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<JournalArticleResource, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JournalArticleResource, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((JournalArticleResource)this));
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
		Map<String, Function<JournalArticleResource, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<JournalArticleResource, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JournalArticleResource, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((JournalArticleResource)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, JournalArticleResource>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _resourcePrimKey;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private String _articleId;
	private String _originalArticleId;
	private long _columnBitmask;
	private JournalArticleResource _escapedModel;

}