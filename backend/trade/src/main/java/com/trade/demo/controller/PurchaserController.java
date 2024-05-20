package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.Purchaser;
import com.trade.demo.service.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchaser")
public class PurchaserController {

    @Autowired
    private PurchaserService purchaserService;

    @PostMapping("/add")
    public Result addPurchaser(@RequestBody Purchaser purchaser) {
        boolean isSaved = purchaserService.save(purchaser);
        if (isSaved) {
            return Result.success(purchaser);
        } else {
            return Result.error("Failed to add purchaser");
        }
    }

    @GetMapping("/get")
    public Result getPurchaserById(@RequestParam Integer id) {
        Purchaser purchaser = purchaserService.getById(id);
        if (purchaser != null) {
            return Result.success(purchaser);
        } else {
            return Result.error("Purchaser not found");
        }
    }

    @GetMapping("/list")
    public Result listPurchasers() {
        List<Purchaser> purchaserList = purchaserService.list();
        return Result.success(purchaserList);
    }

    @PutMapping("/update")
    public Result updatePurchaser(@RequestBody Purchaser purchaser) {
        boolean isUpdated = purchaserService.updateById(purchaser);
        if (isUpdated) {
            return Result.success(purchaser);
        } else {
            return Result.error("Failed to update purchaser");
        }
    }

    @DeleteMapping("/delete")
    public Result deletePurchaser(@RequestParam Integer id) {
        boolean isRemoved = purchaserService.removeById(id);
        if (isRemoved) {
            return Result.success("Purchaser deleted successfully");
        } else {
            return Result.error("Failed to delete purchaser");
        }
    }
}
