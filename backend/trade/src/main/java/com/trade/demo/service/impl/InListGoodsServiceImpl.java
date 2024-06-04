package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.InListGoods;
import com.trade.demo.mapper.InListGoodsMapper;
import com.trade.demo.service.InListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InListGoodsServiceImpl extends ServiceImpl<InListGoodsMapper, InListGoods> implements InListGoodsService {


    @Autowired
    private InListGoodsMapper inListGoodsMapper;
    @Override
    public List<InListGoods> getByGoodsInId(int goodsInId) {
        return inListGoodsMapper.selectByGoodsInId(goodsInId);
    }
}
