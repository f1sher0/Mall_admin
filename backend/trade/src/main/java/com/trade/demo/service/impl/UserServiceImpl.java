package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.User;
import com.trade.demo.mapper.UserMapper;
import com.trade.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean isEmailTaken(String email) {

            return this.lambdaQuery().eq(User::getEmail, email).count() > 0;

    }
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByEmail(String email) {
        return userMapper.selectByEmail(email);
    }
    @Override
    public List<User> getUnreviewedUsers() {
        return this.lambdaQuery().eq(User::getStatus, '0').list();
    }
}
