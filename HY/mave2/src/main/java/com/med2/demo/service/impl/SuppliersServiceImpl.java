package com.med2.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.med2.demo.entity.Suppliers;
import com.med2.demo.mapper.SuppliersMapper;
import com.med2.demo.service.SuppliersService;
import org.springframework.stereotype.Service;

@Service

public class SuppliersServiceImpl extends ServiceImpl<SuppliersMapper, Suppliers> implements SuppliersService {
}
