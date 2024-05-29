package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.WarehouseGoods;
import com.trade.demo.service.WarehouseGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouseGoods")
public class WarehouseGoodsController {

    @Autowired
    private WarehouseGoodsService warehouseGoodsService;

    @PostMapping("/add")
    public Result addWarehouseGoods(@RequestBody WarehouseGoods warehouseGoods) {
        boolean isSaved = warehouseGoodsService.save(warehouseGoods);
        if (isSaved) {
            return Result.success(warehouseGoods);
        } else {
            return Result.error("Failed to add warehouse goods");
        }
    }

    @GetMapping("/get")
    public Result getWarehouseGoodsById( Integer id) {
        WarehouseGoods warehouseGoods = warehouseGoodsService.getById(id);
        if (warehouseGoods != null) {
            return Result.success(warehouseGoods);
        } else {
            return Result.error("Warehouse goods not found");
        }
    }

    @GetMapping("/list")
    public Result listWarehouseGoods() {
        List<WarehouseGoods> warehouseGoodsList = warehouseGoodsService.list();
        return Result.success(warehouseGoodsList);
    }

    @PutMapping("/update")
    public Result updateWarehouseGoods(@RequestBody WarehouseGoods warehouseGoods) {
        boolean isUpdated = warehouseGoodsService.updateById(warehouseGoods);
        if (isUpdated) {
            return Result.success(warehouseGoods);
        } else {
            return Result.error("Failed to update warehouse goods");
        }
    }

    @DeleteMapping("/delete")
    public Result deleteWarehouseGoods(@RequestParam Integer id) {
        boolean isRemoved = warehouseGoodsService.removeById(id);
        if (isRemoved) {
            return Result.success("Warehouse goods deleted successfully");
        } else {
            return Result.error("Failed to delete warehouse goods");
        }
    }

    @GetMapping("/calculateQuantity")
    public Result calculateGoodsQuantity(@RequestParam Integer warehouseId, @RequestParam Integer goodsId) {
        WarehouseGoods warehouseGoods = warehouseGoodsService.getById(warehouseId);
        if (warehouseGoods != null) {
            String[] goodsIds = warehouseGoods.getGoodsId().split(",");
            String[] quantities = warehouseGoods.getGoodsQuantity().split(",");
            for (int i = 0; i < goodsIds.length; i++) {
                if (Integer.parseInt(goodsIds[i]) == goodsId) {
                    return Result.success(quantities[i]);
                }
            }
            return Result.error("Goods not found in warehouse");
        } else {
            return Result.error("Warehouse not found");
        }
    }
}
