package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.GoodsIn;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsInMapper extends BaseMapper<GoodsIn> {
    @Insert("INSERT INTO goodsin (goodsInNo, supplierId, supplierName, goodsPrice, goodsAmount, goodsInTime, warehouseId, warehouseName, operatorId, operatorName, remark, goodsName, goodsCategory) " +
            "VALUES (#{goodsInNo}, #{supplierId}, #{supplierName}, #{goodsPrice}, #{goodsAmount}, #{goodsInTime}, #{warehouseId}, #{warehouseName}, #{operatorId}, #{operatorName}, #{remark}, #{goodsName}, #{goodsCategory})")
    @Options(useGeneratedKeys = true, keyProperty = "goodsInId")
    int insertGoodsIn(GoodsIn goodsIn);

    @Select("SELECT * FROM goodsin WHERE supplierId = #{supplierId}")
    List<GoodsIn> selectBySupplierId(@Param("supplierId") int supplierId);
}

