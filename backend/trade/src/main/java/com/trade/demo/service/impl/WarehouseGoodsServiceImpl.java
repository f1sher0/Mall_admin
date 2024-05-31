package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.WarehouseGoods;
import com.trade.demo.entity.WarehouseGoodsGroupedInfo;
import com.trade.demo.entity.WarehouseGoodsInfo;
import com.trade.demo.mapper.WarehouseGoodsMapper;
import com.trade.demo.service.WarehouseGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseGoodsServiceImpl extends ServiceImpl<WarehouseGoodsMapper, WarehouseGoods> implements WarehouseGoodsService {
    @Autowired
    private WarehouseGoodsMapper warehouseGoodsMapper;

    @Override
    public List<WarehouseGoodsInfo> getWarehouseGoodsInfo() {
        return warehouseGoodsMapper.getWarehouseGoodsInfo();
    }

    @Override
    public List<WarehouseGoodsInfo> getWarehouseGoodsInfo(Integer warehouseId) {
        return warehouseGoodsMapper.getWarehouseGoodsInfo(warehouseId);
    }
    @Override
    public List<WarehouseGoodsGroupedInfo> getWarehouseGoodsGroupedInfo() {
        return warehouseGoodsMapper.getWarehouseGoodsGroupedInfo();
    }
}