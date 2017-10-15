package com.wenzhihao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.wenzhihao.User;
import com.wenzhihao.UserDAO;

@Service  
public class UserService {

    @Autowired 
    private UserDAO userDAO;
    private String name ;
    @Value("${name}")
    private String Myname ;
    public List<User> queryUserList() {
        return this.userDAO.queryUserList();
    }

}
