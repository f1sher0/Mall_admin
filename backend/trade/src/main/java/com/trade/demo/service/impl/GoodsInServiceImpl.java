package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.GoodsIn;
import com.trade.demo.mapper.GoodsInMapper;
import com.trade.demo.service.GoodsInService;
import org.springframework.stereotype.Service;

@Service
public class GoodsInServiceImpl extends ServiceImpl<GoodsInMapper, GoodsIn> implements GoodsInService {
}
