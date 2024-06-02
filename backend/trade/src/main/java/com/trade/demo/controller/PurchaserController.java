package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.Purchaser;
import com.trade.demo.service.PurchaserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchaser")
@Api(tags = "采购商管理")
public class PurchaserController {

    @Autowired
    private PurchaserService purchaserService;

    @PostMapping("/add")
    @ApiOperation(value = "添加采购商")
    public Result addPurchaser(@RequestBody Purchaser purchaser) {
        purchaser.setStatus('0');
        boolean isSaved = purchaserService.save(purchaser);
        if (isSaved) {
            return Result.success(purchaser);
        } else {
            return Result.error("Failed to add purchaser");
        }
    }

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取采购商")
    public Result getPurchaserById(@RequestParam Integer id) {
        Purchaser purchaser = purchaserService.getById(id);
        if (purchaser != null) {
            return Result.success(purchaser);
        } else {
            return Result.error("Purchaser not found");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有采购商")
    public Result listPurchasers() {
        List<Purchaser> purchaserList = purchaserService.list();
        return Result.success(purchaserList);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新采购商信息")
    public Result updatePurchaser(@RequestBody Purchaser purchaser) {
        boolean isUpdated = purchaserService.updateById(purchaser);
        if (isUpdated) {
            return Result.success(purchaser);
        } else {
            return Result.error("Failed to update purchaser");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除采购商")
    public Result deletePurchaser(@RequestParam Integer id) {
        boolean isRemoved = purchaserService.removeById(id);
        if (isRemoved) {
            return Result.success("Purchaser deleted successfully");
        } else {
            return Result.error("Failed to delete purchaser");
        }
    }
}
