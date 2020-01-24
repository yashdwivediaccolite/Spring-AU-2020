package com.assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.assignment.models.Point;

@Configuration
@PropertySource("file:src/main/resources/config.properties")
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name="point")
	public Point getPointVal(){
		Point p=new Point();
		p.setX(Integer.parseInt(this.env.getProperty("xVal")));
		p.setY(Integer.parseInt(this.env.getProperty("yVal")));
		return p;
	}
	
}
