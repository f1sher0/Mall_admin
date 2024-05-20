package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.Goods;
import com.trade.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/add")
    public Result addGoods(@RequestBody Goods goods) {
        boolean isSaved = goodsService.save(goods);
        if (isSaved) {
            return Result.success(goods);
        } else {
            return Result.error("Failed to add goods");
        }
    }

    @GetMapping("/get")
    public Result getGoodsById(@RequestParam Integer id) {
        Goods goods = goodsService.getById(id);
        if (goods != null) {
            return Result.success(goods);
        } else {
            return Result.error("Goods not found");
        }
    }

    @GetMapping("/list")
    public Result listGoods() {
        List<Goods> goodsList = goodsService.list();
        return Result.success(goodsList);
    }

    @PutMapping("/update")
    public Result updateGoods(@RequestBody Goods goods) {
        boolean isUpdated = goodsService.updateById(goods);
        if (isUpdated) {
            return Result.success(goods);
        } else {
            return Result.error("Failed to update goods");
        }
    }

    @DeleteMapping("/delete")
    public Result deleteGoods(@RequestParam Integer id) {
        boolean isRemoved = goodsService.removeById(id);
        if (isRemoved) {
            return Result.success("Goods deleted successfully");
        } else {
            return Result.error("Failed to delete goods");
        }
    }
}
