package com.words.admin.manage.resource;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;

public class MybatisSpring extends SqlSessionFactoryBean {
	public MybatisSpring(DataSource dataSource, Resource[] mapperLocations) {
		this.setDataSource(dataSource);
		this.setMapperLocations(mapperLocations);
	}
}
