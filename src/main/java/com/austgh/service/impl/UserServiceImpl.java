package com.austgh.service.impl;

import com.austgh.entity.User;
import com.austgh.mapper.UserMapper;
import com.austgh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by think on 2021/1/15.
 */
@Component
public class UserServiceImpl implements UserService {
    //    @Resource
    @Autowired
    UserMapper userMapper;
    public User selectById(Integer id) {
        return userMapper.getUserById(id);
    }
}
