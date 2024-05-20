package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.InListGoods;
import com.trade.demo.service.InListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inListGoods")
public class InListGoodsController {

    @Autowired
    private InListGoodsService inListGoodsService;

    @PostMapping("/add")
    public Result addInListGoods(@RequestBody InListGoods inListGoods) {
        boolean isSaved = inListGoodsService.save(inListGoods);
        if (isSaved) {
            return Result.success(inListGoods);
        } else {
            return Result.error("Failed to add inListGoods");
        }
    }

    @GetMapping("/get")
    public Result getInListGoodsById(@RequestParam Integer id) {
        InListGoods inListGoods = inListGoodsService.getById(id);
        if (inListGoods != null) {
            return Result.success(inListGoods);
        } else {
            return Result.error("InListGoods not found");
        }
    }

    @GetMapping("/list")
    public Result listInListGoods() {
        List<InListGoods> inListGoodsList = inListGoodsService.list();
        return Result.success(inListGoodsList);
    }

    @PutMapping("/update")
    public Result updateInListGoods(@RequestBody InListGoods inListGoods) {
        boolean isUpdated = inListGoodsService.updateById(inListGoods);
        if (isUpdated) {
            return Result.success(inListGoods);
        } else {
            return Result.error("Failed to update inListGoods");
        }
    }

    @DeleteMapping("/delete")
    public Result deleteInListGoods(@RequestParam Integer id) {
        boolean isRemoved = inListGoodsService.removeById(id);
        if (isRemoved) {
            return Result.success("InListGoods deleted successfully");
        } else {
            return Result.error("Failed to delete inListGoods");
        }
    }
}
