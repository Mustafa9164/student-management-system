package com.jspider.project.configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jspider.project")
public class StudentConfig {

	@Bean
	public EntityManager getEntityManagerFactory()
	{	
		return Persistence.createEntityManagerFactory("student").createEntityManager();
	}
}
