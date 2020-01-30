package com.springau.config;

import com.springau.database.EmployeeOperations;

import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@PropertySource("classpath:login.properties")
@Configuration
@EnableWebMvc
public class WebappConfig {
	
	/*
	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String password;
	*/
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource getData() {
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setDriverClassName("com.mysql.jdbc.Driver");
		data.setUrl("jdbc:mysql://localhost:3306/emp");
		/*
		data.setUsername(this.env.getProperty("username"));
		data.setPassword(this.env.getProperty("password"));
		*/
		data.setUsername("root");
		data.setPassword("123abyash");
		
		return data;
	}
	
	@Bean
	public EmployeeOperations getEmployee() {
		return new EmployeeOperations(getData());
	}
}
