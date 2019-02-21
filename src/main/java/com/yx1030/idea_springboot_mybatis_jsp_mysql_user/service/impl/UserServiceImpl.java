package com.yx1030.idea_springboot_mybatis_jsp_mysql_user.service.impl;

import com.yx1030.idea_springboot_mybatis_jsp_mysql_user.mapper.UserMapper;
import com.yx1030.idea_springboot_mybatis_jsp_mysql_user.pojo.User;
import com.yx1030.idea_springboot_mybatis_jsp_mysql_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public int getCount(User user) {
        return mapper.getCount(user);
    }

    @Override
    public List<User> userList(User user) {
        return mapper.userList(user);
    }
}
