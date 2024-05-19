package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity1.Customers;
import com.trade.demo.mapper.CustomersMapper;
import com.trade.demo.service.CustomersService;
import org.springframework.stereotype.Service;

@Service

public class CustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers>implements CustomersService {
}
