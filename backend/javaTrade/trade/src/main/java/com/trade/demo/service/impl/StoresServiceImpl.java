package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity1.Stores;
import com.trade.demo.mapper.StoresMapper;
import com.trade.demo.service.StoresService;
import org.springframework.stereotype.Service;

@Service
public class StoresServiceImpl extends ServiceImpl<StoresMapper, Stores> implements StoresService {
}
