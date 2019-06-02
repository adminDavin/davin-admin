package com.words.admin;

import java.util.EnumSet;


import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.web.Log4jServletContainerInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.words.admin.config.ConfigAspector;
import com.words.admin.config.ConfigInit;
import com.words.admin.config.ConfigResource;
import com.words.admin.config.ConfigService;
import com.words.admin.config.Constant;


@HandlesTypes(WebApplicationInitializer.class)
@ComponentScan("com.words.admin.manage.service")
@ComponentScan("com.words.admin.manage.repository")
@EnableWebSecurity

@ComponentScan("com.words.admin.TaskScheduler")
@EnableScheduling
public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
		cxt.register(ConfigInit.class, ConfigResource.class, ConfigService.class, Constant.class, ConfigAspector.class);
		cxt.refresh();
		container.addListener(new ContextLoaderListener(cxt));
		container.setInitParameter("spring.profiles.active", "dev");
	    container.setInitParameter("spring.profiles.default", "dev");
	    container.setInitParameter("spring.liveBeansView.mbeanDomain", "dev");

	    ServletRegistration.Dynamic registration = container.addServlet("words-admin", new DispatcherServlet(cxt));
		registration.setLoadOnStartup(1);
		registration.addMapping("/admin/*");
		registration.setMultipartConfig(getMultipartConfigElement());
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
		FilterRegistration.Dynamic characterEncoding = container.addFilter("CharacterEncodingFilter", characterEncodingFilter);
		characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");

	}

	public static MultipartConfigElement getMultipartConfigElement() {
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(Constant.LOCATION,
				Constant.MAX_FILE_SIZE, Constant.MAX_REQUEST_SIZE, Constant.FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	}

}
