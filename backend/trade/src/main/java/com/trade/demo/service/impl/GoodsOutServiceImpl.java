package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.GoodsOut;
import com.trade.demo.mapper.GoodsOutMapper;
import com.trade.demo.service.GoodsOutService;
import org.springframework.stereotype.Service;

@Service
public class GoodsOutServiceImpl extends ServiceImpl<GoodsOutMapper, GoodsOut> implements GoodsOutService {
}
