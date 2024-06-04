package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.Warehouse;
import com.trade.demo.service.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
@Api(tags = "仓库管理")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping("/add")
    @ApiOperation(value = "添加仓库")
    public Result addWarehouse(@RequestBody Warehouse warehouse) {
        boolean isSaved = warehouseService.save(warehouse);
        if (isSaved) {
            return Result.success(warehouse);
        } else {
            return Result.error("Failed to add warehouse");
        }
    }

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取仓库信息")
    public Result getWarehouseById(@RequestParam Integer id) {
        Warehouse warehouse = warehouseService.getById(id);
        if (warehouse != null) {
            return Result.success(warehouse);
        } else {
            return Result.error("Warehouse not found");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有仓库信息")
    public Result listWarehouses() {
        List<Warehouse> warehouseList = warehouseService.list();
        return Result.success(warehouseList);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新仓库信息")
    public Result updateWarehouse(@RequestBody Warehouse warehouse) {
        boolean isUpdated = warehouseService.updateById(warehouse);
        if (isUpdated) {
            return Result.success(warehouse);
        } else {
            return Result.error("Failed to update warehouse");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除仓库")
    public Result deleteWarehouse(@RequestParam Integer id) {
        boolean isRemoved = warehouseService.removeById(id);
        if (isRemoved) {
            return Result.success("Warehouse deleted successfully");
        } else {
            return Result.error("Failed to delete warehouse");
        }
    }

    @GetMapping("/capacity")
    @ApiOperation(value = "获取仓库容量信息")
    public Result getWarehouseCapacity(@RequestParam Integer id) {
        Warehouse warehouse = warehouseService.getById(id);
        if (warehouse != null) {
            return Result.success("Total Capacity: " + warehouse.getTotalCapacity() + ", Available Capacity: " + warehouse.getAvailableCapacity());
        } else {
            return Result.error("Warehouse not found");
        }
    }
}
