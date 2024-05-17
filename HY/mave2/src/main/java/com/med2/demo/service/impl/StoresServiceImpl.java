package com.med2.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.med2.demo.entity.Stores;
import com.med2.demo.mapper.StoresMapper;
import com.med2.demo.service.StoresService;
import org.springframework.stereotype.Service;

@Service
public class StoresServiceImpl extends ServiceImpl<StoresMapper, Stores> implements StoresService {
}
