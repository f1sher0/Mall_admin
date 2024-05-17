package com.trade.demo.service.impl;

import com.trade.demo.entity.Storages;
import com.trade.demo.mapper.StoragesMapper;
import com.trade.demo.service.StoragesService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class StoragesServiceImpl extends ServiceImpl<StoragesMapper, Storages>implements StoragesService {
}
