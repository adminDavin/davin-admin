package com.words.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.words.admin.manage.service.ManageService;
import com.words.admin.manage.service.ManageServiceImpl;

@Configuration
@ComponentScan("com.words.admin.manage.resource")
public class ConfigService {

	@Bean
	@SessionScope
	public ManageService manageService() {
		return new ManageServiceImpl();
	}
}
