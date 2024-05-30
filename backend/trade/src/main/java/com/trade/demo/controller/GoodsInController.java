package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.GoodsIn;
import com.trade.demo.service.GoodsInService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goodsIn")
@Api(tags = "商品入库管理")
public class GoodsInController {

    @Autowired
    private GoodsInService goodsInService;

    @PostMapping("/add")
    @ApiOperation(value = "添加商品入库")
    public Result addGoodsIn(@RequestBody GoodsIn goodsIn) {
        Integer isSaved = goodsInService.saveAndSyncGoods(goodsIn);
        switch (isSaved) {
            case 200:
                return Result.success(goodsIn);
            case 500:
                return Result.error("GoodsIn 对象为空。");
            case 501:
                return Result.error("商品信息数组长度不一致。");
            case 502:
                return Result.error("仓库容量不足。");
            case 503:
                return Result.error("无效的商品价格。");
            case 504:
                return Result.error("发生未知错误。");
            default:
                return Result.error("发生意外错误。");
        }
    }


    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取商品入库")
    public Result getGoodsInById(@RequestParam Integer id) {
        GoodsIn goodsIn = goodsInService.getById(id);
        if (goodsIn != null) {
            return Result.success(goodsIn);
        } else {
            return Result.error("Goods in not found");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有商品入库记录")
    public Result listGoodsIn() {
        List<GoodsIn> goodsInList = goodsInService.list();
        return Result.success(goodsInList);
    }

    @PutMapping("/update")
    @ApiOperation(value = "根据ID更新商品入库记录")
    public Result updateGoodsIn(@RequestBody GoodsIn goodsIn) {
        boolean isUpdated = goodsInService.updateById(goodsIn);
        if (isUpdated) {
            return Result.success(goodsIn);
        } else {
            return Result.error("Failed to update goods in");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据ID删除商品入库记录")
    public Result deleteGoodsIn(@RequestParam Integer id) {
        boolean isRemoved = goodsInService.removeById(id);
        if (isRemoved) {
            return Result.success("Goods in deleted successfully");
        } else {
            return Result.error("Failed to delete goods in");
        }
    }
}
