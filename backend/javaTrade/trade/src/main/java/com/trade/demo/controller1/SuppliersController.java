package com.trade.demo.controller1;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.trade.demo.common.Result;
import com.trade.demo.service.OutInsService;
import com.trade.demo.service.SuppliersService;
import com.trade.demo.entity1.OutIns;
import com.trade.demo.entity1.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/suppliers")
public class SuppliersController {
    @Autowired
    private SuppliersService suppliersService;
@Autowired
private OutInsService outInsService;
    // 查询所有供应商信息
    @RequestMapping("/list")
    public Result list() {
        return Result.success(suppliersService.list());
    }

    // 分页查询供应商信息
    @RequestMapping("/page")
    public Result page(long current, long size) {
        Page<Suppliers> page = new Page<>(current, size);
        return Result.success(suppliersService.page(page));
    }
    @RequestMapping("/loadPost")
    public Result loadPost(String backname, long current, long size) {
        // 构建分页对象
        Page<Suppliers> page = new Page<>(current, size);
        if (backname == null || backname.trim().isEmpty()) {
            System.out.println("名字都不说啦? 默认查询全部啦~");
            return page(current,size);
        }
        // 模糊查询信息
        LambdaQueryWrapper<Suppliers> suppliersLambdaQueryWrapper = new LambdaQueryWrapper<>();

        suppliersLambdaQueryWrapper.like(StringUtils.isNotBlank(backname), Suppliers::getName, backname);

        IPage<Suppliers> suppliersIPage = suppliersService.page(page, suppliersLambdaQueryWrapper);

        return Result.success(suppliersIPage);
    }
    // 根据ID查询供应商信息
    @RequestMapping("/getById")
    public Result getById(long id) {
        return Result.success(suppliersService.getById(id));
    }

    // 添加供应商信息
    @RequestMapping("/save")
    public Result save(@RequestBody Suppliers suppliers) {
       Integer id= suppliers.getId();

       //由于前端 在处理编辑与新增都是调用save函数, 导致编辑时实际是"新增"一条数据,
        //要判断这个新增的数据是否有主键冲突, 没有调用supplierService.save(suppliers)即可插入,
        //return前, 可以调用下方调用removeById(id)删除原数据
       //如果id在这个表,比如Suppliers里是单主键,就是这个表就id为主键,要检查
        return Result.success(suppliersService.save(suppliers));
    }

    // 更新供应商信息
    @RequestMapping("/updateById")
    public Result updateById(Suppliers suppliers) {
        return
                Result.success(suppliersService.updateById(suppliers));
    }

    // 删除供应商信息
    @RequestMapping("/removeById")
    public Result removeById(long id) {


        LambdaQueryWrapper<Suppliers> suppliersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        suppliersLambdaQueryWrapper.eq(Suppliers::getId, id);
        List<Suppliers> suppliers = suppliersService.list(suppliersLambdaQueryWrapper);

        // 删除 medicines , stores表中 相关的记录
        for (Suppliers supplier : suppliers) {
            LambdaQueryWrapper<OutIns> outInsLambdaQueryWrapper = new LambdaQueryWrapper<>();

            outInsLambdaQueryWrapper.eq(OutIns::getNo, supplier.getOutInNo());
              outInsService.remove(outInsLambdaQueryWrapper);

        }


        return Result.success(suppliersService.remove(suppliersLambdaQueryWrapper));
    }
}
