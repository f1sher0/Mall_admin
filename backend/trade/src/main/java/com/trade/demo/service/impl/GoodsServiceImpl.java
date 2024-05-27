package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.Goods;
import com.trade.demo.mapper.GoodsMapper;
import com.trade.demo.mapper.UserMapper;
import com.trade.demo.service.GoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public   boolean unshelfGoods(@Param("goodsId") int goodsId){
     return  goodsMapper.unshelfGoods(goodsId);

    }
    @Override
    public boolean shelfGoods(@Param("goodsId") int goodsId){
       return goodsMapper.shelfGoods(goodsId);
    }
}
