package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.WarehouseGoods;
import com.trade.demo.entity.WarehouseGoodsGroupedInfo;
import com.trade.demo.entity.WarehouseGoodsInfo;
import com.trade.demo.service.WarehouseGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("/api/warehouseGoods")
@Api(tags ="库存信息管理")
public class WarehouseGoodsController {

    @Autowired
    private WarehouseGoodsService warehouseGoodsService;

    @ApiOperation(value = "添加新的仓库商品条目")
    @PostMapping("/add")
    public Result addWarehouseGoods(@RequestBody WarehouseGoods warehouseGoods) {
        boolean isSaved = warehouseGoodsService.save(warehouseGoods);
        if (isSaved) {
            return Result.success(warehouseGoods);
        } else {
            return Result.error("添加仓库商品失败");
        }
    }

    @ApiOperation(value = "根据ID获取仓库商品信息")
    @GetMapping("/get")
    public Result getWarehouseGoodsById(@RequestParam Integer id) {
        WarehouseGoods warehouseGoods = warehouseGoodsService.getById(id);
        if (warehouseGoods != null) {
            return Result.success(warehouseGoods);
        } else {
            return Result.error("未找到仓库商品");
        }
    }

    @ApiOperation(value = "获取所有仓库商品列表")
    @GetMapping("/list")
    public Result listWarehouseGoods() {
        List<WarehouseGoods> warehouseGoodsList = warehouseGoodsService.list();
        return Result.success(warehouseGoodsList);
    }

    @GetMapping("/info")
    @ApiOperation(value = "查询每个仓库的存储商品的信息 商品名字/价格等")
    public Result getWarehouseGoodsInfo(@RequestParam(required = false) String id) {
        List<WarehouseGoodsInfo> info;
        if (StringUtils.isNotBlank(id)) {
            info = warehouseGoodsService.getWarehouseGoodsInfo(Integer.parseInt(id));
        } else {
            // todo 可以遍历所有的warehouseid,进行封装返回数据
            info = warehouseGoodsService.getWarehouseGoodsInfo();
            System.out.println("ok null");
        }
        return Result.success(info);
    }


    @GetMapping("/groupedinfo")
    @ApiOperation(value = "查询每个仓库的存储商品的信息，并按商品名分组")
    public Result getWarehouseGoodsGroupedInfo() {
        List<WarehouseGoodsGroupedInfo> groupedInfo = warehouseGoodsService.getWarehouseGoodsGroupedInfo();
        return Result.success(groupedInfo);
    }

    @ApiOperation(value = "更新现有的仓库商品条目")
    @PutMapping("/update")
    public Result updateWarehouseGoods(@RequestBody WarehouseGoods warehouseGoods) {
        boolean isUpdated = warehouseGoodsService.updateById(warehouseGoods);
        if (isUpdated) {
            return Result.success(warehouseGoods);
        } else {
            return Result.error("更新仓库商品失败");
        }
    }

    @ApiOperation(value = "根据ID删除仓库商品条目")
    @DeleteMapping("/delete")
    public Result deleteWarehouseGoods(@RequestParam Integer id) {
        boolean isRemoved = warehouseGoodsService.removeById(id);
        if (isRemoved) {
            return Result.success("仓库商品删除成功");
        } else {
            return Result.error("删除仓库商品失败");
        }
    }

//    @ApiOperation(value = "计算仓库中特定商品的数量")
//    @GetMapping("/calculateQuantity")
//    public Result calculateGoodsQuantity(@RequestParam Integer warehouseId, @RequestParam Integer goodsId) {
//        WarehouseGoods warehouseGoods = warehouseGoodsService.getById(warehouseId);
//        if (warehouseGoods != null) {
//            String[] goodsIds = warehouseGoods.getGoodsId().split(",");
//            String[] quantities = warehouseGoods.getGoodsQuantity().split(",");
//            for (int i = 0; i < goodsIds.length; i++) {
//                if (Integer.parseInt(goodsIds[i]) == goodsId) {
//                    return Result.success(quantities[i]);
//                }
//            }
//            return Result.error("仓库中未找到该商品");
//        } else {
//            return Result.error("未找到仓库");
//        }
//    }
}
