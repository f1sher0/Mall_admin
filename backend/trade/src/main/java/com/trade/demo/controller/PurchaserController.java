package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.dto.GoodsOutInfoDTO;
import com.trade.demo.entity.*;
import com.trade.demo.mapper.GoodsMapper;
import com.trade.demo.mapper.GoodsOutMapper;
import com.trade.demo.mapper.SalesListGoodsMapper;
import com.trade.demo.service.PurchaserService;
import com.trade.demo.service.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/purchaser")
@Api(tags = "采购商管理")
public class PurchaserController {

    @Autowired
    private PurchaserService purchaserService;
    @Autowired
    private GoodsOutMapper goodsOutMapper;
    @Autowired
    private SalesListGoodsMapper outListGoodsMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private WarehouseService warehouseService;
    @PostMapping("/add")
    @ApiOperation(value = "添加采购商")
    public Result addPurchaser(@RequestBody Purchaser purchaser) {
        purchaser.setStatus('0');
        boolean isSaved = purchaserService.save(purchaser);
        if (isSaved) {
            return Result.success(purchaser);
        } else {
            return Result.error("Failed to add purchaser");
        }
    }

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取采购商")
    public Result getPurchaserById(@RequestParam Integer id) {
        Purchaser purchaser = purchaserService.getById(id);
        if (purchaser != null) {
            return Result.success(purchaser);
        } else {
            return Result.error("Purchaser not found");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有采购商")
    public Result listPurchasers() {
        List<Purchaser> purchaserList = purchaserService.list();
        return Result.success(purchaserList);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新采购商信息")
    public Result updatePurchaser(@RequestBody Purchaser purchaser) {
        boolean isUpdated = purchaserService.updateById(purchaser);
        if (isUpdated) {
            return Result.success(purchaser);
        } else {
            return Result.error("Failed to update purchaser");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除采购商")
    public Result deletePurchaser(@RequestParam Integer id) {
        boolean isRemoved = purchaserService.removeById(id);
        if (isRemoved) {
            return Result.success("Purchaser deleted successfully");
        } else {
            return Result.error("Failed to delete purchaser");
        }
    }

    @GetMapping("/goodsOutInfo")
    @ApiOperation(value = "按采购商ID获取GoodsOutInfo信息，不止GoodsOut表的信息")
    public Result getGoodsOutInfoByPurchaser(int purchaserId) {
        List<GoodsOut> goodsOutList = goodsOutMapper.selectByPurchaserId(purchaserId);
        List<GoodsOutInfoDTO> resultList = new ArrayList<>();

        for (GoodsOut goodsOut : goodsOutList) {
            int salesId = goodsOut.getSalesId();
            List<SalesListGoods> outListGoods = outListGoodsMapper.selectBySalesId(salesId);
            for (SalesListGoods outListGood : outListGoods) {
                Goods goods = goodsMapper.selectById(outListGood.getGoodsId());
                Purchaser purchaser = purchaserService.getById(purchaserId);
                Warehouse warehouse = warehouseService.getById(goods.getWarehouseId());

                GoodsOutInfoDTO dto = new GoodsOutInfoDTO();
                dto.setSalesTime(goodsOut.getSalesTime());
                dto.setPurchaserName(goodsOut.getPurchaserName());
                dto.setPurchaserDesc(purchaser.getPurchaserDesc());
                dto.setPurchaserAddress(purchaser.getAddress());
                dto.setSalesId(salesId);
                dto.setGoodsId(outListGood.getGoodsId());
                dto.setIsReturned(outListGood.getIsReturned());
                dto.setWarehouseId(goods.getWarehouseId());
                dto.setWarehouseName(warehouse.getWarehouseName());
                dto.setWarehouseAddress(warehouse.getWarehouseLocation());
                dto.setOnShelf(goods.getOnShelf());
                dto.setPurchasePrice(goods.getPurchasePrice());
                dto.setSellingPrice(goods.getSellingPrice());

                resultList.add(dto);
            }
        }

        return Result.success(resultList);
    }
}
