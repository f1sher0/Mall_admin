package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.GoodsIn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface GoodsInMapper extends BaseMapper<GoodsIn> {
    @Insert("INSERT INTO goodsin (goodsInNo, supplierId, supplierName, goodsPrice, goodsAmount, goodsInTime, warehouseId, warehouseName, operatorId, operatorName, remark, goodsName, goodsCategory) " +
            "VALUES (#{goodsInNo}, #{supplierId}, #{supplierName}, #{goodsPrice}, #{goodsAmount}, #{goodsInTime}, #{warehouseId}, #{warehouseName}, #{operatorId}, #{operatorName}, #{remark}, #{goodsName}, #{goodsCategory})")
    @Options(useGeneratedKeys = true, keyProperty = "goodsInId")
    int insertGoodsIn(GoodsIn goodsIn);
}

