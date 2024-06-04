package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.entity.InListGoods;

import java.util.List;

public interface InListGoodsService extends IService<InListGoods> {
    List<InListGoods> getByGoodsInId(int goodsInId);
}
