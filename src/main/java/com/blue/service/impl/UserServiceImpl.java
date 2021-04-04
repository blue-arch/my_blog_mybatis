package com.blue.service.impl;

import com.blue.mapper.UserMapper;
import com.blue.po.User;
import com.blue.service.UserService;
import com.blue.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kuls
 * @Desc kuls
 * @date 2020/5/4 5:28 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.userCheck(username, MD5Utils.code(password));
        return user;
    }
}
