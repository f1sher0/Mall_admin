package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.common.Result;
import com.trade.demo.entity.Goods;
import com.trade.demo.mapper.GoodsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

public interface GoodsService extends IService<Goods> {
    boolean unshelfGoods(@Param("goodsId") int goodsId);
    boolean shelfGoods(@Param("goodsId") int goodsId);
}
