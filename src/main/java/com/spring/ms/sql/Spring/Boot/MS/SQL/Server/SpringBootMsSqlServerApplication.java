package com.spring.ms.sql.Spring.Boot.MS.SQL.Server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootMsSqlServerApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsSqlServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from customers";
		List<Customer> customer = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
		
		customer.forEach(System.out :: println);
	}

}
