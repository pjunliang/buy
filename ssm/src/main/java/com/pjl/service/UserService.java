package com.pjl.service;

import com.pjl.pojo.User;

import java.util.List;

public interface UserService {

    /*添加用户*/
    void saveUser(User user);

    /*获取所有用户信息*/
    List<User> getAllUser();

    /*根据用户id获取用户信息*/
    User getUserById(Integer id);

    /*修改用户信息*/
    Integer updateUser(User user);

    /*根据用户id删除用户*/
    Integer deleteUserById(Integer id);
}
