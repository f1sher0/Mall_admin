package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}
