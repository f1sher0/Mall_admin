package com.med2.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.med2.demo.common.Result;
import com.med2.demo.entity.*;
import com.med2.demo.service.CustomersService;
import com.med2.demo.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.util.spi.CurrencyNameProvider;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    private CustomersService customersService;
    @Autowired
    private SalesService salesService;

    // 查询所有客户信息
    @RequestMapping("/list")
    public Result  list() {


        return Result.success(customersService.list());
    }

    // 分页查询客户信息
    @RequestMapping("/page")
    public Result page(long current, long size) {
        Page<Customers> page = new Page<>(current, size);
        return Result.success( customersService.page(page));
    }
    @RequestMapping("/loadPost")
    public Result loadPost(String backname, long current, long size) {
        // 构建分页对象
        Page<Customers> page = new Page<>(current, size);
        if (backname == null || backname.trim().isEmpty()) {
            System.out.println("名字都不说啦? 默认查询全部啦~");
            LambdaQueryWrapper<Customers> customersLambdaQueryWrapper = new LambdaQueryWrapper<>();
           customersLambdaQueryWrapper.groupBy(Customers::getId);
        //    customersLambdaQueryWrapper.groupBy(Customers::getId, Customers::getName);
             IPage<Customers> customersPage = customersService.page(page, customersLambdaQueryWrapper);
            //IPage<Customers> customersPage =  customersService.page(page, customersLambdaQueryWrapper.select(Customers::getId, Customers::getName));

            return Result.success(customersPage);

//            return page(current,size);
        }
        // 模糊查询信息
        LambdaQueryWrapper<Customers> customersLambdaQueryWrapper = new LambdaQueryWrapper<>();

        customersLambdaQueryWrapper.like(StringUtils.isNotBlank(backname), Customers::getName, backname);
        customersLambdaQueryWrapper.groupBy(Customers::getId);

      IPage<Customers> customersPage = customersService.page(page, customersLambdaQueryWrapper);

        return Result.success(customersPage);
    }

//    @RequestMapping("/loadPost")
//    public Result loadPost(String backname, long current, long size) {
//        Page<Customers> page = new Page<>(current, size);
//        LambdaQueryWrapper<Customers> queryWrapper = new LambdaQueryWrapper<>();
//
//        if (StringUtils.isBlank(backname)) {
//            System.out.println("名字都不说啦? 默认查询全部啦~");
//        } else {
//            // 模糊查询信息
//            queryWrapper.like(Customers::getName, backname);
//        }
//        queryWrapper.groupBy(Customers::getId);
//
//        // 执行查询之前检查页码
//        long total = customersService.count(queryWrapper); // 获取总记录数
//        long totalPages = (total + size - 1) / size; // 计算总页数
//
//        if (current > totalPages) {
//            // 如果请求的当前页码超出总页数，则将当前页码设置为最后一页
//            page.setCurrent(totalPages);
//        } else if (current <= 0) {
//            // 如果请求的当前页码小于或等于0，则将当前页码设置为第一页
//            page.setCurrent(1);
//        }
//
//        IPage<Customers> customersPage = customersService.page(page, queryWrapper);
//
//        return Result.success(customersPage);
//    }

    // 根据ID查询客户信息
    @RequestMapping("/getById")
    public Result getById(long id) {
        return Result.success( customersService.getById(id));
    }

    // 添加客户信息
    @RequestMapping( "/save")
    public Result save(@RequestBody Customers customers)
    {
        if(customers.getId()!=null){
            customers.setSaleNo(customers.getId());
            Customers existingCus = customersService.getById(customers.getId());
            if (existingCus != null) {

                return Result.success(customersService.updateById(customers));
            }
        }

        return Result.success(customersService.save(customers));
    }

    // 更新客户信息
    @RequestMapping("/updateById")
    public Result updateById(Customers customers) {
        return Result.success(customersService.updateById(customers));
    }

    // 删除客户信息
//    @RequestMapping("/removeById")
//    public boolean removeById(long id) {
//        return customersService.removeById(id);
//    }
//    @Override
    @RequestMapping("/removeById")
    public Result removeById(Integer id) {
          LambdaQueryWrapper<Customers> customersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        customersLambdaQueryWrapper.eq(Customers::getId, id);
        List<Customers> customers = customersService.list(customersLambdaQueryWrapper);

        for (Customers customer : customers) {
            LambdaQueryWrapper<Sales> salesLambdaQueryWrapper = new LambdaQueryWrapper<>();

            salesLambdaQueryWrapper.eq(Sales::getNo, customer.getSaleNo());
            salesService.remove(salesLambdaQueryWrapper);

        }
         return Result.success( customersService.remove(customersLambdaQueryWrapper));
    }
}
