package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.entity.GoodsIn;

public interface GoodsInService extends IService<GoodsIn> {
    boolean saveAndSyncGoods(GoodsIn goodsIn);
}
