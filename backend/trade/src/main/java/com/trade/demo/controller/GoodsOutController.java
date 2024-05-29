package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.GoodsOut;
import com.trade.demo.service.GoodsOutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goodsOut")
@Api(tags = "商品出库管理")
public class GoodsOutController {

    @Autowired
    private GoodsOutService goodsOutService;

    @PostMapping("/add")

    @ApiOperation(value = "添加出库单")
    public Result addGoodsOut(@RequestBody GoodsOut goodsOut) {
        boolean isSaved = goodsOutService.saveAndSyncGoods(goodsOut);
        if (isSaved) {
            return Result.success(goodsOut);
        } else {
            return Result.error("Failed to add goods out,检查是否有无效的商品价格、商品信息数组长度不一致");
        }
    }
    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取出库单")
    public Result getGoodsOutById(@RequestParam Integer id) {
        GoodsOut goodsOut = goodsOutService.getById(id);
        if (goodsOut != null) {
            return Result.success(goodsOut);
        } else {
            return Result.error("Goods out not found");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有出库单")
    public Result listGoodsOut() {
        List<GoodsOut> goodsOutList = goodsOutService.list();
        return Result.success(goodsOutList);
    }

    @PutMapping("/update")
    @ApiOperation(value = "根据id更新出库单")
    public Result updateGoodsOut(@RequestBody GoodsOut goodsOut) {
        boolean isUpdated = goodsOutService.updateById(goodsOut);
        if (isUpdated) {
            return Result.success(goodsOut);
        } else {
            return Result.error("Failed to update goods out");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据id删除出库单")
    public Result deleteGoodsOut(@RequestParam Integer id) {
        boolean isRemoved = goodsOutService.removeById(id);
        if (isRemoved) {
            return Result.success("Goods out deleted successfully");
        } else {
            return Result.error("Failed to delete goods out");
        }
    }
}
