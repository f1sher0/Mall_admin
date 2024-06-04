package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.GoodsOut;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsOutMapper extends BaseMapper<GoodsOut> {
    @Insert("INSERT INTO goodsout (salesNo, purchaserId, purchaserName, goodsPrice, goodsAmount, salesTime, warehouseId, warehouseName, operatorId, operatorName, remark) " +
            "VALUES (#{salesNo}, #{purchaserId}, #{purchaserName}, #{goodsPrice}, #{goodsAmount}, #{salesTime}, #{warehouseId}, #{warehouseName}, #{operatorId}, #{operatorName}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "salesId")
    int insertGoodsOut(GoodsOut goodsOut);

    @Select("SELECT * FROM goodsout WHERE purchaserId = #{purchaserId}")
    List<GoodsOut> selectByPurchaserId(@Param("purchaserId") int purchaserId);
}
