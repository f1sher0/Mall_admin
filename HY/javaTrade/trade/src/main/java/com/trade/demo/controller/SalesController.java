package com.trade.demo.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trade.demo.common.MedSalesPage;
import com.trade.demo.common.Result;
import com.trade.demo.entity.*;
import com.trade.demo.service.*;
import com.trade.demo.entity.*;
import com.trade.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.Math.min;

@CrossOrigin
// SalesController
@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;
    @Autowired
    private CustomersService customersService;
    @Autowired
    private StoresService storesService;
    @Autowired
    private MedicinesService medicinesService;
@Autowired
private OutInsService outInsService;
    // 查询所有销售信息
    @RequestMapping("/list")
    public Result list() {
        return Result.success(salesService.list());
    }

    // 分页查询销售信息
    @RequestMapping("/page")
    public Result page(long current, long size) {
        Page<Sales> page = new Page<>(current, size);
        return Result.success(salesService.page(page));
    }
    @GetMapping("/GetSalesExport")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据




        Result temp = loadPost("",1,999);
        MedSalesPage medSalesPage = (MedSalesPage) temp.getData();

        System.out.println(medSalesPage);
        List<MedSales> list=    medSalesPage.getRecords();
        System.out.println(list);
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，输出标题
        writer.write(list, true);

        // 浏览器响应的格式如下
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("入库信息表", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

    @RequestMapping("/loadPost")

    public Result loadPost(String id, long current, long size) {

        List<MedSales> medSalesList = new ArrayList<>();
        List<Map<String, Object>> salesList = new ArrayList<>();
//        System.out.println("当输入框没输入时,前端所给id为: " +id);
        //自定义方法again again

       if(id.isEmpty()|| id.equals("")||id.trim().isEmpty()||StringUtils.isBlank(id)){
           salesList = salesService.forsalesload();
       }
      else{
           System.out.println("第二种去了");
           salesList = salesService.forsalesload2(Integer.valueOf(id));

       }
        long mytest=0;
        System.out.println(salesList.size());
        for(Map<String,Object> sale:salesList){
            System.out.println(sale.values());
            if((int)sale.get("state")== 1){//卖出了的
                mytest++;
                System.out.println(mytest);
                System.out.println(sale.values());
               // System.out.println("卖出了的");

                MedSales medSales = new MedSales();
                medSales.setId((int)sale.get("id"));
                medSales.setTypeNo((int)sale.get("typeNo"));
                medSales.setName((String)sale.get("name"));
                medSales.setCustName((String)sale.get("custName"));
                medSales.setPhone((String) sale.get("phone"));
                medSales.setSelling((int)sale.get("selling"));
                medSales.setTime((Date)sale.get("time"));

                medSalesList.add(medSales);
            }
        }
        int startIdx = (int) ((current - 1) * size);
        int endIdx = Math.min(startIdx + (int) size, medSalesList.size());

        List<MedSales> pagedMedSalesList = medSalesList.subList(startIdx, endIdx);
        MedSalesPage medSalesPage = new MedSalesPage();
        medSalesPage.setRecords(pagedMedSalesList);
        medSalesPage.setCurrent(current);
        medSalesPage.setSize(size);
        medSalesPage.setTotal(mytest);

        return Result.success(medSalesPage);

    }

    // 根据ID查询销售信息
    @RequestMapping("/getById")
    public Result getById(long id) {
        return Result.success(salesService.getById(id));
    }

    // 添加销售表信息
    @RequestMapping("/save2")
    public Result save(@RequestBody Sales sales) {
        return Result.success(salesService.save(sales));
    }
    //新增销售记录
    @RequestMapping("/save")
    public Result addSaleMT(@RequestBody MedSales medSales)    {
        Integer id = medSales.getId();
//        Integer typeNo= medSales.getTypeNo();
        String medName =  medSales.getName();
        String custName = medSales.getCustName();
        String phone =medSales.getPhone();
//        Integer selling=medSales.getSelling();
        Date date = medSales.getTime();
        System.out.println(date);

        Medicines existingMedicine = medicinesService.getById(id);
        System.out.println(existingMedicine);
//        System.out.println("qidkfjdkfjdl");
        if (existingMedicine == null) {
            Result resulter=new Result();resulter.setCode("500");
            resulter.setMsg( "药品不存在，无法进行销售");
            return resulter;
        }

        Customers customers=new Customers(id,custName,id,phone);
        System.out.println(customers.toString());
        Sales sales = new Sales(id.toString(),1,date,id,1);

        customersService.save(customers);
        return Result.success(salesService.save(sales));
    }
    // 更新销售信息
    @RequestMapping("/updateById")
    public Result updateById(Sales sales) {
        return Result.success(salesService.updateById(sales));
    }

//    // 删除销售信息
//    @RequestMapping("/removeById")
//    public boolean removeById(long id) {
//        return salesService.removeById(id);
//    }
//@RequestMapping("/removeById")
//public boolean removeById(long id) {
//
//
//    LambdaQueryWrapper<Customers> QueryWrapper = new LambdaQueryWrapper<>();
//    QueryWrapper.eq(Customers::getSaleNo, id);
//    customersService.remove( QueryWrapper);
//
//
//    return salesService.removeById(id);
//}
@RequestMapping("/tuihuo")
public Result tuihuo(long id) {

    Medicines medicine = medicinesService.getById(id);//
    Customers customers = customersService.getById(id);

    //  zhe里还是不 删除 Medicine
    //删除顾客

//  外键,药同步删除  customersService.removeById(id);由于外键作用，会导致sales表的记录也没，这是不好的，故不删除操作

   // 更新关联的 Sales数据的 state 为 0
    LambdaUpdateWrapper<Sales> updateWrapper = new LambdaUpdateWrapper<>();
    updateWrapper.eq(Sales::getNo, id)
            .set(Sales::getState, 0);
    salesService.update(updateWrapper);
    return  Result.success();

}
    @RequestMapping("/removeById")
    public Result removeById(long id) {

        LambdaQueryWrapper<Sales> salesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        salesLambdaQueryWrapper.eq(Sales::getNo, id);
        List<Sales> sales = salesService.list(salesLambdaQueryWrapper);


        for (Sales sale : sales) {
            LambdaQueryWrapper<Customers> customersLambdaQueryWrapper = new LambdaQueryWrapper<>();
            LambdaQueryWrapper<Stores> storesLambdaQueryWrapper = new LambdaQueryWrapper<>();


            customersLambdaQueryWrapper.eq(Customers::getId, sale.getCustomerId());
            storesLambdaQueryWrapper.eq(Stores::getId, sale.getStoreId());

            customersService.remove(customersLambdaQueryWrapper);
            storesService.remove(storesLambdaQueryWrapper);


        }

        return Result.success(salesService.remove(salesLambdaQueryWrapper));
    }

    //按时间段查询
    @RequestMapping("/timeSearch")
    public Result timeSearch(String startTime, String endTime, long current, long size) {
       Date start = Date.valueOf(startTime);
        Date end =Date.valueOf(endTime);
        Page<Sales>page = new Page<>(current,size);
        LambdaQueryWrapper<Sales> salesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        salesLambdaQueryWrapper.between(Sales::getTime, start , end );
        IPage<Sales>salesIPage=salesService.page(page,salesLambdaQueryWrapper);
//        List<Sales> salesList = salesService.list(salesLambdaQueryWrapper);

        return Result.success(salesIPage);

    }


//    public Result timeSearch(String startTime, String endTime, long current, long size) {
//    public Result timeSearch(String startTime, String endTime, long current, long size) {
//       Date start = Date.valueOf(startTime);
//        Date end =Date.valueOf(endTime);
//
//        LambdaQueryWrapper<Sales> salesLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        salesLambdaQueryWrapper.between(Sales::getTime, start , end )
//                .last("LIMIT " + (current - 1) * size + "," + size);
//
//        List<Sales> salesList = salesService.list(salesLambdaQueryWrapper);
//
//        return Result.success(salesList);//能跑,但返回数据没记录一共有多少页了,
    //不符合前端要求
//
//
//    }



//    @GetMapping("/timeSearch") Timestamp类型, 不符合前端,选择更改后端数据库
//    public Result timeSearch(   String startTime,   String endTime,long current,long size) {
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Timestamp start = Timestamp.valueOf(startTime);
//        Timestamp end = Timestamp.valueOf(endTime);
//
//        LambdaQueryWrapper<Sales> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.between(Sales::getTime, start, end)
//                .last("LIMIT " + (current - 1) * size + "," + size);
//
//        List<Sales> salesList = salesService.list(queryWrapper);
//
//        return Result.success(salesList);
//    }



}




