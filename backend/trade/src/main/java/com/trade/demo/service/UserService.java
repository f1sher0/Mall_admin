package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    boolean isEmailTaken(String email);
    List<User> getUnreviewedUsers();
    User findByEmail(String email);
}
