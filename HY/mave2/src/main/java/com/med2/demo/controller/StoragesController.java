package com.med2.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.med2.demo.common.Result;
import com.med2.demo.entity.Medicines;
import com.med2.demo.entity.Storages;
import com.med2.demo.entity.Stores;
import com.med2.demo.service.ManagesService;
import com.med2.demo.service.MedicinesService;
import com.med2.demo.service.StoragesService;
import com.med2.demo.service.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/storages")
public class StoragesController {
    @Autowired
    private StoragesService storagesService;
@Autowired
private MedicinesService medicinesService;
@Autowired
private StoresService storesService;
    // 查询所有仓库信息
    @RequestMapping("/list")
    public Result list() {
        return Result.success(storagesService.list());
    }

    // 分页查询仓库信息
    @RequestMapping("/page")
    public Result page(long current, long size) {
        Page<Storages> page = new Page<>(current, size);
        return Result.success(storagesService.page(page));
    }

    // 根据ID查询仓库信息
    @RequestMapping("/getById")
    public Result getById(long id) {
        return Result.success(storagesService.getById(id));
    }

    // 添加仓库信息
    @RequestMapping("/save")
    public Result save(@RequestBody Storages storages) {
        return Result.success(storagesService.save(storages));
    }

    // 更新仓库信息
    @RequestMapping("/updateById")
    public Result updateById(Storages storages) {
        return
                Result.success(storagesService.updateById(storages));
    }

   // 删除仓库信息
//   @RequestMapping("/removeById")
//   public boolean removeById(long id) {
//       return storagesService.removeById(id);
//   }

    @RequestMapping("/removeById")
    public Result removeById(long id) {


//        LambdaQueryWrapper<Medicines> QueryWrapper = new LambdaQueryWrapper<>();
//        QueryWrapper.eq(Medicines::getId, id);//逻辑出错!!
//        medicinesService.remove( QueryWrapper);
        // 查询 storages 表中与给定 id 相等的记录
//        LambdaQueryWrapper<Storages>  QueryWrapper = new LambdaQueryWrapper<>();
//        QueryWrapper.eq(Storages::getId, id);
//        Storages storage = storagesService.getOne( QueryWrapper);//只有一条,BUG捏
//
//        // 删除 medicines 表中与该仓库相关的记录
//        if (storage != null) {
//            LambdaQueryWrapper<Medicines> medicinesQueryWrapper = new LambdaQueryWrapper<>();
//            medicinesQueryWrapper.eq(Medicines::getId, storage.getMedicineId());
//            return medicinesService.remove(medicinesQueryWrapper);
//        }

        // 查询 storages 表中与给定 id 相等的所有记录
        LambdaQueryWrapper<Storages> storagesQueryWrapper = new LambdaQueryWrapper<>();
        storagesQueryWrapper.eq(Storages::getId, id);
        List<Storages> storages = storagesService.list(storagesQueryWrapper);

        // 删除 medicines , stores表中 相关的记录
        for (Storages storage : storages) {
            LambdaQueryWrapper<Medicines> medicinesQueryWrapper = new LambdaQueryWrapper<>();
            LambdaQueryWrapper<Stores>storesLambdaQueryWrapper = new LambdaQueryWrapper<>();
            medicinesQueryWrapper.eq(Medicines::getId, storage.getMedicineId());
            storesLambdaQueryWrapper.eq(Stores::getId,storage.getStoreId());
            medicinesService.remove(medicinesQueryWrapper);
            storesService.remove(storesLambdaQueryWrapper);
        }

        // 删除 storages 表中与给定 id 相等的所有记录
        return Result.success(storagesService.remove(storagesQueryWrapper));
    }


}
