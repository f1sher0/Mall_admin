package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.entity.User;

public interface UserService extends IService<User> {
    boolean isEmailTaken(String email);

    User findByEmail(String email);
}
