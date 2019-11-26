package com.eventos.eventoapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
	private final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
//	private final String DATABASE_URL = "jdbc:mysql://172.31.24.143:3306/db_eventos";
//	//private final String DATABASE_URL = "jdbc:mysql://dev.cbztr9pztcwi.us-east-1.rds.amazonaws.com:3306/db_eventos";
//	private final String DATABASE_USERNAME = "rodneylsp";
//	private final String DATABASE_PASSWORD = "java#rodneylsp";
	
	private final String DATABASE_URL = "jdbc:mysql://localhost:3306/CLIENTES?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private final String DATABASE_USERNAME = "rodneylsp";
	private final String DATABASE_PASSWORD = "rodneylsp";
	private final String DATABASE_DIALECT = "org.hibernate.dialect.MySQL8Dialect";

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform(DATABASE_DIALECT);
		adapter.setPrepareConnection(true);
		return adapter;
	}
}
