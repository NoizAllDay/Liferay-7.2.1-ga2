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

package com.liferay.taglib.util;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.portlet.PortletIdCodec;
import com.liferay.portal.kernel.servlet.PluginContextListener;
import com.liferay.portal.kernel.servlet.ServletContextPool;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateContextContributor;
import com.liferay.portal.kernel.template.TemplateManager;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.TemplateResourceLoaderUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ThemeHelper;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.registry.collections.ServiceTrackerCollections;
import com.liferay.registry.collections.ServiceTrackerList;
import com.liferay.taglib.servlet.PipingServletResponse;

import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Brian Myunghun Kim
 * @author Raymond Aug??
 * @author Mika Koivisto
 * @author Shuyang Zhou
 */
public class ThemeUtil {

	public static String getPortletId(HttpServletRequest httpServletRequest) {
		String portletId = null;

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		if (themeDisplay != null) {
			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			portletId = portletDisplay.getId();
		}

		return portletId;
	}

	public static void include(
			ServletContext servletContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String path, Theme theme)
		throws Exception {

		include(
			servletContext, httpServletRequest, httpServletResponse, path,
			theme, true);
	}

	public static String include(
			ServletContext servletContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String path, Theme theme,
			boolean write)
		throws Exception {

		String pluginServletContextName = GetterUtil.getString(
			theme.getServletContextName());

		ServletContext pluginServletContext = ServletContextPool.get(
			pluginServletContextName);

		ClassLoader pluginClassLoader = null;

		if (pluginServletContext != null) {
			pluginClassLoader = (ClassLoader)pluginServletContext.getAttribute(
				PluginContextListener.PLUGIN_CLASS_LOADER);
		}

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if ((pluginClassLoader != null) &&
			(pluginClassLoader != contextClassLoader)) {

			currentThread.setContextClassLoader(pluginClassLoader);
		}

		try {
			return doIncludeFTL(
				servletContext, httpServletRequest, httpServletResponse, path,
				theme, false, write);
		}
		finally {
			if ((pluginClassLoader != null) &&
				(pluginClassLoader != contextClassLoader)) {

				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	/**
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	public static String includeFTL(
			ServletContext servletContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String path, Theme theme,
			boolean write)
		throws Exception {

		return include(
			servletContext, httpServletRequest, httpServletResponse, path,
			theme, write);
	}

	/**
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	public static void includeJSP(
			ServletContext servletContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String path, Theme theme)
		throws Exception {

		doDispatch(
			servletContext, httpServletRequest, httpServletResponse, path,
			theme, true, ThemeHelper.TEMPLATE_EXTENSION_JSP);
	}

	/**
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	public static String includeVM(
			ServletContext servletContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String path, Theme theme,
			boolean write)
		throws Exception {

		return doDispatch(
			servletContext, httpServletRequest, httpServletResponse, path,
			theme, write, ThemeHelper.TEMPLATE_EXTENSION_VM);
	}

	/**
	 * @deprecated As of Judson (7.1.x), replaced by {@link
	 *             #include(ServletContext, HttpServletRequest,
	 *             HttpServletResponse, String, Theme, boolean)}
	 */
	@Deprecated
	protected static String doDispatch(
			ServletContext servletContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String path, Theme theme,
			boolean write, String extension)
		throws Exception {

		return include(
			servletContext, httpServletRequest, httpServletResponse, path,
			theme, write);
	}

	protected static String doIncludeFTL(
			ServletContext servletContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String path, Theme theme,
			boolean restricted, boolean write)
		throws Exception {

		// The servlet context name will be null when the theme is deployed to
		// the root directory in Tomcat. See
		// com.liferay.portal.servlet.MainServlet and
		// com.liferay.portlet.PortletContextImpl for other cases where a null
		// servlet context name is also converted to an empty string.

		String servletContextName = GetterUtil.getString(
			theme.getServletContextName());

		if (ServletContextPool.get(servletContextName) == null) {

			// This should only happen if the FreeMarker template is the first
			// page to be accessed in the system

			ServletContextPool.put(servletContextName, servletContext);
		}

		String portletId = getPortletId(httpServletRequest);

		String resourcePath = theme.getResourcePath(
			servletContext, portletId, path);

		if (Validator.isNotNull(portletId) &&
			PortletIdCodec.hasInstanceId(portletId) &&
			!TemplateResourceLoaderUtil.hasTemplateResource(
				TemplateConstants.LANG_TYPE_FTL, resourcePath)) {

			String rootPortletId = PortletIdCodec.decodePortletName(portletId);

			resourcePath = theme.getResourcePath(
				servletContext, rootPortletId, path);
		}

		if (Validator.isNotNull(portletId) &&
			!TemplateResourceLoaderUtil.hasTemplateResource(
				TemplateConstants.LANG_TYPE_FTL, resourcePath)) {

			resourcePath = theme.getResourcePath(servletContext, null, path);
		}

		if (!TemplateResourceLoaderUtil.hasTemplateResource(
				TemplateConstants.LANG_TYPE_FTL, resourcePath)) {

			_log.error(resourcePath + " does not exist");

			return null;
		}

		TemplateResource templateResource =
			TemplateResourceLoaderUtil.getTemplateResource(
				TemplateConstants.LANG_TYPE_FTL, resourcePath);

		Template template = TemplateManagerUtil.getTemplate(
			TemplateConstants.LANG_TYPE_FTL, templateResource, restricted);

		// FreeMarker variables

		template.prepare(httpServletRequest);

		// Custom theme variables

		for (TemplateContextContributor templateContextContributor :
				_templateContextContributors) {

			templateContextContributor.prepare(template, httpServletRequest);
		}

		// Theme servlet context

		ServletContext themeServletContext = ServletContextPool.get(
			servletContextName);

		template.put("themeServletContext", themeServletContext);

		Writer writer = null;

		if (write) {
			writer = httpServletResponse.getWriter();
		}
		else {
			writer = new UnsyncStringWriter();

			httpServletResponse = new PipingServletResponse(
				httpServletResponse, writer);
		}

		TemplateManager templateManager =
			TemplateManagerUtil.getTemplateManager(
				TemplateConstants.LANG_TYPE_FTL);

		templateManager.addTaglibSupport(
			template, httpServletRequest, httpServletResponse);
		templateManager.addTaglibTheme(
			template, "taglibLiferay", httpServletRequest, httpServletResponse);

		template.put(TemplateConstants.WRITER, writer);

		// Merge templates

		template.processTemplate(writer);

		if (write) {
			return null;
		}

		return writer.toString();
	}

	/**
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	protected static void doIncludeJSP(
			ServletContext servletContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String path, Theme theme)
		throws Exception {

		if (theme.isWARFile()) {
			ServletContext themeServletContext = servletContext.getContext(
				theme.getContextPath());

			if (themeServletContext == null) {
				_log.error(
					StringBundler.concat(
						"Theme ", theme.getThemeId(), " cannot find its ",
						"servlet context at ", theme.getServletContextName()));
			}
			else {
				RequestDispatcher requestDispatcher =
					themeServletContext.getRequestDispatcher(path);

				if (requestDispatcher == null) {
					_log.error(
						StringBundler.concat(
							"Theme ", theme.getThemeId(), " does not have ",
							path));
				}
				else {
					requestDispatcher.include(
						httpServletRequest, httpServletResponse);
				}
			}
		}
		else {
			RequestDispatcher requestDispatcher =
				servletContext.getRequestDispatcher(path);

			if (requestDispatcher == null) {
				_log.error(
					StringBundler.concat(
						"Theme ", theme.getThemeId(), " does not have ", path));
			}
			else {
				requestDispatcher.include(
					httpServletRequest, httpServletResponse);
			}
		}
	}

	/**
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	protected static String doIncludeVM(
			ServletContext servletContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String page, Theme theme,
			boolean restricted, boolean write)
		throws Exception {

		// The servlet context name will be null when the theme is deployed to
		// the root directory in Tomcat. See
		// com.liferay.portal.servlet.MainServlet and
		// com.liferay.portlet.PortletContextImpl for other cases where a null
		// servlet context name is also converted to an empty string.

		String servletContextName = GetterUtil.getString(
			theme.getServletContextName());

		if (ServletContextPool.get(servletContextName) == null) {

			// This should only happen if the Velocity template is the first
			// page to be accessed in the system

			ServletContextPool.put(servletContextName, servletContext);
		}

		String portletId = getPortletId(httpServletRequest);

		String resourcePath = theme.getResourcePath(
			servletContext, portletId, page);

		boolean checkResourceExists = true;

		if (Validator.isNotNull(portletId)) {
			if (PortletIdCodec.hasInstanceId(portletId) &&
				(checkResourceExists !=
					TemplateResourceLoaderUtil.hasTemplateResource(
						TemplateConstants.LANG_TYPE_VM, resourcePath))) {

				String rootPortletId = PortletIdCodec.decodePortletName(
					portletId);

				resourcePath = theme.getResourcePath(
					servletContext, rootPortletId, page);
			}

			if (checkResourceExists &&
				(checkResourceExists !=
					TemplateResourceLoaderUtil.hasTemplateResource(
						TemplateConstants.LANG_TYPE_VM, resourcePath))) {

				resourcePath = theme.getResourcePath(
					servletContext, null, page);
			}
		}

		if (checkResourceExists &&
			!TemplateResourceLoaderUtil.hasTemplateResource(
				TemplateConstants.LANG_TYPE_VM, resourcePath)) {

			_log.error(resourcePath + " does not exist");

			return null;
		}

		TemplateResource templateResource =
			TemplateResourceLoaderUtil.getTemplateResource(
				TemplateConstants.LANG_TYPE_VM, resourcePath);

		if (templateResource == null) {
			throw new Exception(
				"Unable to load template resource " + resourcePath);
		}

		TemplateManager templateManager =
			TemplateManagerUtil.getTemplateManager(
				TemplateConstants.LANG_TYPE_VM);

		Template template = TemplateManagerUtil.getTemplate(
			TemplateConstants.LANG_TYPE_VM, templateResource, restricted);

		// Velocity variables

		template.prepare(httpServletRequest);

		// Custom theme variables

		for (TemplateContextContributor templateContextContributor :
				_templateContextContributors) {

			templateContextContributor.prepare(template, httpServletRequest);
		}

		// Theme servlet context

		ServletContext themeServletContext = ServletContextPool.get(
			servletContextName);

		template.put("themeServletContext", themeServletContext);

		// Tag libraries

		Writer writer = null;

		if (write) {
			writer = httpServletResponse.getWriter();
		}
		else {
			writer = new UnsyncStringWriter();

			httpServletResponse = new PipingServletResponse(
				httpServletResponse, writer);
		}

		templateManager.addTaglibTheme(
			template, "taglibLiferay", httpServletRequest, httpServletResponse);

		template.put(TemplateConstants.WRITER, writer);

		// Merge templates

		template.processTemplate(writer);

		if (write) {
			return null;
		}

		return writer.toString();
	}

	private static final Log _log = LogFactoryUtil.getLog(ThemeUtil.class);

	private static final ServiceTrackerList<TemplateContextContributor>
		_templateContextContributors = ServiceTrackerCollections.openList(
			TemplateContextContributor.class,
			"(type=" + TemplateContextContributor.TYPE_THEME + ")");

}