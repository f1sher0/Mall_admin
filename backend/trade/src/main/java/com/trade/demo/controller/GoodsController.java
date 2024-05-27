package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.Goods;
import com.trade.demo.service.GoodsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
@Api(tags = "商品管理接口") // @Api 注解用于描述整个Controller的作用
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/add")
    @ApiOperation(value = "添加商品", notes = "根据请求体中的商品信息添加商品")
    public Result addGoods(@RequestBody Goods goods) {
        boolean isSaved = goodsService.save(goods);
        if (isSaved) {
            return Result.success(goods);
        } else {
            return Result.error("Failed to add goods");
        }
    }

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取商品", notes = "根据商品ID查询商品信息")
    @ApiImplicitParam(name = "id", value = "商品ID", required = true, dataType = "int")
    public Result getGoodsById(@RequestParam Integer id) {
        Goods goods = goodsService.getById(id);
        if (goods != null) {
            return Result.success(goods);
        } else {
            return Result.error("Goods not found");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有商品列表", notes = "获取所有商品的列表信息")
    public Result listGoods() {
        List<Goods> goodsList = goodsService.list();
        return Result.success(goodsList);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新商品信息", notes = "根据请求体中的商品信息更新商品")
    public Result updateGoods(@RequestBody Goods goods) {
        boolean isUpdated = goodsService.updateById(goods);
        if (isUpdated) {
            return Result.success(goods);
        } else {
            return Result.error("Failed to update goods");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除商品", notes = "根据商品ID删除商品")
    @ApiImplicitParam(name = "id", value = "商品ID", required = true, dataType = "int")
    public Result deleteGoods(@RequestParam Integer id) {
        boolean isRemoved = goodsService.removeById(id);
        if (isRemoved) {
            return Result.success("Goods deleted successfully");
        } else {
            return Result.error("Failed to delete goods");
        }
    }

    @PostMapping("/shelf")
    @ApiOperation(value = "上架商品", notes = "根据商品ID上架商品")
    @ApiImplicitParam(name = "goodsId", value = "商品ID", required = true, dataType = "int")
    public Result shelfGoods(@RequestParam int goodsId) {
        boolean isShelf = goodsService.shelfGoods(goodsId);
        if (isShelf) {
            return Result.success("Goods onshelf successfully");
        } else {
            return Result.error("Failed to onshelf goods");
        }
    }

    @PostMapping("/unshelf")
    @ApiOperation(value = "下架商品", notes = "根据商品ID下架商品")
    @ApiImplicitParam(name = "goodsId", value = "商品ID", required = true, dataType = "int")
    public Result unshelfGoods(@RequestParam int goodsId) {
        boolean isShelf = goodsService.unshelfGoods(goodsId);
        if (isShelf) {
            return Result.success("Goods unshelf successfully");
        } else {
            return Result.error("Failed to unshelf goods");
        }
    }
}
