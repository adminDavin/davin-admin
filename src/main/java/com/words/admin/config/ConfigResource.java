package com.words.admin.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.words.admin.manage.repository.ManageRepository;
import com.words.admin.manage.repository.ManageRepositoryImpl;
import com.words.admin.resource.DataSourceHikari;
import com.words.admin.resource.MybatisSpring;
import com.words.admin.words.repository.WordsAdminRepositoryImpl;

@Configuration
@ComponentScan("com.words.admin.resource")
@ComponentScan("com.words.admin.manage.repository")
@PropertySource("classpath:jdbc.properties")
public class ConfigResource {
	@Autowired
	Environment jdbc;

	@Bean
	public ManageRepository manageRepository() {
		return new ManageRepositoryImpl();
	}

	@Bean
	public WordsAdminRepositoryImpl wordsAdminRepository() {
		return new WordsAdminRepositoryImpl();
	}

	// @Bean
	// public SqlSession sqlSession() {
	// return this.sqlSessionFactory().openSession();
	// }

	@Bean
	public SqlSessionFactory sqlSessionFactory() {
		Resource[] mapperLocations = { new ClassPathResource(jdbc.getProperty("mybatis.mapper.version")),
				new ClassPathResource(jdbc.getProperty("mybatis.mapper.manage")),
				new ClassPathResource(jdbc.getProperty("mybatis.mapper.words")) };
		SqlSessionFactory sqlSessionFactory = null;
		try {
			DataSource dataSource = new DataSourceHikari(jdbc);
			sqlSessionFactory = new MybatisSpring(dataSource, mapperLocations).getObject();

		} catch (Exception e) {
			System.out.println("数据库链接异常，请检查！" + e.getMessage());
			System.exit(0);
		}
		return sqlSessionFactory;

	}
}
