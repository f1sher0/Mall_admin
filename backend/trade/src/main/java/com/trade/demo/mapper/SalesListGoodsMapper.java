package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.SalesListGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalesListGoodsMapper extends BaseMapper<SalesListGoods> {
    @Select("SELECT * FROM saleslistgoods WHERE salesId = #{salesId}")
    List<SalesListGoods> selectBySalesId(@Param("salesId") int salesId);
}
