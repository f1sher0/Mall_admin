package com.trade.demo.controller1;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trade.demo.common.Result;
import com.trade.demo.entity1.Manages;
import com.trade.demo.service.EmpsService;
import com.trade.demo.service.ManagesService;
import com.trade.demo.entity1.Emps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@CrossOrigin
@Slf4j
@RestController
 @RequestMapping("/emps")
public class EmpsController {

    @Autowired
    private EmpsService empsService ;
@Autowired
private ManagesService managesService;



@RequestMapping("/list")
public Result list() {
    return Result.success( empsService.list());
}

    // 分页查询药品信息
    @RequestMapping("/page")
    public Result page(long current, long size) {
        Page<Emps> page = new Page<>(current, size);
        return Result.success( empsService.page(page));
    }



    // 添加药品信息
    @RequestMapping("/save")
    public Result save(@RequestBody Emps emps) {

        System.out.println(emps.toString());
        if (emps.getId() != null) {
            Emps existingEmps = empsService.getById(emps.getId());
            if (existingEmps != null) {
                return Result.success(empsService.updateById(emps));
            }
        }

        return Result.success(empsService.save(emps));
    }
    @RequestMapping("/user/register")
    public Result register(@RequestBody Emps emps) {
        Emps existingEmp = empsService.getById(emps.getId());
        Result result=new Result();
        if (existingEmp != null) {
            result.setMsg("员工ID已存在，不能重复注册");
            return result;
        }
        boolean success = empsService.save(emps);
        if (success) {
            result.setMsg("注册成功");
            return result;
        } else {
            result.setMsg("注册失败，请稍后重试");
            return result;
        }
    }

    @RequestMapping("/updateById")
    public Result updateById(Emps emps) {

        System.out.println(emps.toString());
    return Result.success(empsService.updateById(emps));
    }
    // 根据ID查询药品信息
    @RequestMapping("/getById")
    public Result getById(long id) {
        return Result.success(empsService.getById(id));
    }


    @RequestMapping("/removeById")
    public Result removeById(long id) {



        LambdaQueryWrapper<Emps> empsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        empsLambdaQueryWrapper.eq(Emps::getId, id);
        List<Emps> emps = empsService.list(empsLambdaQueryWrapper);

        for (Emps emp : emps) {
            LambdaQueryWrapper<Manages> managesLambdaQueryWrapper = new LambdaQueryWrapper<>();

            managesLambdaQueryWrapper.eq(Manages::getId, emp.getManageId());
            managesService.remove(managesLambdaQueryWrapper);

        }


        return Result.success( empsService.remove(empsLambdaQueryWrapper));

    }

    @RequestMapping("/user/login")
    public Result login(@RequestBody Emps emps ) {
        System.out.println(emps.toString());
        String username = emps.getName();
        String password = emps.getPassword();
        Result result = new Result();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {

            result.setCode("500");
            result.setMsg("用户名和密码不能为空");
            return result;
        }

        // 查询数据库是否存在匹配的记录
        Emps dbUser = empsService.MyGetByUsernameAndPassword(username, password);
        if (dbUser == null) {

            result.setCode("500");
            result.setMsg("用户名或密码错误");
            return result;
        }

        // 登录成功
        System.out.println("登录成功");
//        String JWTtoken = JWT.create()
//                .withSubject(dbUser.getId().toString()+dbUser.getName()) // 使用用户id+用户名作为subject
//                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 设置过期时间
//                .sign(Algorithm.HMAC256("secret")); // 使用秘钥签名

        // 将token发送给客户端
        HashMap<String, Object> data = new HashMap<>();
        data.put("user", dbUser);
//        data.put("JWTtoken", JWTtoken);
//        result.setMsg("登录成功");
        return Result.success(data);
    }

    @RequestMapping("/loadPost")

    public Result loadPost(String backname, long current, long size) {
        // 构建分页对象
        Page<Emps> page = new Page<>(current, size);
        if (backname == null || backname.trim().isEmpty()) {
            System.out.println("名字都不说啦? 默认查询全部啦~");
            return page(current,size);
        }
        // 模糊查询信息
        LambdaQueryWrapper<Emps> empsLambdaQueryWrapper = new LambdaQueryWrapper<>();

        empsLambdaQueryWrapper.like(StringUtils.isNotBlank(backname), Emps::getName, backname);

        IPage<Emps> medicinesPage = empsService.page(page, empsLambdaQueryWrapper);

        return Result.success(medicinesPage);
    }
}