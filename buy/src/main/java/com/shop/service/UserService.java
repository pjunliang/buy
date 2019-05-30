package com.shop.service;

import com.shop.mapper.UserMapper;
import com.shop.pojo.User;

import javax.annotation.Resource;
import java.util.List;

public interface UserService {
    /*根据用户名查找用户*/
    List<User> findUserByName(String name,String password);

    /*注册用户*/
    Integer saveUser(User user);
}
