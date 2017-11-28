package com.words.admin.manage.resource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

@Component("dbPool")
public class DataSourceHikari extends HikariDataSource {

	public DataSourceHikari(Environment jdbc) {
		String driver = jdbc.getProperty("jdbc.driver");
		String url = jdbc.getProperty("jdbc.url");
		String user = jdbc.getProperty("jdbc.user");
		String pass = jdbc.getProperty("jdbc.pass");
		int maxPoolSize = Integer.parseInt(jdbc.getProperty("jdbc.pool.maxPoolSize"));
		if ("com.mysql.cj.jdbc.Driver".equals(driver)) {
			this.setDriverClassName(driver);
			this.setJdbcUrl(url);
			this.setPassword(pass);
			this.setUsername(user);
			this.setMaximumPoolSize(maxPoolSize);
			this.addDataSourceProperty("cachePrepStmts", "true");
			this.addDataSourceProperty("prepStmtCacheSize", "250");
			this.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
			this.addDataSourceProperty("useServerPrepStmts", "true");
			this.addDataSourceProperty("useLocalSessionState", "true");
			this.addDataSourceProperty("useLocalTransactionState", "true");
			this.addDataSourceProperty("rewriteBatchedStatements", "true");
			this.addDataSourceProperty("cacheResultSetMetadata", "true");
			this.addDataSourceProperty("cacheServerConfiguration", "true");
			this.addDataSourceProperty("elideSetAutoCommits", "true");
			this.addDataSourceProperty("maintainTimeStats", "false");
		} else {
			this.setDriverClassName("oracle.jdbc.pool.OracleDataSource");
			this.setReadOnly(false);
			this.setDataSourceClassName("");
			this.setUsername("wordsadmin");
			this.setPassword("admin");
		}
	}

	@PostConstruct
	public void afterInit() {
		System.out.println("Init dataSource using pool Hikari success!");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destory DataSourceHikari");
	}
}
