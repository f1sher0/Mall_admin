package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.GoodsOut;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface GoodsOutMapper extends BaseMapper<GoodsOut> {
    @Insert("INSERT INTO goodsout (salesNo, purchaserId, purchaserName, goodsPrice, goodsAmount, salesTime, warehouseId, warehouseName, operatorId, operatorName, remark) " +
            "VALUES (#{salesNo}, #{purchaserId}, #{purchaserName}, #{goodsPrice}, #{goodsAmount}, #{salesTime}, #{warehouseId}, #{warehouseName}, #{operatorId}, #{operatorName}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "salesId")
    int insertGoodsOut(GoodsOut goodsOut);

}
