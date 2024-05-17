package com.trade.demo.controller;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trade.demo.common.MedTimePage;
import com.trade.demo.common.Result;
import com.trade.demo.entity.*;
import com.trade.demo.entity.*;
import com.trade.demo.mapper.OutInsMapper;
import com.trade.demo.service.MedicinesService;
import com.trade.demo.service.OutInsService;
import com.trade.demo.service.StoresService;
import com.trade.demo.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/outIns")
public class OutInsController {
    @Autowired
    private OutInsService outInsService;
    @Autowired
    private MedicinesService medicinesService;
    @Autowired
    private SuppliersService suppliersService;
    @Autowired
    private StoresService storesService;

    @Resource
    private OutInsMapper outInsMapper;
    @Resource
    private BaseMapper<Medicines> baseMapper;
    @Resource
    private BaseMapper<Suppliers>suppliersBaseMapper;
    // 查询所有出入库信息
    @RequestMapping("/list")
    public Result list() {
        return Result.success(outInsService.list());
    }

    // 分页查询出入库信息
    @RequestMapping("/page")
    public Result page(long current, long size) {
        Page<OutIns> page = new Page<>(current, size);
        return Result.success(outInsService.page(page));
    }

    // 根据ID查询出入库信息
    @RequestMapping("/getById")
    public Result getById(long id) {
        return Result.success(outInsService.getById(id));
    }

    // 添加出入库信息
    @RequestMapping("/save")
    public Result save(@RequestBody MedTime medTime)
    {
        Integer id = medTime.getId();
        Integer typeNo= medTime.getTypeNo();
        String medName = medTime.getName();
        String supplier = medTime.getSupplierName();
        String phone = medTime.getPhone();
        Integer price=medTime.getPrice();
        Date date = medTime.getTime();
        System.out.println(date);
        OutIns outIns = new OutIns();
        outIns.setTime(date);
        outIns.setNo(id.toString());outIns.setState(1);outIns.setStoreId(1);outIns.setSupplierId(1);
        Medicines medicines = new Medicines(id,typeNo ,medName ,supplier,1,price,price+32);
        //这里就同步这两个似乎就符合需求了
        //还同步个供应商把
        Suppliers suppliers = new Suppliers(id,supplier,id,phone);
        suppliersService.save(suppliers);
        medicinesService.save(medicines);
        return Result.success(outInsService.save(outIns));
    }

    // 更新出入库信息
    @RequestMapping("/updateById")
    public Result updateById(OutIns outIns) {
        return Result.success(outInsService.updateById(outIns));
    }

    // 删除出入库信息
//    @RequestMapping("/removeById")
//    public boolean removeById(long id) {
//        return outInsService.removeById(id);
//    }
    @RequestMapping("/removeById")
    public Result removeById(long id) {

        LambdaQueryWrapper<OutIns> outInsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        outInsLambdaQueryWrapper.eq(OutIns::getNo, id);
        List<OutIns> outIns = outInsService.list(outInsLambdaQueryWrapper);


        for (OutIns outIn : outIns) {
            LambdaQueryWrapper<Suppliers> suppliersLambdaQueryWrapper = new LambdaQueryWrapper<>();
            LambdaQueryWrapper<Stores>storesLambdaQueryWrapper = new LambdaQueryWrapper<>();


            suppliersLambdaQueryWrapper.eq(Suppliers::getId,outIn.getSupplierId());
            storesLambdaQueryWrapper.eq(Stores::getId,outIn.getStoreId());

            suppliersService.remove(suppliersLambdaQueryWrapper);
            storesService.remove(storesLambdaQueryWrapper);


        }

        return Result.success(outInsService.remove(outInsLambdaQueryWrapper));

    }

    @RequestMapping("/tuihuo")
    public Result tuihuo(long id) {
        // 1. 获取 Medicine 和 Supplier 数据
        Medicines medicine = medicinesService.getById(id);
        Suppliers supplier = suppliersService.getById(id);

        // 2. 删除 Medicine 和 Supplier 数据
        medicinesService.removeById(id);
        suppliersService.removeById(id);

        // 3. 更新关联的 OutIns 数据的 state 为 0
        LambdaUpdateWrapper<OutIns> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(OutIns::getNo, id)
                .set(OutIns::getState, 0);
        outInsService.update(updateWrapper);
        return  Result.success();

    }
    //查询所有入库的物品
    @RequestMapping("/listIn")
    public Result listIn() {
        LambdaQueryWrapper<OutIns> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OutIns::getState,1);
        return Result.success(outInsService.list(lambdaQueryWrapper));
        //方法2
//        QueryWrapper<OutIns> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("state", 1);
//        return outInsService.list(queryWrapper);
    }
    @RequestMapping("/listOut")
    public Result listOut() {
        LambdaQueryWrapper<OutIns> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OutIns::getState,0);
        return Result.success(outInsService.list(lambdaQueryWrapper));
        //方法2
//        QueryWrapper<OutIns> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("state", 1);
//        return outInsService.list(queryWrapper);
    }
//    @RequestMapping("/listLike")
//    public List<OutIns> listLike() {
//        LambdaQueryWrapper<OutIns> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.like(OutIns::getNo,1);
//        return outInsService.list(lambdaQueryWrapper);
//    }

    @RequestMapping("/listByMedicineName")
//    public List<Map<String, Object>> listByMedicineName(String medicineName) {
    public Result listByMedicineName(String medicineName) {
        // 查询药品信息
        LambdaQueryWrapper<Medicines> medicineQueryWrapper = new LambdaQueryWrapper<>();
        medicineQueryWrapper.like(Medicines::getName, medicineName);
        List<Medicines> medicines = medicinesService.list(medicineQueryWrapper);

        // 查询出入库信息
        List<Map<String, Object>> result = new ArrayList<>();
        for (Medicines medicine : medicines) {
            LambdaQueryWrapper<OutIns> outInQueryWrapper = new LambdaQueryWrapper<>();
            outInQueryWrapper.eq(OutIns::getNo, medicine.getId());
            List<OutIns> outIns = outInsService.list(outInQueryWrapper);

            // 组装结果
            Map<String, Object> map = new HashMap<>();
            map.put("medicine", medicine);
            map.put("outIns", outIns);
            result.add(map);
        }

        return Result.success(result);
    }

    @RequestMapping("/pageByMedicineName")
   // public IPage<Map<String, Object>> pageByMedicineName(String medicineName, long current, long size) {
    public Result pageByMedicineName(String medicineName, long current, long size) {
    // 构建分页对象
        Page<Map<String, Object>> page = new Page<>(current, size);

        // 查询药品信息
        LambdaQueryWrapper<Medicines> medicineQueryWrapper = new LambdaQueryWrapper<>();
        medicineQueryWrapper.like(Medicines::getName, medicineName);
        List<Medicines> medicines = medicinesService.list(medicineQueryWrapper);

        // 查询出入库信息
        List<Map<String, Object>> records = new ArrayList<>();
        for (Medicines medicine : medicines) {
            LambdaQueryWrapper<OutIns> outInQueryWrapper = new LambdaQueryWrapper<>();
            outInQueryWrapper.eq(OutIns::getNo, medicine.getId());
            List<OutIns> outIns = outInsService.list(outInQueryWrapper);

            // 组装结果
            Map<String, Object> map = new HashMap<>();
            map.put("medicine", medicine);
            map.put("outIns", outIns);
            records.add(map);
        }


        page.setRecords(records);
        page.setTotal(records.size());

        return Result.success(page);
    }
    @GetMapping("/GetInExport1")
    public void testEx(){
        Result temp = loadPost("",1,999);
        MedTimePage medTimePage = (MedTimePage) temp.getData();

        System.out.println(medTimePage);
        List<MedTime> list=    medTimePage.getRecords();
        System.out.println(list);
    }
    @GetMapping("/GetInExport")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
//        LambdaQueryWrapper<OutIns> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(OutIns::getState,1);
//        List<OutIns> list =outInsService.list(lambdaQueryWrapper);



        //二
        Result temp = loadPost("",1,999);
        MedTimePage medTimePage = (MedTimePage) temp.getData();

        System.out.println(medTimePage);
        List<MedTime> list=    medTimePage.getRecords();
        System.out.println(list);
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("入库信息表", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }


    @PostMapping("/import")
    public Result imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
        List<OutIns> list = reader.readAll(OutIns.class);
        list.forEach(o -> outInsMapper.insert(o));
        return Result.success();
    }

    @RequestMapping("/loadPost")

    public Result loadPost(String backname, long current, long size) {

      //  Page<Medicines> page = new Page<>(current, size); 分页BUG 的原因

        LambdaQueryWrapper<Medicines> medicineQueryWrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(backname)) {
            medicineQueryWrapper.like(Medicines::getId, backname);

        }

       // IPage<Medicines> medicinesPage = medicinesService.page(page, medicineQueryWrapper);

        List<Medicines> medicinesList  = baseMapper.selectList(medicineQueryWrapper);
        List<MedTime> medTimeList = new ArrayList<>();
        for (Medicines medicine : medicinesList) {

            String supplierName = medicine.getSupplierName();

            LambdaQueryWrapper<Suppliers> suppliersLambdaQueryWrapper = new LambdaQueryWrapper<>();
            suppliersLambdaQueryWrapper.eq(Suppliers::getName, supplierName);
            if(suppliersLambdaQueryWrapper==null){
                System.out.println("supplier为空");     continue;
            }
            List<Suppliers> suppliersList  = suppliersBaseMapper.selectList(suppliersLambdaQueryWrapper);
//            Suppliers supplier = suppliersService.getOne(suppliersLambdaQueryWrapper);
if(suppliersList.isEmpty())continue;
Suppliers supplier= suppliersList.get(0);
            if (supplier != null) {
                LambdaQueryWrapper<OutIns> outInsQueryWrapper = new LambdaQueryWrapper<>();
                outInsQueryWrapper.eq(OutIns::getNo, medicine.getId()).eq(OutIns::getState, 1);

                OutIns outIns = outInsService.getOne(outInsQueryWrapper);

                if (outIns != null) {
                    MedTime medTime = new MedTime();
                    medTime.setTime(outIns.getTime());
                    medTime.setId(medicine.getId());
                    medTime.setTypeNo(medicine.getTypeNo());
                    medTime.setName(medicine.getName());
                    medTime.setSupplierName(medicine.getSupplierName());
                    medTime.setPhone(supplier.getPhone()); // 设置供应商的电话信息
                    medTime.setPrice(medicine.getPrice());
                    medTimeList.add(medTime);
                }
            }

//            LambdaQueryWrapper<OutIns> outInsQueryWrapper = new LambdaQueryWrapper<>();
//            outInsQueryWrapper.eq(OutIns::getNo, medicine.getId()).eq(OutIns::getState,1);
//            if(outInsQueryWrapper==null){
//                System.out.println("out为空");  continue;
//            }
//            //为了phone!
//       //     LambdaQueryWrapper<Suppliers> suppliersLambdaQueryWrapper= new LambdaQueryWrapper<>();
//
//            OutIns outIns = outInsService.getOne(outInsQueryWrapper);
//          //  suppliersLambdaQueryWrapper.eq(Suppliers::getId,outIns.getSupplierId());
////            if(suppliersLambdaQueryWrapper==null){
////                System.out.println("supplier为空");     continue;
////            }
//        //    Suppliers suppliers =suppliersService.getOne(suppliersLambdaQueryWrapper);
//            if (outIns != null ) {
//
//                MedTime medTime = new MedTime();
//                medTime.setTime(outIns.getTime());
//                medTime.setId(medicine.getId());
//                medTime.setTypeNo(medicine.getTypeNo());
//                medTime.setName(medicine.getName());
//                medTime.setSupplierName(medicine.getSupplierName());
//                LambdaQueryWrapper<Suppliers>suppliersLambdaQueryWrapper =new LambdaQueryWrapper<>();
//                suppliersLambdaQueryWrapper.eq(Suppliers::getName,medicine.getSupplierName());
//                Suppliers suppliers = suppliersLambdaQueryWrapper.getEntity();
//               //获取phone信息
////                medTime.setPhone("222");
//                medTime.setPhone(suppliers.getPhone());
//
//                medTime.setPrice(medicine.getPrice());
//                medTimeList.add(medTime);
//            }
        }

        //裂开的鬼畜的BUG,手动分页
        int startIdx = (int) ((current - 1) * size);
        int endIdx = Math.min(startIdx + (int) size, medTimeList.size());

        List<MedTime> pagedMedTimeList = medTimeList.subList(startIdx, endIdx);

        // 将处理后的结果放回分页对象
        System.out.println(medicinesList.size());
        MedTimePage medTimePage = new MedTimePage();
        medTimePage.setRecords(pagedMedTimeList);
        medTimePage.setTotal(medTimeList.size());
        medTimePage.setSize(size);
        medTimePage.setCurrent(current );

        return Result.success(medTimePage);



    }
}