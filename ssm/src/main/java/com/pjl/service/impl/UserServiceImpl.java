package com.pjl.service.impl;

import com.pjl.mapper.UserMapper;
import com.pjl.pojo.User;
import com.pjl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    /*添加用户*/
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    /*查询所有用户信息*/
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    /*根据id查询用户信息*/
    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    /*修改用户信息*/
    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /*根据用户id删除用户*/
    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }
}
