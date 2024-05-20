package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.Supplier;
import com.trade.demo.mapper.SupplierMapper;
import com.trade.demo.service.SupplierService;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {
}
