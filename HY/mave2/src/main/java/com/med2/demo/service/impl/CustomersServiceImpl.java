package com.med2.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.med2.demo.entity.Customers;
import com.med2.demo.mapper.CustomersMapper;
import com.med2.demo.service.CustomersService;
import org.springframework.stereotype.Service;

@Service

public class CustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers>implements CustomersService {
}
