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

package com.liferay.layout.seo.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.layout.seo.model.LayoutSEOEntry;
import com.liferay.layout.seo.model.LayoutSEOEntryModel;
import com.liferay.layout.seo.model.LayoutSEOEntrySoap;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the LayoutSEOEntry service. Represents a row in the &quot;LayoutSEOEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>LayoutSEOEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LayoutSEOEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSEOEntryImpl
 * @generated
 */
@JSON(strict = true)
public class LayoutSEOEntryModelImpl
	extends BaseModelImpl<LayoutSEOEntry> implements LayoutSEOEntryModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a layout seo entry model instance should use the <code>LayoutSEOEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "LayoutSEOEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"layoutSEOEntryId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"privateLayout", Types.BOOLEAN},
		{"layoutId", Types.BIGINT}, {"enabled", Types.BOOLEAN},
		{"canonicalURL", Types.VARCHAR}, {"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("layoutSEOEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("privateLayout", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("layoutId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("enabled", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("canonicalURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table LayoutSEOEntry (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,layoutSEOEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,privateLayout BOOLEAN,layoutId LONG,enabled BOOLEAN,canonicalURL STRING null,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table LayoutSEOEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY layoutSEOEntry.layoutSEOEntryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY LayoutSEOEntry.layoutSEOEntryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long LAYOUTID_COLUMN_BITMASK = 4L;

	public static final long PRIVATELAYOUT_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	public static final long LAYOUTSEOENTRYID_COLUMN_BITMASK = 32L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LayoutSEOEntry toModel(LayoutSEOEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LayoutSEOEntry model = new LayoutSEOEntryImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setLayoutSEOEntryId(soapModel.getLayoutSEOEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPrivateLayout(soapModel.isPrivateLayout());
		model.setLayoutId(soapModel.getLayoutId());
		model.setEnabled(soapModel.isEnabled());
		model.setCanonicalURL(soapModel.getCanonicalURL());
		model.setLastPublishDate(soapModel.getLastPublishDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LayoutSEOEntry> toModels(
		LayoutSEOEntrySoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<LayoutSEOEntry> models = new ArrayList<LayoutSEOEntry>(
			soapModels.length);

		for (LayoutSEOEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public LayoutSEOEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _layoutSEOEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLayoutSEOEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _layoutSEOEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LayoutSEOEntry.class;
	}

	@Override
	public String getModelClassName() {
		return LayoutSEOEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LayoutSEOEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LayoutSEOEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LayoutSEOEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((LayoutSEOEntry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LayoutSEOEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LayoutSEOEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(LayoutSEOEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<LayoutSEOEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LayoutSEOEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, LayoutSEOEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			LayoutSEOEntry.class.getClassLoader(), LayoutSEOEntry.class,
			ModelWrapper.class);

		try {
			Constructor<LayoutSEOEntry> constructor =
				(Constructor<LayoutSEOEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<LayoutSEOEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<LayoutSEOEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<LayoutSEOEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<LayoutSEOEntry, Object>>();
		Map<String, BiConsumer<LayoutSEOEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<LayoutSEOEntry, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", LayoutSEOEntry::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<LayoutSEOEntry, Long>)LayoutSEOEntry::setMvccVersion);
		attributeGetterFunctions.put("uuid", LayoutSEOEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<LayoutSEOEntry, String>)LayoutSEOEntry::setUuid);
		attributeGetterFunctions.put(
			"layoutSEOEntryId", LayoutSEOEntry::getLayoutSEOEntryId);
		attributeSetterBiConsumers.put(
			"layoutSEOEntryId",
			(BiConsumer<LayoutSEOEntry, Long>)
				LayoutSEOEntry::setLayoutSEOEntryId);
		attributeGetterFunctions.put("groupId", LayoutSEOEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<LayoutSEOEntry, Long>)LayoutSEOEntry::setGroupId);
		attributeGetterFunctions.put("companyId", LayoutSEOEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<LayoutSEOEntry, Long>)LayoutSEOEntry::setCompanyId);
		attributeGetterFunctions.put("userId", LayoutSEOEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<LayoutSEOEntry, Long>)LayoutSEOEntry::setUserId);
		attributeGetterFunctions.put("userName", LayoutSEOEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<LayoutSEOEntry, String>)LayoutSEOEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", LayoutSEOEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<LayoutSEOEntry, Date>)LayoutSEOEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", LayoutSEOEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<LayoutSEOEntry, Date>)LayoutSEOEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"privateLayout", LayoutSEOEntry::getPrivateLayout);
		attributeSetterBiConsumers.put(
			"privateLayout",
			(BiConsumer<LayoutSEOEntry, Boolean>)
				LayoutSEOEntry::setPrivateLayout);
		attributeGetterFunctions.put("layoutId", LayoutSEOEntry::getLayoutId);
		attributeSetterBiConsumers.put(
			"layoutId",
			(BiConsumer<LayoutSEOEntry, Long>)LayoutSEOEntry::setLayoutId);
		attributeGetterFunctions.put("enabled", LayoutSEOEntry::getEnabled);
		attributeSetterBiConsumers.put(
			"enabled",
			(BiConsumer<LayoutSEOEntry, Boolean>)LayoutSEOEntry::setEnabled);
		attributeGetterFunctions.put(
			"canonicalURL", LayoutSEOEntry::getCanonicalURL);
		attributeSetterBiConsumers.put(
			"canonicalURL",
			(BiConsumer<LayoutSEOEntry, String>)
				LayoutSEOEntry::setCanonicalURL);
		attributeGetterFunctions.put(
			"lastPublishDate", LayoutSEOEntry::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<LayoutSEOEntry, Date>)
				LayoutSEOEntry::setLastPublishDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
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

	@JSON
	@Override
	public long getLayoutSEOEntryId() {
		return _layoutSEOEntryId;
	}

	@Override
	public void setLayoutSEOEntryId(long layoutSEOEntryId) {
		_layoutSEOEntryId = layoutSEOEntryId;
	}

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public boolean getPrivateLayout() {
		return _privateLayout;
	}

	@JSON
	@Override
	public boolean isPrivateLayout() {
		return _privateLayout;
	}

	@Override
	public void setPrivateLayout(boolean privateLayout) {
		_columnBitmask |= PRIVATELAYOUT_COLUMN_BITMASK;

		if (!_setOriginalPrivateLayout) {
			_setOriginalPrivateLayout = true;

			_originalPrivateLayout = _privateLayout;
		}

		_privateLayout = privateLayout;
	}

	public boolean getOriginalPrivateLayout() {
		return _originalPrivateLayout;
	}

	@JSON
	@Override
	public long getLayoutId() {
		return _layoutId;
	}

	@Override
	public void setLayoutId(long layoutId) {
		_columnBitmask |= LAYOUTID_COLUMN_BITMASK;

		if (!_setOriginalLayoutId) {
			_setOriginalLayoutId = true;

			_originalLayoutId = _layoutId;
		}

		_layoutId = layoutId;
	}

	public long getOriginalLayoutId() {
		return _originalLayoutId;
	}

	@JSON
	@Override
	public boolean getEnabled() {
		return _enabled;
	}

	@JSON
	@Override
	public boolean isEnabled() {
		return _enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		_enabled = enabled;
	}

	@JSON
	@Override
	public String getCanonicalURL() {
		if (_canonicalURL == null) {
			return "";
		}
		else {
			return _canonicalURL;
		}
	}

	@Override
	public String getCanonicalURL(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getCanonicalURL(languageId);
	}

	@Override
	public String getCanonicalURL(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getCanonicalURL(languageId, useDefault);
	}

	@Override
	public String getCanonicalURL(String languageId) {
		return LocalizationUtil.getLocalization(getCanonicalURL(), languageId);
	}

	@Override
	public String getCanonicalURL(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getCanonicalURL(), languageId, useDefault);
	}

	@Override
	public String getCanonicalURLCurrentLanguageId() {
		return _canonicalURLCurrentLanguageId;
	}

	@JSON
	@Override
	public String getCanonicalURLCurrentValue() {
		Locale locale = getLocale(_canonicalURLCurrentLanguageId);

		return getCanonicalURL(locale);
	}

	@Override
	public Map<Locale, String> getCanonicalURLMap() {
		return LocalizationUtil.getLocalizationMap(getCanonicalURL());
	}

	@Override
	public void setCanonicalURL(String canonicalURL) {
		_canonicalURL = canonicalURL;
	}

	@Override
	public void setCanonicalURL(String canonicalURL, Locale locale) {
		setCanonicalURL(canonicalURL, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setCanonicalURL(
		String canonicalURL, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(canonicalURL)) {
			setCanonicalURL(
				LocalizationUtil.updateLocalization(
					getCanonicalURL(), "CanonicalURL", canonicalURL, languageId,
					defaultLanguageId));
		}
		else {
			setCanonicalURL(
				LocalizationUtil.removeLocalization(
					getCanonicalURL(), "CanonicalURL", languageId));
		}
	}

	@Override
	public void setCanonicalURLCurrentLanguageId(String languageId) {
		_canonicalURLCurrentLanguageId = languageId;
	}

	@Override
	public void setCanonicalURLMap(Map<Locale, String> canonicalURLMap) {
		setCanonicalURLMap(canonicalURLMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setCanonicalURLMap(
		Map<Locale, String> canonicalURLMap, Locale defaultLocale) {

		if (canonicalURLMap == null) {
			return;
		}

		setCanonicalURL(
			LocalizationUtil.updateLocalization(
				canonicalURLMap, getCanonicalURL(), "CanonicalURL",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(LayoutSEOEntry.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), LayoutSEOEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> canonicalURLMap = getCanonicalURLMap();

		for (Map.Entry<Locale, String> entry : canonicalURLMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getCanonicalURL();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			LayoutSEOEntry.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String canonicalURL = getCanonicalURL(defaultLocale);

		if (Validator.isNull(canonicalURL)) {
			setCanonicalURL(
				getCanonicalURL(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setCanonicalURL(
				getCanonicalURL(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public LayoutSEOEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, LayoutSEOEntry>
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
		LayoutSEOEntryImpl layoutSEOEntryImpl = new LayoutSEOEntryImpl();

		layoutSEOEntryImpl.setMvccVersion(getMvccVersion());
		layoutSEOEntryImpl.setUuid(getUuid());
		layoutSEOEntryImpl.setLayoutSEOEntryId(getLayoutSEOEntryId());
		layoutSEOEntryImpl.setGroupId(getGroupId());
		layoutSEOEntryImpl.setCompanyId(getCompanyId());
		layoutSEOEntryImpl.setUserId(getUserId());
		layoutSEOEntryImpl.setUserName(getUserName());
		layoutSEOEntryImpl.setCreateDate(getCreateDate());
		layoutSEOEntryImpl.setModifiedDate(getModifiedDate());
		layoutSEOEntryImpl.setPrivateLayout(isPrivateLayout());
		layoutSEOEntryImpl.setLayoutId(getLayoutId());
		layoutSEOEntryImpl.setEnabled(isEnabled());
		layoutSEOEntryImpl.setCanonicalURL(getCanonicalURL());
		layoutSEOEntryImpl.setLastPublishDate(getLastPublishDate());

		layoutSEOEntryImpl.resetOriginalValues();

		return layoutSEOEntryImpl;
	}

	@Override
	public int compareTo(LayoutSEOEntry layoutSEOEntry) {
		long primaryKey = layoutSEOEntry.getPrimaryKey();

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

		if (!(obj instanceof LayoutSEOEntry)) {
			return false;
		}

		LayoutSEOEntry layoutSEOEntry = (LayoutSEOEntry)obj;

		long primaryKey = layoutSEOEntry.getPrimaryKey();

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
		LayoutSEOEntryModelImpl layoutSEOEntryModelImpl = this;

		layoutSEOEntryModelImpl._originalUuid = layoutSEOEntryModelImpl._uuid;

		layoutSEOEntryModelImpl._originalGroupId =
			layoutSEOEntryModelImpl._groupId;

		layoutSEOEntryModelImpl._setOriginalGroupId = false;

		layoutSEOEntryModelImpl._originalCompanyId =
			layoutSEOEntryModelImpl._companyId;

		layoutSEOEntryModelImpl._setOriginalCompanyId = false;

		layoutSEOEntryModelImpl._setModifiedDate = false;

		layoutSEOEntryModelImpl._originalPrivateLayout =
			layoutSEOEntryModelImpl._privateLayout;

		layoutSEOEntryModelImpl._setOriginalPrivateLayout = false;

		layoutSEOEntryModelImpl._originalLayoutId =
			layoutSEOEntryModelImpl._layoutId;

		layoutSEOEntryModelImpl._setOriginalLayoutId = false;

		layoutSEOEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LayoutSEOEntry> toCacheModel() {
		LayoutSEOEntryCacheModel layoutSEOEntryCacheModel =
			new LayoutSEOEntryCacheModel();

		layoutSEOEntryCacheModel.mvccVersion = getMvccVersion();

		layoutSEOEntryCacheModel.uuid = getUuid();

		String uuid = layoutSEOEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			layoutSEOEntryCacheModel.uuid = null;
		}

		layoutSEOEntryCacheModel.layoutSEOEntryId = getLayoutSEOEntryId();

		layoutSEOEntryCacheModel.groupId = getGroupId();

		layoutSEOEntryCacheModel.companyId = getCompanyId();

		layoutSEOEntryCacheModel.userId = getUserId();

		layoutSEOEntryCacheModel.userName = getUserName();

		String userName = layoutSEOEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			layoutSEOEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			layoutSEOEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			layoutSEOEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			layoutSEOEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			layoutSEOEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		layoutSEOEntryCacheModel.privateLayout = isPrivateLayout();

		layoutSEOEntryCacheModel.layoutId = getLayoutId();

		layoutSEOEntryCacheModel.enabled = isEnabled();

		layoutSEOEntryCacheModel.canonicalURL = getCanonicalURL();

		String canonicalURL = layoutSEOEntryCacheModel.canonicalURL;

		if ((canonicalURL != null) && (canonicalURL.length() == 0)) {
			layoutSEOEntryCacheModel.canonicalURL = null;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			layoutSEOEntryCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			layoutSEOEntryCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return layoutSEOEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<LayoutSEOEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<LayoutSEOEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LayoutSEOEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((LayoutSEOEntry)this));
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
		Map<String, Function<LayoutSEOEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<LayoutSEOEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LayoutSEOEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((LayoutSEOEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, LayoutSEOEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _layoutSEOEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _privateLayout;
	private boolean _originalPrivateLayout;
	private boolean _setOriginalPrivateLayout;
	private long _layoutId;
	private long _originalLayoutId;
	private boolean _setOriginalLayoutId;
	private boolean _enabled;
	private String _canonicalURL;
	private String _canonicalURLCurrentLanguageId;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private LayoutSEOEntry _escapedModel;

}