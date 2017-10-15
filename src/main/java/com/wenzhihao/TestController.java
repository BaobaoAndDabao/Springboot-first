package com.wenzhihao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wenzhihao.service.UserService;

@Controller
@SpringBootApplication
public class TestController {
	
	public static void main(String[] args) {
		Object[] configs = new Object[]{TestController.class};
		SpringApplication.run(configs, args);
		
	}
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private Gson gson ;
	
	
	@RequestMapping("/hi")
	@ResponseBody
	public Map<String,String> sayHi(){
		
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("hi", "hi");
		return hashMap;
	}
	
}
