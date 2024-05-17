package com.med2.demo.service.impl;

import com.med2.demo.entity.Storages;
import com.med2.demo.mapper.StoragesMapper;
import com.med2.demo.service.StoragesService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
@Service
public class StoragesServiceImpl extends ServiceImpl<StoragesMapper, Storages>implements StoragesService {
}
