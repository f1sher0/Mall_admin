package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.entity.WarehouseGoods;
import com.trade.demo.entity.WarehouseGoodsGroupedInfo;
import com.trade.demo.entity.WarehouseGoodsInfo;
import com.trade.demo.mapper.WarehouseGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface WarehouseGoodsService extends IService<WarehouseGoods> {
    List<WarehouseGoodsInfo> getWarehouseGoodsInfo();
    List<WarehouseGoodsGroupedInfo> getWarehouseGoodsGroupedInfo();


    List<WarehouseGoodsInfo> getWarehouseGoodsInfo(Integer id);
}
