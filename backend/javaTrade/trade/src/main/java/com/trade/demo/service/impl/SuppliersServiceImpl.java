package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity1.Suppliers;
import com.trade.demo.mapper.SuppliersMapper;
import com.trade.demo.service.SuppliersService;
import org.springframework.stereotype.Service;

@Service

public class SuppliersServiceImpl extends ServiceImpl<SuppliersMapper, Suppliers> implements SuppliersService {
}
