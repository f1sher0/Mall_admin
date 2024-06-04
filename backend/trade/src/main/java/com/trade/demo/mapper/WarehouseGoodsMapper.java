package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.WarehouseGoods;
import com.trade.demo.entity.WarehouseGoodsGroupedInfo;
import com.trade.demo.entity.WarehouseGoodsInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WarehouseGoodsMapper extends BaseMapper<WarehouseGoods> {
    @Select("SELECT wg.warehouseId, w.warehouseName, g.goodsName, g.sellingPrice " +
            "FROM warehousegoods wg " +
            "JOIN goods g ON FIND_IN_SET(g.goodsId, wg.goodsId) > 0 " +
            "JOIN warehouse w ON wg.warehouseId = w.warehouseId " +
            "WHERE wg.warehouseId = #{warehouseId} AND g.onShelf = 1 " +
            "GROUP BY wg.warehouseId, w.warehouseName, g.goodsName, g.sellingPrice")
    List<WarehouseGoodsInfo> getWarehouseGoodsInfo(@Param("warehouseId") int warehouseId);

//    @Select("SELECT wg.warehouseId, w.warehouseName, g.goodsName, g.sellingPrice " +
//            "FROM warehousegoods wg " +
//            "JOIN goods g ON FIND_IN_SET(g.goodsId, wg.goodsId) > 0 " +
//            "JOIN warehouse w ON wg.warehouseId = w.warehouseId " +
//            "WHERE g.onShelf = 1 " +
//            "GROUP BY  wg.warehouseId, g.goodsId")
//    List<WarehouseGoodsInfo> getWarehouseGoodsInfo();
    @Select("SELECT wg.warehouseId, w.warehouseName, g.goodsName, g.sellingPrice " +
            "FROM warehousegoods wg " +
            "JOIN goods g ON FIND_IN_SET(g.goodsId, wg.goodsId) > 0 " +
            "JOIN warehouse w ON wg.warehouseId = w.warehouseId " +
            "WHERE g.onShelf = 1 " +
            "GROUP BY wg.warehouseId, w.warehouseName, g.goodsName, g.sellingPrice")
    List<WarehouseGoodsInfo> getWarehouseGoodsInfo();
    @Select("SELECT wg.warehouseId, w.warehouseName, g.goodsName, COUNT(g.goodsName) AS quantity " +
            "FROM warehousegoods wg " +
            "JOIN goods g ON FIND_IN_SET(g.goodsId, wg.goodsId) > 0 " +
            "JOIN warehouse w ON wg.warehouseId = w.warehouseId " +
            "WHERE g.onShelf = 1 " +
            "GROUP BY wg.warehouseId, g.goodsName")
    List<WarehouseGoodsGroupedInfo> getWarehouseGoodsGroupedInfo();

    @Insert("INSERT INTO warehousegoods (warehouseId, goodsId, goodsQuantity) " +
            "VALUES (#{warehouseId}, #{goodsId}, #{goodsQuantity})")
    @Options(useGeneratedKeys = true, keyProperty = "warehouseGoodsId")
    int insertWarehouseGoods(WarehouseGoods warehouseGoods);

}
