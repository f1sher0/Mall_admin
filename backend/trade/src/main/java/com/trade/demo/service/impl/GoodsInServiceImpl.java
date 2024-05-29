package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.Goods;
import com.trade.demo.entity.GoodsIn;
import com.trade.demo.entity.InListGoods;
import com.trade.demo.mapper.GoodsInMapper;
import com.trade.demo.mapper.GoodsMapper;
import com.trade.demo.mapper.InListGoodsMapper;
import com.trade.demo.service.GoodsInService;
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

    @Override
    @Transactional // Spring 提供的一个用于声明式事务管理的注解, 事务操作确保数据库的完整性和一致性
    public boolean saveAndSyncGoods(GoodsIn goodsIn) {
        if (goodsIn == null) {
            return false;
        }
        goodsIn.setGoodsInNo("");//前端传入的不算有效数据,有效数据根据mysql自增生成的来.后续根据生成的填入GoodsInNo
        double total = 0;
        // 解析 GoodsIn 表中的商品信息，并插入到 Goods 表
//        String[] goodsNos = goodsIn.getGoodsInNo().split(",");
        String[] goodsNames = goodsIn.getGoodsName().split(",");
        String[] goodsCategories = goodsIn.getGoodsCategory().split(",");
        String[] goodsPrices = goodsIn.getGoodsPrice().split(",");
        // 确保数组长度一致
//        if (goodsNos.length != goodsNames.length || goodsNames.length != goodsCategories.length || goodsCategories.length != goodsPrices.length) {
//            throw new IllegalArgumentException("商品信息数组长度不一致");
//        }
        if (  goodsNames.length != goodsCategories.length || goodsCategories.length != goodsPrices.length) {
            throw new IllegalArgumentException("商品信息数组长度不一致");
        }
        List<Integer> goodsIdList = new ArrayList<>();
        StringBuilder goodsInNoBuilder = new StringBuilder();
        for (int i = 0; i < goodsCategories.length; i++) {
            Goods goods = new Goods();
            goods.setGoodsName(goodsNames[i]);
            goods.setGoodsCategory(goodsCategories[i]);

            try {
                double price = Double.parseDouble(goodsPrices[i]);
                goods.setPurchasePrice(price);
                goods.setSellingPrice(price * 1.5);
                total += price;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("无效的商品价格: " + goodsPrices[i], e);
            }

            goods.setOnShelf(1); // 默认上架
            goodsMapper.insertGoods(goods); // 插入 Goods 表并获取自动生成的 goodsId
            goodsIdList.add(goods.getGoodsId());
            InListGoods inListGoods = new InListGoods();
            inListGoods.setGoodsId(goods.getGoodsId());
            String formattedGoodsId = String.format("%03d", goods.getGoodsId());

            if (goodsInNoBuilder.length() > 0) {
                goodsInNoBuilder.append(",");
            }
            goodsInNoBuilder.append("GIN").append(formattedGoodsId);
            // 注意：此处暂时不能获取 goodsInId，因为 goodsIn 还未插入，插入后，才可以通过mapper定义的使用生成的id进行数据处理
//            inListGoodsMapper.insert(inListGoods);
        }

        goodsIn.setGoodsAmount(total);
        goodsIn.setGoodsInNo(goodsInNoBuilder.toString());
        goodsInMapper.insertGoodsIn(goodsIn); // 插入 GoodsIn 表并获取自动生成的 goodsInId

        for(Integer id:goodsIdList){
            InListGoods inListGoods = new InListGoods();
            inListGoods.setGoodsId(id);
            inListGoods.setGoodsInId(goodsIn.getGoodsInId());

            inListGoodsMapper.insert(inListGoods); // 再次插入以确保更新
        }



        return true;
    }
}
