package com.words.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.words.admin.manage.service.EmailService;
import com.words.admin.manage.service.EmailServiceImpl;
import com.words.admin.manage.service.ManageService;
import com.words.admin.manage.service.ManageServiceImpl;
import com.words.admin.words.service.WordsAdminService;
import com.words.admin.words.service.WordsAdminServiceImpl;

@Configuration
@ComponentScan("com.words.admin.resource")
public class ConfigService {

	@Bean
	@SessionScope
	public ManageService manageService() {
		return new ManageServiceImpl();
	}

	@Bean
	@SessionScope
	public WordsAdminService wordsAdminService() {
		return new WordsAdminServiceImpl();
	}

	@Bean
	public EmailService emailService() {
		return new EmailServiceImpl();
	}
}
