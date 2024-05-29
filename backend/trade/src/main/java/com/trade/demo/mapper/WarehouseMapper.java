package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.User;
import com.trade.demo.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WarehouseMapper extends BaseMapper<Warehouse> {
    @Select("SELECT warehouseName FROM warehouse WHERE warehouseId = #{warehouseId}")
    String getWarehouseNameById(@Param("warehouseId") Integer warehouseId);
}
