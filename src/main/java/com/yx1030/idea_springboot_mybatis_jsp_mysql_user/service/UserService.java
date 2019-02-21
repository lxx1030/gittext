package com.yx1030.idea_springboot_mybatis_jsp_mysql_user.service;

import com.yx1030.idea_springboot_mybatis_jsp_mysql_user.pojo.User;

import java.util.List;

public interface UserService {
    int getCount(User user);
    List<User> userList(User user);
}
