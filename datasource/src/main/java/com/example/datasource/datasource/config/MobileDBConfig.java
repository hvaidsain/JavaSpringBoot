package com.example.datasource.datasource.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mobileEntityManagerFactory", basePackages = {
		"com.example.datasource.datasource.repository.mobile" }, transactionManagerRef = "mobileTransactionManager")
public class MobileDBConfig {
	@Bean(name = "mobileDatasource")
	@ConfigurationProperties(prefix = "spring.mobile.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "mobileEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("mobileDatasource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.example.datasource.datasource.model.mobile")
				.persistenceUnit("Mobile").build();
	}
	
	@Bean(name = "mobileTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("mobileEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
