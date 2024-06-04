package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.Goods;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
=======
import org.apache.ibatis.annotations.*;
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Update("UPDATE goods SET onShelf = 1, updateTime = NOW() WHERE goodsId = #{goodsId}")
    boolean shelfGoods(@Param("goodsId") int goodsId);

    @Update("UPDATE goods SET onShelf = 0, updateTime = NOW() WHERE goodsId = #{goodsId}")
    boolean unshelfGoods(@Param("goodsId") int goodsId);
<<<<<<< HEAD
=======
    @Insert("INSERT INTO goods (goodsName, goodsCategory, purchasePrice, sellingPrice, onShelf) VALUES (#{goodsName}, #{goodsCategory}, #{purchasePrice}, #{sellingPrice}, #{onShelf})")
    @Options(useGeneratedKeys = true, keyProperty = "goodsId")
    int insertGoods(Goods goods);
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
}
