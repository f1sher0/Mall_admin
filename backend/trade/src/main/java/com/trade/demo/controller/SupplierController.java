package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.dto.GoodsInInfoDTO;
import com.trade.demo.entity.*;
import com.trade.demo.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@Api(tags = "供应商管理")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private GoodsInService goodsInService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private InListGoodsService inListGoodsService;
    @Autowired
    private WarehouseService warehouseService;
    @PostMapping("/add")
    @ApiOperation(value = "添加供应商")
    public Result addSupplier(@RequestBody Supplier supplier) {
        supplier.setStatus('0');
        boolean isSaved = supplierService.save(supplier);
        if (isSaved) {
            return Result.success(supplier);
        } else {
            return Result.error("Failed to add supplier");
        }
    }

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取供应商")
    public Result getSupplierById(@RequestParam Integer id) {
        Supplier supplier = supplierService.getById(id);
        if (supplier != null) {
            return Result.success(supplier);
        } else {
            return Result.error("Supplier not found");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有供应商")
    public Result listSuppliers() {
        List<Supplier> supplierList = supplierService.list();
        return Result.success(supplierList);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新供应商信息")
    public Result updateSupplier(@RequestBody Supplier supplier) {
        boolean isUpdated = supplierService.updateById(supplier);
        if (isUpdated) {
            return Result.success(supplier);
        } else {
            return Result.error("Failed to update supplier");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据ID删除供应商")
    public Result deleteSupplier(@RequestParam Integer id) {
        boolean isRemoved = supplierService.removeById(id);
        if (isRemoved) {
            return Result.success("Supplier deleted successfully");
        } else {
            return Result.error("Failed to delete supplier");
        }
    }


    @GetMapping("/goodsInInfo/")
    @ApiOperation(value = "按供应商ID获取GoodsInInf信息,不止GoodsIn表的信息")
    public Result getGoodsInInfoByPurchaser(@RequestParam Integer supplierId) {
        // 获取 goodsin 表中的订单信息
        List<GoodsIn> goodsInList = goodsInService.getBysupplierId(supplierId);
        List<GoodsInInfoDTO> resultList = new ArrayList<>();

        for (GoodsIn goodsIn : goodsInList) {
            int goodsInId = goodsIn.getGoodsInId();
            List<InListGoods> inListGoods = inListGoodsService.getByGoodsInId(goodsInId);
            for (InListGoods inListGood : inListGoods) {
                Goods goods = goodsService.getById(inListGood.getGoodsId());
                GoodsInInfoDTO dto = new GoodsInInfoDTO();
                dto.setGoodsInTime(goodsIn.getGoodsInTime());
                dto.setSupplierName(goodsIn.getSupplierName());
                Supplier supplier = supplierService.getById(supplierId);
                dto.setSupplierDesc( supplier.getSupplierDesc());
                dto.setSupplierAddress(supplier.getAddress());
                dto.setGoodsInId(goodsInId);
                dto.setGoodsId(inListGood.getGoodsId());
                dto.setIsReturned(inListGood.getIsReturned());
                dto.setWarehouseId(goods.getWarehouseId());
                dto.setWarehouseName(goodsIn.getWarehouseName());
                dto.setWarehouseAddress(warehouseService.getById(goods.getWarehouseId()).getWarehouseLocation());
                dto.setOnShelf(goods.getOnShelf());
                dto.setPurchasePrice(goods.getPurchasePrice());
                dto.setSellingPrice(goods.getSellingPrice());

                resultList.add(dto);
            }
        }

        return Result.success(resultList);
    }
}
