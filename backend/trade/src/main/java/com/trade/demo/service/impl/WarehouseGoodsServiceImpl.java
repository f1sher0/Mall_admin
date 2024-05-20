package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.WarehouseGoods;
import com.trade.demo.mapper.WarehouseGoodsMapper;
import com.trade.demo.service.WarehouseGoodsService;
import org.springframework.stereotype.Service;

@Service
public class WarehouseGoodsServiceImpl extends ServiceImpl<WarehouseGoodsMapper, WarehouseGoods> implements WarehouseGoodsService {
}
