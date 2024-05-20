package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.GoodsIn;
import com.trade.demo.service.GoodsInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goodsIn")
public class GoodsInController {

    @Autowired
    private GoodsInService goodsInService;

    @PostMapping("/add")
    public Result addGoodsIn(@RequestBody GoodsIn goodsIn) {
        boolean isSaved = goodsInService.save(goodsIn);
        if (isSaved) {
            return Result.success(goodsIn);
        } else {
            return Result.error("Failed to add goods in");
        }
    }

    @GetMapping("/get")
    public Result getGoodsInById(@RequestParam Integer id) {
        GoodsIn goodsIn = goodsInService.getById(id);
        if (goodsIn != null) {
            return Result.success(goodsIn);
        } else {
            return Result.error("Goods in not found");
        }
    }

    @GetMapping("/list")
    public Result listGoodsIn() {
        List<GoodsIn> goodsInList = goodsInService.list();
        return Result.success(goodsInList);
    }

    @PutMapping("/update")
    public Result updateGoodsIn(@RequestBody GoodsIn goodsIn) {
        boolean isUpdated = goodsInService.updateById(goodsIn);
        if (isUpdated) {
            return Result.success(goodsIn);
        } else {
            return Result.error("Failed to update goods in");
        }
    }

    @DeleteMapping("/delete")
    public Result deleteGoodsIn(@RequestParam Integer id) {
        boolean isRemoved = goodsInService.removeById(id);
        if (isRemoved) {
            return Result.success("Goods in deleted successfully");
        } else {
            return Result.error("Failed to delete goods in");
        }
    }
}
