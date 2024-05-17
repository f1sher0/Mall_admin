package com.trade.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.trade.demo.common.Result;
import com.trade.demo.entity.*;
import com.trade.demo.mapper.MedicinesMapper;
import com.trade.demo.service.MedicinesService;
import com.trade.demo.service.StoragesService;
import com.trade.demo.entity.Medicines;
import com.trade.demo.entity.Storages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/medicines")
public class MedicinesController {
    @Autowired
    private
    MedicinesService medicinesService;
@Autowired
 private StoragesService storagesService;
@Autowired
private MedicinesMapper medicinesMapper;
    // 查询所有药品信息
    @RequestMapping("/list")
    public Result list() {
        return  Result.success(medicinesService.list()) ;
    }
    @RequestMapping("/pagetest")
    public IPage<Medicines> getPageMedicines(int pageNum, int pageSize) {

        Page<Medicines> page = new Page<>(pageNum, pageSize);


        IPage<Medicines> medicinesPage = medicinesMapper.selectPage(page, null);

        return medicinesPage;
    }
    // 分页查询药品信息
    @RequestMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") long current,
                       @RequestParam(defaultValue = "6") long size) {
        Page<Medicines> page = new Page<>(current, size);
        System.out.println();
        return Result.success(medicinesService.page(page));

//        Page<Medicines> page = new Page<>(current, size);
//
//        IPage<Medicines> medicinesPage = medicinesService.page(page);
//
//        // 从分页对象获取查询结果
//        List<Medicines> records = medicinesPage.getRecords();
//        long total = medicinesPage.getTotal();
//
//        // 将查询结果封装成返回对象
//        Map<String, Object> data = new HashMap<>();
//        data.put("records", records);
//        data.put("total", total);
//        System.out.println(total);
//        System.out.println(current);
//        System.out.println(size);
//        return Result.success(data);

//        QueryWrapper<Medicines> queryWrapper = new QueryWrapper<Medicines>().orderByAsc("id");
//        //queryWrapper.like(!"".equals(name), "name", name);
//        Page<Medicines> page = medicinesMapper.selectPage(new Page<>(current, size), queryWrapper);
//        return Result.success(page);
    }

    // 根据ID查询药品信息
    @RequestMapping("/getById")
    public Result getById(long id) {
        return Result.success( medicinesService.getById(id));
    }

    // 添加药品信息
    @RequestMapping("/save")
    public Result save( @RequestBody Medicines medicines) {
        System.out.println(medicines.toString());
        if (medicines.getId() != null) {
            Medicines existingEmps = medicinesService.getById(medicines.getId());
            if (existingEmps != null) {
                return Result.success(medicinesService.updateById(medicines));
            }
        }

        return Result.success(medicinesService.save(medicines));

    }

    // 更新药品信息
    @RequestMapping("/updateById")
    public Result updateById(Medicines medicines) {
        return Result.success(medicinesService.updateById(medicines));
    }

    // 删除药品信息
//    @RequestMapping("/removeById")
//    public boolean removeById(long id) {
//        return medicinesService.removeById(id);
//    }

    @RequestMapping("/removeById")
    public Result removeById(long id) {
        LambdaQueryWrapper<Medicines> medicinesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        medicinesLambdaQueryWrapper.eq(Medicines::getId, id);
        List<Medicines> medicines = medicinesService.list(medicinesLambdaQueryWrapper);
        for (Medicines medicine : medicines) {
            LambdaQueryWrapper<Storages> storagesLambdaQueryWrapper = new LambdaQueryWrapper<>();
            storagesLambdaQueryWrapper.eq(Storages::getId, medicine.getStorageId());
            storagesService.remove(storagesLambdaQueryWrapper);
        }
        return  Result.success(medicinesService.remove(medicinesLambdaQueryWrapper));
    }
//    @RequestMapping("/pageByMedicineName")
@RequestMapping("/loadPost")

    public Result pageByMedicineName(String medicineName, long current, long size) {
        // 构建分页对象
        Page<Medicines> page = new Page<>(current, size);
        if (medicineName == null || medicineName.trim().isEmpty()) {
            System.out.println("名字都不说啦? 默认查询全部啦~");
           return page(current,size);
        }
        // 查询药品信息
        LambdaQueryWrapper<Medicines> medicineQueryWrapper = new LambdaQueryWrapper<>();
        medicineQueryWrapper.like(StringUtils.isNotBlank(medicineName), Medicines::getName, medicineName);
        IPage<Medicines> medicinesPage = medicinesService.page(page, medicineQueryWrapper);
        return Result.success(medicinesPage);


    }
}
