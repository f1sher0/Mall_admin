package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity1.Manages;
import com.trade.demo.mapper.ManagesMapper;
import com.trade.demo.service.ManagesService;
import org.springframework.stereotype.Service;

@Service
public class ManagesServiceImpl extends ServiceImpl<ManagesMapper, Manages> implements ManagesService {
}
