package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.*;
import com.trade.demo.mapper.*;
import com.trade.demo.service.GoodsInService;
import com.trade.demo.service.WarehouseGoodsService;
import com.trade.demo.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsInServiceImpl extends ServiceImpl<GoodsInMapper, GoodsIn> implements GoodsInService {
    @Autowired
    private GoodsInMapper goodsInMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private InListGoodsMapper inListGoodsMapper;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
    private WarehouseGoodsService warehousegoodsService;
    @Autowired
    private WarehouseGoodsMapper warehouseGoodsMapper;
    @Override
    @Transactional // Spring 提供的一个用于声明式事务管理的注解, 事务操作确保数据库的完整性和一致性
    public Integer saveAndSyncGoods(GoodsIn goodsIn) {
        if (goodsIn == null) {
            return 500;
        }
        goodsIn.setGoodsInNo("");//前端传入的不算有效数据,有效数据根据mysql自增生成的来.后续根据生成的填入GoodsInNo
        double total = 0;

        String[] goodsNames = goodsIn.getGoodsName().split(",");
        String[] goodsCategories = goodsIn.getGoodsCategory().split(",");
        String[] goodsPrices = goodsIn.getGoodsPrice().split(",");

        if (goodsNames.length != goodsCategories.length || goodsCategories.length != goodsPrices.length) {
            return 501;
        }

        List<Integer> goodsIdList = new ArrayList<>();
        StringBuilder goodsInNoBuilder = new StringBuilder();
        Integer goodsNum = goodsCategories.length;
        Warehouse warehouse = warehouseService.getById(goodsIn.getWarehouseId());
        warehouseMapper.selectById(goodsIn.getWarehouseId());
        if(warehouse.getStatus()=='0'){//  检查仓库status
            System.out.println("空");
            return 505;
        }
        //检查是否有容量
        if (goodsNum > warehouse.getAvailableCapacity() ) {
            return 502;
        }


        for (int i = 0; i < goodsCategories.length; i++) {
        try {
            double price = Double.parseDouble(goodsPrices[i]);

        } catch (NumberFormatException e) {
            return 503;
        }
        }
        try {
            for (int i = 0; i < goodsCategories.length; i++) {
                Goods goods = new Goods();
                goods.setGoodsName(goodsNames[i]);
                goods.setGoodsCategory(goodsCategories[i]);
                //这里的解析不会出现错误,因为上面503的返回语句没执行的话,说明数字有效
                    double price = Double.parseDouble(goodsPrices[i]);
                    goods.setPurchasePrice(price);
                    goods.setSellingPrice(price * 1.5);
                    total += price;


                goods.setOnShelf(1); // 默认上架
                goods.setWarehouseId(goodsIn.getWarehouseId());
                goodsMapper.insertGoods(goods); // 插入 Goods 表并获取自动生成的 goodsId
                //<<<<<<<<<<<<同步WarehouseGoods表
                WarehouseGoods warehouseGoods = new WarehouseGoods();
                warehouseGoods.setGoodsId(goods.getGoodsId());
                warehouseGoods.setWarehouseId(goodsIn.getWarehouseId());
                warehouseGoods.setGoodsQuantity(1);
                warehouseGoodsMapper.insertWarehouseGoods(warehouseGoods);
                //>>>>>>>>>>>>>同步WarehouseGoods表

                goodsIdList.add(goods.getGoodsId());
                InListGoods inListGoods = new InListGoods();
//                inListGoods.setGoodsId(goods.getGoodsId());
//
                String formattedGoodsId = String.format("%03d", goods.getGoodsId());

                if (goodsInNoBuilder.length() > 0) {
                    goodsInNoBuilder.append(",");
                }
                goodsInNoBuilder.append("GIN").append(formattedGoodsId);
            }

            goodsIn.setGoodsAmount(total);
            goodsIn.setGoodsInNo(goodsInNoBuilder.toString());
            goodsInMapper.insertGoodsIn(goodsIn); // 插入 GoodsIn 表并获取自动生成的 goodsInId
//<<<<<<<<<<<<<<<<<inListGoods同步
            for (Integer id : goodsIdList) {
                InListGoods inListGoods = new InListGoods();
                inListGoods.setGoodsId(id);
                inListGoods.setGoodsInId(goodsIn.getGoodsInId());

                inListGoodsMapper.insert(inListGoods); // 再次插入以确保更新
            }
//            >>>>>>>>>>>>inListGoods同步
            //数据都无误,能入库,在修改仓库容量
            warehouse.setAvailableCapacity(warehouse.getAvailableCapacity()-goodsNum.doubleValue());
            warehouseService.updateById(warehouse);
        } catch (Exception e) {
            return 504; // 未知错误
        }

        return 200;
    }

    @Override
    public List<GoodsIn> getBysupplierId(Integer supplierId) {
        return goodsInMapper.selectBySupplierId(supplierId);
    }


}
