package com.words.admin;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.words.admin.config.ConfigInit;
import com.words.admin.config.ConfigJodConverterAuto;
import com.words.admin.config.ConfigResource;
import com.words.admin.config.ConfigScheduler;
import com.words.admin.config.ConfigService;
import com.words.admin.config.Constant;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		System.out.println("------------------------------------------------------------");
		System.out.println("--|-----+---+-------+---------------------------------------");
		System.out.println("--+-----+---+-------+---------------------------------------");
		System.out.println("--+++++++---+-------+---------------------------------------");
		System.out.println("--+-----+---+-------+---------------------------------------");
		System.out.println("--+-----+---++++++--+++++++---------------------------------");
		System.out.println("------------------------------------------------------------");

		AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
		cxt.register(ConfigInit.class, ConfigResource.class, ConfigService.class, Constant.class, ConfigScheduler.class,
				ConfigJodConverterAuto.class);
		cxt.refresh();

		DispatcherServlet servlet = new DispatcherServlet(cxt);
		container.addListener(new ContextLoaderListener(cxt));

		ServletRegistration.Dynamic registration = container.addServlet("words-admin", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/admin/*");
		registration.setMultipartConfig(getMultipartConfigElement());
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
		FilterRegistration.Dynamic characterEncoding = container.addFilter("CharacterEncodingFilter",
				characterEncodingFilter);
		characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");

	}

	// 设置上传的相关参数
	public static MultipartConfigElement getMultipartConfigElement() {
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(Constant.LOCATION,
				Constant.MAX_FILE_SIZE, Constant.MAX_REQUEST_SIZE, Constant.FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	}

}
