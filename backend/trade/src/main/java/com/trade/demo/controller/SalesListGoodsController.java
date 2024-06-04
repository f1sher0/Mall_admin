package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.SalesListGoods;
import com.trade.demo.service.SalesListGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salesListGoods")
@Api(tags = "销售清单商品管理")
public class SalesListGoodsController {

    @Autowired
    private SalesListGoodsService salesListGoodsService;

    @PostMapping("/add")
    @ApiOperation(value = "添加销售清单商品")
    public Result addSalesListGoods(@RequestBody SalesListGoods salesListGoods) {
        boolean isSaved = salesListGoodsService.save(salesListGoods);
        if (isSaved) {
            return Result.success(salesListGoods);
        } else {
            return Result.error("Failed to add salesListGoods");
        }
    }

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取销售清单商品")
    public Result getSalesListGoodsById(@RequestParam Integer id) {
        SalesListGoods salesListGoods = salesListGoodsService.getById(id);
        if (salesListGoods != null) {
            return Result.success(salesListGoods);
        } else {
            return Result.error("SalesListGoods not found");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有销售清单商品")
    public Result listSalesListGoods() {
        List<SalesListGoods> salesListGoodsList = salesListGoodsService.list();
        return Result.success(salesListGoodsList);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新销售清单商品信息")
    public Result updateSalesListGoods(@RequestBody SalesListGoods salesListGoods) {
        boolean isUpdated = salesListGoodsService.updateById(salesListGoods);
        if (isUpdated) {
            return Result.success(salesListGoods);
        } else {
            return Result.error("Failed to update salesListGoods");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据ID删除销售清单商品")
    public Result deleteSalesListGoods(@RequestParam Integer id) {
        boolean isRemoved = salesListGoodsService.removeById(id);
        if (isRemoved) {
            return Result.success("SalesListGoods deleted successfully");
        } else {
            return Result.error("Failed to delete salesListGoods");
        }
    }
}
