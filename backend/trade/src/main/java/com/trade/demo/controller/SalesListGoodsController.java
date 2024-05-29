package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.SalesListGoods;
import com.trade.demo.service.SalesListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salesListGoods")
public class SalesListGoodsController {

    @Autowired
    private SalesListGoodsService saleListGoodsService;

    @PostMapping("/add")
    public Result addSalesListGoods(@RequestBody SalesListGoods saleListGoods) {
        boolean isSaved = saleListGoodsService.save(saleListGoods);
        if (isSaved) {
            return Result.success(saleListGoods);
        } else {
            return Result.error("Failed to add saleListGoods");
        }
    }

    @GetMapping("/get")
    public Result getSalesListGoodsById(@RequestParam Integer id) {
        SalesListGoods saleListGoods = saleListGoodsService.getById(id);
        if (saleListGoods != null) {
            return Result.success(saleListGoods);
        } else {
            return Result.error("SalesListGoods not found");
        }
    }

    @GetMapping("/list")
    public Result listSalesListGoods() {
        List<SalesListGoods> saleListGoodsList = saleListGoodsService.list();
        return Result.success(saleListGoodsList);
    }

    @PutMapping("/update")
    public Result updateSalesListGoods(@RequestBody SalesListGoods saleListGoods) {
        boolean isUpdated = saleListGoodsService.updateById(saleListGoods);
        if (isUpdated) {
            return Result.success(saleListGoods);
        } else {
            return Result.error("Failed to update saleListGoods");
        }
    }

    @DeleteMapping("/delete")
    public Result deleteSalesListGoods(@RequestParam Integer id) {
        boolean isRemoved = saleListGoodsService.removeById(id);
        if (isRemoved) {
            return Result.success("SalesListGoods deleted successfully");
        } else {
            return Result.error("Failed to delete saleListGoods");
        }
    }
}
