package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity1.Emps;
import com.trade.demo.mapper.EmpsMapper;
import com.trade.demo.service.EmpsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpsServiceImpl extends ServiceImpl<EmpsMapper, Emps> implements EmpsService {
    @Resource
private EmpsMapper empsMapper;
    @Override
    public List<Emps> empsall() {
        return empsMapper.empsall();
    }


    public Emps MyGetByUsernameAndPassword(String username, String password) {
        return empsMapper.MyGetByUsernameAndPassword(username, password);
    }
}
