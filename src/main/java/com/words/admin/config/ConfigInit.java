package com.words.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.words.admin.resource.TransferService;
import com.words.admin.resource.TransferServiceImpl;

@Configuration
@ComponentScan("com.words.admin.manage.controller")
@ComponentScan("com.words.admin.words.controller")
public class ConfigInit {

	@Bean
	public TransferService transferService() {
		return new TransferServiceImpl();
	}
}
