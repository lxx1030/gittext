package com.yx1030.idea_springboot_mybatis_jsp_mysql_user.mapper;

import com.yx1030.idea_springboot_mybatis_jsp_mysql_user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int getCount(User user);
    List<User> userList(User user);


}