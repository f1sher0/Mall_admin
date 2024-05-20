package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.entity1.Emps;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpsService extends IService<Emps> {

    List<Emps> empsall();

    Emps MyGetByUsernameAndPassword(String username, String password);
}
