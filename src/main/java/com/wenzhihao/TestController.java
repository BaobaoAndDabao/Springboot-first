package com.wenzhihao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wenzhihao.service.UserService;

@Controller
@SpringBootApplication  //是一个组合注解,具有多个注解的功能,@Configuration 配置的功能 @EnableAutoConfiguration
//@Configuration			//使项目根据该项目依赖的jar进行自动配置.比如引入依赖pring-boot-starter-web,所以对 前端过滤器 等进行默认配置
						//和tomcat进行配置.@ComponentScan默认扫描该类所在的包及其子包.
//所以@SpringBootApplication意味着 1:扫描包及其子包(扫描到不同的注解做不同的事情.扫描到@Sevice注册成bean,扫到Configuration,也进行执行注册).2:根据依赖自动配置.3:具有@Configuration的作用.
//@ComponentScan("com.wenzhihao.**")//如果没有配置,就回去扫描@SpringBootApplication所在包的下的所有包
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
