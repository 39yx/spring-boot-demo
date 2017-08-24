package com.boot.starter.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = Person.class)
public class PersonAutoConfiguration {
	
	@Autowired
	private Person person; 
	
	@PostConstruct
	public void aa() {
		System.out.println(person);
	}
}
