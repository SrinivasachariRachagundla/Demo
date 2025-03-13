package com.spring.boot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@PropertySource("classpath:dbQueries.properties")
@Repository
public class SpringDAO {
	
	@Autowired
	@Qualifier("traningJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Value("{Selectcount}")
	private String scount ;
	
	@Value("${Inserttemp}")
	private String inserting;
	public int select() {
		
		log.info("counting started");
		int count = jdbcTemplate.queryForObject(scount, Integer.class);
		log.info("counting ended by returning " + count);
		return count;

	}

}
