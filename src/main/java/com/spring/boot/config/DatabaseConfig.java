package com.spring.boot.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;



@Configuration
public class DatabaseConfig {

	@Bean(name = "springJdbc")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "traningJdbcTemplate")
	public JdbcTemplate trainingJdbcTemplate(@Qualifier("springJdbc") DataSource ds) {

		try {
				return new JdbcTemplate(ds);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}