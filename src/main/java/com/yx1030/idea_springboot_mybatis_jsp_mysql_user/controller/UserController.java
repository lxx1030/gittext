package com.yx1030.idea_springboot_mybatis_jsp_mysql_user.controller;

import com.yx1030.idea_springboot_mybatis_jsp_mysql_user.pojo.User;
import com.yx1030.idea_springboot_mybatis_jsp_mysql_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("list")
    public ModelAndView list(User user,ModelAndView mav){
        System.out.print(user);
        int count = service.getCount(user);
        user.setTotalCount(count);
        user.calculatePage();
        List<User> list = service.userList(user);
        mav.addObject("list",list);
        System.out.print(list);
        mav.addObject("page",user.getPageStr());
        mav.setViewName("list");
        System.out.print("list执行完成");
        return mav;

    }
}
