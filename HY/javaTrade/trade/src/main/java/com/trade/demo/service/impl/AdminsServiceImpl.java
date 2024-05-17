package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.Admins;
import com.trade.demo.mapper.AdminsMapper;
import com.trade.demo.service.AdminsService;
import org.springframework.stereotype.Service;

@Service
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins> implements AdminsService {

}
