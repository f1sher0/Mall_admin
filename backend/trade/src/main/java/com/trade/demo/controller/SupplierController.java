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
import java.util.Date;
import java.util.HashMap;
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
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    @ApiOperation(value = "添加供应商")
    public Result addSupplier(@RequestBody Supplier supplier) {
        supplier.setStatus("0");
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
    @GetMapping("/getAccount")
    @ApiOperation(value = "根据ID获取供应商Account")
    public Result getAccountById(@RequestParam Integer id) {
        Supplier supplier = supplierService.getById(id);
        if (supplier != null) {
            String name=supplier.getSupplierName();
            String address = supplier.getAddress();
            String password = supplier.getPassword();
            HashMap<String, String> accountInfo = new HashMap<>();
            accountInfo.put("name", name);
            accountInfo.put("address", address);
            accountInfo.put("password", password);
            return Result.success(accountInfo );
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
        System.out.println(supplier.getAddress());
        System.out.println(supplier.getSupplierId()+"id");
        System.out.println(supplier.getStatus());
        System.out.println(supplier.getSupplierDesc());

        Supplier supplierOri=supplierService.getById(supplier.getSupplierId());
        if (supplierOri == null) {
            return Result.error("supplier  not found");
        }
        supplierOri.setSupplierName(supplier.getSupplierName());
        supplierOri.setSupplierDesc(supplier.getSupplierDesc());
        supplierOri.setPassword(supplier.getPassword());
        if (supplier.getAddress() != null) {
            supplierOri.setAddress(supplier.getAddress());
        }
        if (supplier.getStatus() != null) {
            supplierOri.setStatus(supplier.getStatus());
        }
        boolean isUpdated = supplierService.updateById(supplierOri);
        if (isUpdated) {
            String email = supplierOri.getEmail();
            User user = userService.findByEmail(email);
            if (user != null) {
                user.setUpdateTime( new Date());
                user.setPassword(supplier.getPassword());
                user.setUsername(supplier.getSupplierName());
                user.setStatus(supplier.getStatus().charAt(0));

                userService.updateById(user);
            } else {
                return Result.error("Associated user not found");
            }
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


    @GetMapping("/goodsInInfo")
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
                dto.setEmail(supplier.getEmail());
                dto.setGoodsInId(goodsInId);
                dto.setGoodsId(inListGood.getGoodsId());

                dto.setIsReturned(inListGood.getIsReturned());
                dto.setWarehouseId(goods.getWarehouseId());
                dto.setGoodsName(goods.getGoodsName());
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
