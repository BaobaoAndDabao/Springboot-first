package com.wenzhihao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.wenzhihao.User;
import com.wenzhihao.UserDAO;

@Service  //通过注解配置的bean
public class UserService {

    @Autowired // 注入Spring容器中的bean对象
    private UserDAO userDAO;
    @Value("name")//意思是 默认值是"name" 没有这么玩的,一般常量值写在配置文件中
    private String name ;
    @Value("${name}")//从内存中取值."${}"
    private String Myname ;
    public List<User> queryUserList() {
        // 调用userDAO中的方法进行查询
    	//System.out.println();
        return this.userDAO.queryUserList();
    }

}
