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

package com.liferay.portal.security.audit.storage.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.model.AuditEventModel;
import com.liferay.portal.security.audit.storage.model.AuditEventSoap;

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
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the AuditEvent service. Represents a row in the &quot;Audit_AuditEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>AuditEventModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuditEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventImpl
 * @generated
 */
@JSON(strict = true)
public class AuditEventModelImpl
	extends BaseModelImpl<AuditEvent> implements AuditEventModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a audit event model instance should use the <code>AuditEvent</code> interface instead.
	 */
	public static final String TABLE_NAME = "Audit_AuditEvent";

	public static final Object[][] TABLE_COLUMNS = {
		{"auditEventId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"eventType", Types.VARCHAR},
		{"className", Types.VARCHAR}, {"classPK", Types.VARCHAR},
		{"message", Types.VARCHAR}, {"clientHost", Types.VARCHAR},
		{"clientIP", Types.VARCHAR}, {"serverName", Types.VARCHAR},
		{"serverPort", Types.INTEGER}, {"sessionID", Types.VARCHAR},
		{"additionalInfo", Types.CLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("auditEventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("eventType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("className", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("classPK", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("message", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("clientHost", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("clientIP", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serverName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serverPort", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("sessionID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("additionalInfo", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Audit_AuditEvent (auditEventId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,eventType VARCHAR(75) null,className VARCHAR(200) null,classPK VARCHAR(75) null,message STRING null,clientHost VARCHAR(255) null,clientIP VARCHAR(255) null,serverName VARCHAR(255) null,serverPort INTEGER,sessionID VARCHAR(255) null,additionalInfo TEXT null)";

	public static final String TABLE_SQL_DROP = "drop table Audit_AuditEvent";

	public static final String ORDER_BY_JPQL =
		" ORDER BY auditEvent.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Audit_AuditEvent.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long CREATEDATE_COLUMN_BITMASK = 2L;

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
	public static AuditEvent toModel(AuditEventSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AuditEvent model = new AuditEventImpl();

		model.setAuditEventId(soapModel.getAuditEventId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setEventType(soapModel.getEventType());
		model.setClassName(soapModel.getClassName());
		model.setClassPK(soapModel.getClassPK());
		model.setMessage(soapModel.getMessage());
		model.setClientHost(soapModel.getClientHost());
		model.setClientIP(soapModel.getClientIP());
		model.setServerName(soapModel.getServerName());
		model.setServerPort(soapModel.getServerPort());
		model.setSessionID(soapModel.getSessionID());
		model.setAdditionalInfo(soapModel.getAdditionalInfo());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AuditEvent> toModels(AuditEventSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AuditEvent> models = new ArrayList<AuditEvent>(soapModels.length);

		for (AuditEventSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public AuditEventModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _auditEventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAuditEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _auditEventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AuditEvent.class;
	}

	@Override
	public String getModelClassName() {
		return AuditEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AuditEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AuditEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AuditEvent, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((AuditEvent)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AuditEvent, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AuditEvent, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AuditEvent)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AuditEvent, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AuditEvent, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AuditEvent>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AuditEvent.class.getClassLoader(), AuditEvent.class,
			ModelWrapper.class);

		try {
			Constructor<AuditEvent> constructor =
				(Constructor<AuditEvent>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AuditEvent, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AuditEvent, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AuditEvent, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AuditEvent, Object>>();
		Map<String, BiConsumer<AuditEvent, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AuditEvent, ?>>();

		attributeGetterFunctions.put(
			"auditEventId", AuditEvent::getAuditEventId);
		attributeSetterBiConsumers.put(
			"auditEventId",
			(BiConsumer<AuditEvent, Long>)AuditEvent::setAuditEventId);
		attributeGetterFunctions.put("companyId", AuditEvent::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<AuditEvent, Long>)AuditEvent::setCompanyId);
		attributeGetterFunctions.put("userId", AuditEvent::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<AuditEvent, Long>)AuditEvent::setUserId);
		attributeGetterFunctions.put("userName", AuditEvent::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<AuditEvent, String>)AuditEvent::setUserName);
		attributeGetterFunctions.put("createDate", AuditEvent::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AuditEvent, Date>)AuditEvent::setCreateDate);
		attributeGetterFunctions.put("eventType", AuditEvent::getEventType);
		attributeSetterBiConsumers.put(
			"eventType",
			(BiConsumer<AuditEvent, String>)AuditEvent::setEventType);
		attributeGetterFunctions.put("className", AuditEvent::getClassName);
		attributeSetterBiConsumers.put(
			"className",
			(BiConsumer<AuditEvent, String>)AuditEvent::setClassName);
		attributeGetterFunctions.put("classPK", AuditEvent::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK", (BiConsumer<AuditEvent, String>)AuditEvent::setClassPK);
		attributeGetterFunctions.put("message", AuditEvent::getMessage);
		attributeSetterBiConsumers.put(
			"message", (BiConsumer<AuditEvent, String>)AuditEvent::setMessage);
		attributeGetterFunctions.put("clientHost", AuditEvent::getClientHost);
		attributeSetterBiConsumers.put(
			"clientHost",
			(BiConsumer<AuditEvent, String>)AuditEvent::setClientHost);
		attributeGetterFunctions.put("clientIP", AuditEvent::getClientIP);
		attributeSetterBiConsumers.put(
			"clientIP",
			(BiConsumer<AuditEvent, String>)AuditEvent::setClientIP);
		attributeGetterFunctions.put("serverName", AuditEvent::getServerName);
		attributeSetterBiConsumers.put(
			"serverName",
			(BiConsumer<AuditEvent, String>)AuditEvent::setServerName);
		attributeGetterFunctions.put("serverPort", AuditEvent::getServerPort);
		attributeSetterBiConsumers.put(
			"serverPort",
			(BiConsumer<AuditEvent, Integer>)AuditEvent::setServerPort);
		attributeGetterFunctions.put("sessionID", AuditEvent::getSessionID);
		attributeSetterBiConsumers.put(
			"sessionID",
			(BiConsumer<AuditEvent, String>)AuditEvent::setSessionID);
		attributeGetterFunctions.put(
			"additionalInfo", AuditEvent::getAdditionalInfo);
		attributeSetterBiConsumers.put(
			"additionalInfo",
			(BiConsumer<AuditEvent, String>)AuditEvent::setAdditionalInfo);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getAuditEventId() {
		return _auditEventId;
	}

	@Override
	public void setAuditEventId(long auditEventId) {
		_auditEventId = auditEventId;
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
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public String getEventType() {
		if (_eventType == null) {
			return "";
		}
		else {
			return _eventType;
		}
	}

	@Override
	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	@JSON
	@Override
	public String getClassName() {
		if (_className == null) {
			return "";
		}
		else {
			return _className;
		}
	}

	@Override
	public void setClassName(String className) {
		_className = className;
	}

	@JSON
	@Override
	public String getClassPK() {
		if (_classPK == null) {
			return "";
		}
		else {
			return _classPK;
		}
	}

	@Override
	public void setClassPK(String classPK) {
		_classPK = classPK;
	}

	@JSON
	@Override
	public String getMessage() {
		if (_message == null) {
			return "";
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		_message = message;
	}

	@JSON
	@Override
	public String getClientHost() {
		if (_clientHost == null) {
			return "";
		}
		else {
			return _clientHost;
		}
	}

	@Override
	public void setClientHost(String clientHost) {
		_clientHost = clientHost;
	}

	@JSON
	@Override
	public String getClientIP() {
		if (_clientIP == null) {
			return "";
		}
		else {
			return _clientIP;
		}
	}

	@Override
	public void setClientIP(String clientIP) {
		_clientIP = clientIP;
	}

	@JSON
	@Override
	public String getServerName() {
		if (_serverName == null) {
			return "";
		}
		else {
			return _serverName;
		}
	}

	@Override
	public void setServerName(String serverName) {
		_serverName = serverName;
	}

	@JSON
	@Override
	public int getServerPort() {
		return _serverPort;
	}

	@Override
	public void setServerPort(int serverPort) {
		_serverPort = serverPort;
	}

	@JSON
	@Override
	public String getSessionID() {
		if (_sessionID == null) {
			return "";
		}
		else {
			return _sessionID;
		}
	}

	@Override
	public void setSessionID(String sessionID) {
		_sessionID = sessionID;
	}

	@JSON
	@Override
	public String getAdditionalInfo() {
		if (_additionalInfo == null) {
			return "";
		}
		else {
			return _additionalInfo;
		}
	}

	@Override
	public void setAdditionalInfo(String additionalInfo) {
		_additionalInfo = additionalInfo;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), AuditEvent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AuditEvent toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AuditEvent>
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
		AuditEventImpl auditEventImpl = new AuditEventImpl();

		auditEventImpl.setAuditEventId(getAuditEventId());
		auditEventImpl.setCompanyId(getCompanyId());
		auditEventImpl.setUserId(getUserId());
		auditEventImpl.setUserName(getUserName());
		auditEventImpl.setCreateDate(getCreateDate());
		auditEventImpl.setEventType(getEventType());
		auditEventImpl.setClassName(getClassName());
		auditEventImpl.setClassPK(getClassPK());
		auditEventImpl.setMessage(getMessage());
		auditEventImpl.setClientHost(getClientHost());
		auditEventImpl.setClientIP(getClientIP());
		auditEventImpl.setServerName(getServerName());
		auditEventImpl.setServerPort(getServerPort());
		auditEventImpl.setSessionID(getSessionID());
		auditEventImpl.setAdditionalInfo(getAdditionalInfo());

		auditEventImpl.resetOriginalValues();

		return auditEventImpl;
	}

	@Override
	public int compareTo(AuditEvent auditEvent) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), auditEvent.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuditEvent)) {
			return false;
		}

		AuditEvent auditEvent = (AuditEvent)obj;

		long primaryKey = auditEvent.getPrimaryKey();

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
		AuditEventModelImpl auditEventModelImpl = this;

		auditEventModelImpl._originalCompanyId = auditEventModelImpl._companyId;

		auditEventModelImpl._setOriginalCompanyId = false;

		auditEventModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AuditEvent> toCacheModel() {
		AuditEventCacheModel auditEventCacheModel = new AuditEventCacheModel();

		auditEventCacheModel.auditEventId = getAuditEventId();

		auditEventCacheModel.companyId = getCompanyId();

		auditEventCacheModel.userId = getUserId();

		auditEventCacheModel.userName = getUserName();

		String userName = auditEventCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			auditEventCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			auditEventCacheModel.createDate = createDate.getTime();
		}
		else {
			auditEventCacheModel.createDate = Long.MIN_VALUE;
		}

		auditEventCacheModel.eventType = getEventType();

		String eventType = auditEventCacheModel.eventType;

		if ((eventType != null) && (eventType.length() == 0)) {
			auditEventCacheModel.eventType = null;
		}

		auditEventCacheModel.className = getClassName();

		String className = auditEventCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			auditEventCacheModel.className = null;
		}

		auditEventCacheModel.classPK = getClassPK();

		String classPK = auditEventCacheModel.classPK;

		if ((classPK != null) && (classPK.length() == 0)) {
			auditEventCacheModel.classPK = null;
		}

		auditEventCacheModel.message = getMessage();

		String message = auditEventCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			auditEventCacheModel.message = null;
		}

		auditEventCacheModel.clientHost = getClientHost();

		String clientHost = auditEventCacheModel.clientHost;

		if ((clientHost != null) && (clientHost.length() == 0)) {
			auditEventCacheModel.clientHost = null;
		}

		auditEventCacheModel.clientIP = getClientIP();

		String clientIP = auditEventCacheModel.clientIP;

		if ((clientIP != null) && (clientIP.length() == 0)) {
			auditEventCacheModel.clientIP = null;
		}

		auditEventCacheModel.serverName = getServerName();

		String serverName = auditEventCacheModel.serverName;

		if ((serverName != null) && (serverName.length() == 0)) {
			auditEventCacheModel.serverName = null;
		}

		auditEventCacheModel.serverPort = getServerPort();

		auditEventCacheModel.sessionID = getSessionID();

		String sessionID = auditEventCacheModel.sessionID;

		if ((sessionID != null) && (sessionID.length() == 0)) {
			auditEventCacheModel.sessionID = null;
		}

		auditEventCacheModel.additionalInfo = getAdditionalInfo();

		String additionalInfo = auditEventCacheModel.additionalInfo;

		if ((additionalInfo != null) && (additionalInfo.length() == 0)) {
			auditEventCacheModel.additionalInfo = null;
		}

		return auditEventCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AuditEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AuditEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AuditEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AuditEvent)this));
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
		Map<String, Function<AuditEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AuditEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AuditEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AuditEvent)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AuditEvent>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _auditEventId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private String _eventType;
	private String _className;
	private String _classPK;
	private String _message;
	private String _clientHost;
	private String _clientIP;
	private String _serverName;
	private int _serverPort;
	private String _sessionID;
	private String _additionalInfo;
	private long _columnBitmask;
	private AuditEvent _escapedModel;

}