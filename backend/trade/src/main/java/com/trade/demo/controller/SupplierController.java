package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.Supplier;
import com.trade.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/add")
    public Result addSupplier(@RequestBody Supplier supplier) {
        boolean isSaved = supplierService.save(supplier);
        if (isSaved) {
            return Result.success(supplier);
        } else {
            return Result.error("Failed to add supplier");
        }
    }

    @GetMapping("/get")
    public Result getSupplierById(@RequestParam Integer id) {
        Supplier supplier = supplierService.getById(id);
        if (supplier != null) {
            return Result.success(supplier);
        } else {
            return Result.error("Supplier not found");
        }
    }

    @GetMapping("/list")
    public Result listSuppliers() {
        List<Supplier> supplierList = supplierService.list();
        return Result.success(supplierList);
    }

    @PutMapping("/update")
    public Result updateSupplier(@RequestBody Supplier supplier) {
        boolean isUpdated = supplierService.updateById(supplier);
        if (isUpdated) {
            return Result.success(supplier);
        } else {
            return Result.error("Failed to update supplier");
        }
    }

    @DeleteMapping("/delete")
    public Result deleteSupplier(@RequestParam Integer id) {
        boolean isRemoved = supplierService.removeById(id);
        if (isRemoved) {
            return Result.success("Supplier deleted successfully");
        } else {
            return Result.error("Failed to delete supplier");
        }
    }
}
