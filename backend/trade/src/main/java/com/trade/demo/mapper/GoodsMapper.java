package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Update("UPDATE goods SET onShelf = 1, updateTime = NOW() WHERE goodsId = #{goodsId}")
    boolean shelfGoods(@Param("goodsId") int goodsId);

    @Update("UPDATE goods SET onShelf = 0, updateTime = NOW() WHERE goodsId = #{goodsId}")
    boolean unshelfGoods(@Param("goodsId") int goodsId);
}
