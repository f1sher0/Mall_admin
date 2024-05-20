package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.InListGoods;
import com.trade.demo.mapper.InListGoodsMapper;
import com.trade.demo.service.InListGoodsService;
import org.springframework.stereotype.Service;

@Service
public class InListGoodsServiceImpl extends ServiceImpl<InListGoodsMapper, InListGoods> implements InListGoodsService {
}
