package com.shop.service.Impl;

import com.shop.mapper.UserMapper;
import com.shop.pojo.User;
import com.shop.pojo.UserExample;
import com.shop.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    /*根据用户名查询用户*/
    @Override
    public List<User> findUserByName(String name,String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(name);
        criteria.andUserpasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        return users;
    }

    /*注册用户*/
    @Override
    public Integer saveUser(User user) {
        return userMapper.insert(user);
    }
}
