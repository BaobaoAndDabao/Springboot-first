package com.wenzhihao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wenzhihao.service.UserService;

public class Main {
    
    public static void main(String[] args) {
        // 通过Java配置来实例化Spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        // 在Spring容器中获取Bean对象
        UserService userService = context.getBean(UserService.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
        // 调用对象中的方法
        List<User> list = userService.queryUserList();
        for (User user : list) {
            System.out.println(user.getUsername() + ", " + user.getPassword() + ", " + user.getPassword());
        }
        
        // 销毁该容器
        context.destroy();
    }

}