package com.wenzhihao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
//@EnableConfigurationProperties(Book.class)
@ConditionalOnClass({ Book.class})
public class Student {
	@Autowired
	private Book book ;
	@Value(value = "name")
	private String name ;
	private String password;
	@Bean
	public Student getStudent() {
		System.out.println(name);
		System.out.println(password);
		return null;
	}
	
	
}
