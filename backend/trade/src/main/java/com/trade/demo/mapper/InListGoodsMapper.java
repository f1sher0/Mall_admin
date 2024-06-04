package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.InListGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InListGoodsMapper extends BaseMapper<InListGoods> {
    @Select("SELECT * FROM inlistgoods WHERE goodsInId = #{goodsInId}")
    List<InListGoods> selectByGoodsInId(@Param("goodsInId") int goodsInId);
}
