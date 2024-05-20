package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.SalesListGoods;

import com.trade.demo.mapper.SalesListGoodsMapper;

import com.trade.demo.service.SalesListGoodsService;
import org.springframework.stereotype.Service;

@Service
public class SalesListGoodsServiceImpl extends ServiceImpl<SalesListGoodsMapper, SalesListGoods> implements SalesListGoodsService {
}
