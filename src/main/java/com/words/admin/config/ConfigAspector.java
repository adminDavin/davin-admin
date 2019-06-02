package com.words.admin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.web.aspector")
@EnableAspectJAutoProxy
public class ConfigAspector {

}
