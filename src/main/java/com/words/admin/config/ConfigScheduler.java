package com.words.admin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.words.admin.TaskScheduler")
@EnableScheduling
public class ConfigScheduler {

}
