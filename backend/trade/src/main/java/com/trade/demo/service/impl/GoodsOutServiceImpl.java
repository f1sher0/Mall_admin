package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.Goods;
import com.trade.demo.entity.GoodsOut;

import com.trade.demo.entity.Warehouse;
import com.trade.demo.mapper.*;
import com.trade.demo.service.GoodsOutService;
import com.trade.demo.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsOutServiceImpl extends ServiceImpl<GoodsOutMapper, GoodsOut> implements GoodsOutService {
    @Autowired
    private GoodsOutMapper goodsOutMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private SalesListGoodsMapper salesListGoodsMapper;
    @Autowired
    private WarehouseService warehouseService;
    @Transactional // Spring 提供的一个用于声明式事务管理的注解, 事务操作确保数据库的完整性和一致性
    @Override
    public Integer saveAndSyncGoods(GoodsOut goodsOut) {
        if (goodsOut == null) {
            return 500;
        }

        double total = 0;
        List<Integer> goodsWareIdList = new ArrayList<>();
        StringBuilder salesNoBuilder = new StringBuilder();
        StringBuilder salesPriceBuilder = new StringBuilder();
        StringBuilder salesWarehouseIdBuilder = new StringBuilder();

        // 解析销售单中的商品信息
        String[] goodsIdsStr = goodsOut.getSalesNo().split(",");
        List<Integer> goodsIds = new ArrayList<>();
        for (String goodsIdStr : goodsIdsStr) {
            String idStr = goodsIdStr;
            int goodsId;
            try {
                goodsId = Integer.parseInt(idStr);
                goodsIds.add(goodsId);
            } catch (NumberFormatException e) {
                return 503; // 无效的商品ID格式
            }
        }

        for (Integer goodsId : goodsIds) {
             // 查询商品信息
            Goods goods = goodsMapper.selectById(goodsId);
            if (goods == null) {
                return 504; // 无效的商品ID
            }
            if(goods.getOnShelf()==0){
                return 506;
            }
        }
        for (Integer goodsId : goodsIds) {
            Goods goods = goodsMapper.selectById(goodsId);
            goodsWareIdList.add(goods.getWarehouseId());
            // 累加销售价格
            total += goods.getSellingPrice();

            // 更新商品状态
            goods.setOnShelf(0); // 下架
            goods.setUpdateTime(new Date());
            goodsMapper.updateById(goods);
            Warehouse warehouse= warehouseService.getById(goods.getWarehouseId());
            warehouse.setAvailableCapacity(warehouse.getAvailableCapacity()+1);
            warehouseService.updateById(warehouse);
            // 构建销售单编号
            if (salesNoBuilder.length() > 0) {
                salesNoBuilder.append(",");
            }
            if (salesPriceBuilder.length() > 0) {
                salesPriceBuilder.append(",");
            }
            if (salesWarehouseIdBuilder.length() > 0) {
                salesWarehouseIdBuilder.append(",");
            }
            salesNoBuilder.append("SOUT").append(String.format("%03d", goodsId));
            salesPriceBuilder.append(goods.getSellingPrice().toString());
            salesWarehouseIdBuilder.append(goods.getWarehouseId());
        }

        // 更新销售单信息
        goodsOut.setGoodsPrice(salesPriceBuilder.toString());
        goodsOut.setGoodsAmount(total);
        goodsOut.setSalesTime(new Date());
        goodsOut.setSalesNo(salesNoBuilder.toString());
        goodsOut.setWarehouseId(salesWarehouseIdBuilder.toString());

        int result = goodsOutMapper.insertGoodsOut(goodsOut);


        if (result > 0) {
            return 200; // 成功
        } else {
            return 505; // 数据库插入失败
        }
    }


}
