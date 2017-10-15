package com.wenzhihao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component //测试 3
@ConfigurationProperties(prefix="book")
public class Book {
	
	private String name;
	private String price;
	public Book() {
		
		System.out.println("book"+name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
}
