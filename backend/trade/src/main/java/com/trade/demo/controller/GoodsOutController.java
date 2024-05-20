package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.GoodsOut;
import com.trade.demo.service.GoodsOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goodsOut")
public class GoodsOutController {

    @Autowired
    private GoodsOutService goodsOutService;

    @PostMapping("/add")
    public Result addGoodsOut(@RequestBody GoodsOut goodsOut) {
        boolean isSaved = goodsOutService.save(goodsOut);
        if (isSaved) {
            return Result.success(goodsOut);
        } else {
            return Result.error("Failed to add goods out");
        }
    }

    @GetMapping("/get")
    public Result getGoodsOutById(@RequestParam Integer id) {
        GoodsOut goodsOut = goodsOutService.getById(id);
        if (goodsOut != null) {
            return Result.success(goodsOut);
        } else {
            return Result.error("Goods out not found");
        }
    }

    @GetMapping("/list")
    public Result listGoodsOut() {
        List<GoodsOut> goodsOutList = goodsOutService.list();
        return Result.success(goodsOutList);
    }

    @PutMapping("/update")
    public Result updateGoodsOut(@RequestBody GoodsOut goodsOut) {
        boolean isUpdated = goodsOutService.updateById(goodsOut);
        if (isUpdated) {
            return Result.success(goodsOut);
        } else {
            return Result.error("Failed to update goods out");
        }
    }

    @DeleteMapping("/delete")
    public Result deleteGoodsOut(@RequestParam Integer id) {
        boolean isRemoved = goodsOutService.removeById(id);
        if (isRemoved) {
            return Result.success("Goods out deleted successfully");
        } else {
            return Result.error("Failed to delete goods out");
        }
    }
}
