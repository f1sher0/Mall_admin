package com.trade.demo.controller1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trade.demo.common.Result;
import com.trade.demo.entity1.Admins;

import com.trade.demo.service.AdminsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/admins")
public class AdminsController {

    @Autowired
    private AdminsService adminService;

    @RequestMapping("/list")
    public Result list() {
        return Result.success(adminService.list());
    }

    // 分页查询管理员信息
    @RequestMapping("/page")
    public Result page(long current, long size) {
        Page<Admins> page = new Page<>(current, size);
        return Result.success(adminService.page(page));
    }

    // 添加管理员信息
    @RequestMapping("/save")
    public Result save(@RequestBody Admins admin) {
        if (admin.getAdminuserId() != null) {
            Admins existingAdmin = adminService.getById(admin.getAdminuserId());
            if (existingAdmin != null) {
                return Result.success(adminService.updateById(admin));
            }
        }
        return Result.success(adminService.save(admin));
    }

    // 根据ID查询管理员信息
    @RequestMapping("/getById")
    public Result getById(String adminUserId) {
        return Result.success(adminService.getById(adminUserId));
    }

    // 根据ID删除管理员信息
    @RequestMapping("/removeById")
    public Result removeById(String adminUserId) {
        return Result.success(adminService.removeById(adminUserId));
    }

    // 其他操作方法...
}
