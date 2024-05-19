package com.trade.demo.controller1;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trade.demo.common.Result;
import com.trade.demo.entity1.Emps;
import com.trade.demo.entity1.Manages;
import com.trade.demo.entity1.Stores;
import com.trade.demo.service.EmpsService;
import com.trade.demo.service.ManagesService;
import com.trade.demo.service.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
// ManagesController
@RestController
@RequestMapping("/manages")
public class ManagesController {
   @Autowired
   private ManagesService managesService;
@Autowired
private EmpsService empsService;
@Autowired
private StoresService storesService;
   // 查询所有管理信息
   @RequestMapping("/list")
   public Result list() {

       return Result.success(managesService.list());
   }

   // 分页查询管理信息
   @RequestMapping("/page")
   public Result page(long current, long size) {
       Page<Manages> page = new Page<>(current, size);
       return Result.success(managesService.page(page));
   }

   // 根据ID查询管理信息
   @RequestMapping("/getById")
   public Result getById(long id) {
       return Result.success(managesService.getById(id));
   }

   // 添加管理信息
   @RequestMapping("/save")
   public Result save(@RequestBody Manages manages) {
       return Result.success(managesService.save(manages));
   }

   // 更新管理信息
   @RequestMapping("/updateById")
   public Result updateById(Manages manages) {
       return Result.success(managesService.updateById(manages));
   }

  // 删除管理信息
//  @RequestMapping("/removeById")
//  public boolean removeById(long id) {
//      return managesService.removeById(id);
//  }

    @RequestMapping("/removeById")
    public Result removeById(long id) {


        LambdaQueryWrapper<Manages> managesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        managesLambdaQueryWrapper.eq(Manages::getId, id);


        List<Manages> manages = managesService.list(managesLambdaQueryWrapper);


        for (Manages manage : manages) {
            LambdaQueryWrapper<Emps> empsLambdaQueryWrapper = new LambdaQueryWrapper<>();
            LambdaQueryWrapper<Stores>storesLambdaQueryWrapper = new LambdaQueryWrapper<>();


            empsLambdaQueryWrapper.eq(Emps::getId,manage.getEmpId());
            storesLambdaQueryWrapper.eq(Stores::getId,manage.getStoreId());

            empsService.remove(empsLambdaQueryWrapper);
            storesService.remove(storesLambdaQueryWrapper);


        }

        return Result.success(managesService.remove(managesLambdaQueryWrapper));


    }

}