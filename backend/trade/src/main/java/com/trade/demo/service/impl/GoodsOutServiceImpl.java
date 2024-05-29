package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.Goods;
import com.trade.demo.entity.GoodsOut;

import com.trade.demo.mapper.*;
import com.trade.demo.service.GoodsOutService;
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


    @Transactional // Spring 提供的一个用于声明式事务管理的注解, 事务操作确保数据库的完整性和一致性
    @Override
    public boolean saveAndSyncGoods(GoodsOut goodsOut) {
         if (goodsOut == null) {
            return false;
        }

        double total = 0;
//        List<Integer> goodsIdList = new ArrayList<>();
        List<Integer> goodsWareIdList = new ArrayList<>();
        StringBuilder salesNoBuilder = new StringBuilder();
        StringBuilder salesPriceBuilder = new StringBuilder();
        StringBuilder salesWarehouseIdBuilder = new StringBuilder();
        // 解析销售单中的商品信息
        String[] goodsIdsStr = goodsOut.getSalesNo().split(",");
        for (String goodsIdStr : goodsIdsStr) {
            // 获取后三位字符作为商品ID
            String idStr = goodsIdStr ;
            int goodsId = Integer.parseInt(idStr);

            // 查询商品信息
            Goods goods = goodsMapper.selectById(goodsId);
            if (goods == null) {
                throw new IllegalArgumentException("无效的商品ID: " + goodsId);
            }
            goodsWareIdList.add(goods.getWarehouseId());

            // 累加销售价格
            total += goods.getSellingPrice();



            // 更新商品状态
            goods.setOnShelf(0); // 下架
            goods.setUpdateTime(new Date());
            goodsMapper.updateById(goods);

            // 构建销售单编号
            if (salesNoBuilder.length() > 0) {
                salesNoBuilder.append(",");
            }
            if(salesPriceBuilder.length()>0){
                salesPriceBuilder.append(",");
            }
            if(  salesWarehouseIdBuilder.length()>0){
                salesWarehouseIdBuilder.append(",");
            }
            salesNoBuilder.append("SOUT").append(String.format("%03d", goodsId));
            salesPriceBuilder.append(goods.getSellingPrice().toString());
            salesWarehouseIdBuilder.append(goods.getWarehouseId());
        }

        // 更新销售单信息
        goodsOut.setGoodsPrice( salesPriceBuilder.toString()  );
        goodsOut.setGoodsAmount(total);
        goodsOut.setSalesTime(new Date());
        goodsOut.setSalesNo(salesNoBuilder.toString());
        goodsOut.setWarehouseId(salesWarehouseIdBuilder.toString());

        int result = goodsOutMapper.insertGoodsOut(goodsOut);
        return result > 0;
    }

}
