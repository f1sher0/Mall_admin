package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.entity.GoodsOut;

public interface GoodsOutService extends IService<GoodsOut> {
    boolean saveAndSyncGoods(GoodsOut goodsOut);
}
