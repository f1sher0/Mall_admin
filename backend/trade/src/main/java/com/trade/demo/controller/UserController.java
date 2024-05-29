package com.trade.demo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.trade.demo.common.Result;
import com.trade.demo.entity.*;
import com.trade.demo.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private InListGoodsService inListGoodsService;

    @Autowired
    private GoodsInService goodsInService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private WarehouseService warehouseService;
    @PostMapping("/login")
    public Result login(@RequestBody User loginUser) {
        User user = userService.findByEmail(loginUser.getEmail());
        if (user == null || !user.getPassword().equals(loginUser.getPassword())) {
            return Result.error("Invalid email or password");
        }

        String JWTtoken = JWT.create()
                .withSubject(user.getEmail().toString()+user.getPassword())
                .withExpiresAt(new java.sql.Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 设置过期时间
                .sign(Algorithm.HMAC256("secret")); // 使用秘钥签名

        System.out.println(JWTtoken);

        return Result.success(JWTtoken);

    }




    @PostMapping("/register")
    public Result registerUser(@RequestBody User user) {
        if (user.getEmail() == null || user.getPassword() == null || user.getRole() == null) {
            return Result.error("Email, Password, and Role are required.");
        }
        // Check if the email is already in use
        if (userService.isEmailTaken(user.getEmail())) {
            return Result.error("Email is already in use.");
        }
        // Setting default values for other fields
        user.setEmail(user.getEmail());
//        user.setStatus('0');  // Assuming 'A' stands for Active
        user.setCreateTime(new Date( ));
        user.setUpdateTime(new Date());

        boolean isSaved = userService.save(user);
        if (isSaved) {
            return Result.success(user);
        } else {
            return Result.error("Failed to register user.");
        }
    }
    @GetMapping("/get")
    public Result getUserById(@RequestParam Integer id) {
        User user = userService.getById(id);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error("User not found");
        }
    }

    @PostMapping("/add")
    public Result addUser(@RequestBody User user) {
        boolean isSaved = userService.save(user);
        if (isSaved) {
            return Result.success(user);
        } else {
            return Result.error("Failed to add user");
        }
    }

    @GetMapping("/list")
    public Result listUsers() {
        List<User> userList = userService.list();
        return Result.success(userList);
    }

    @PutMapping("/update")
    public Result updateUser(@RequestBody User user) {
        boolean isUpdated = userService.updateById(user);
        if (isUpdated) {
            return Result.success(user);
        } else {
            return Result.error("Failed to update user");
        }
    }

    @DeleteMapping("/delete")
    public Result deleteUser(@RequestParam Integer id) {
        boolean isRemoved = userService.removeById(id);
        if (isRemoved) {
            return Result.success("User deleted successfully");
        } else {
            return Result.error("Failed to delete user");
        }
    }

    @GetMapping("/unreviewed/users")
    @ApiOperation(value = "获取所有未审核的用户")
    public Result getUnreviewedUsers() {
        List<User> unreviewedUsers = userService.getUnreviewedUsers();
        if (unreviewedUsers != null && !unreviewedUsers.isEmpty()) {
            return Result.success(unreviewedUsers);
        } else {
            return Result.error("No unreviewed users found");
        }
    }


    @GetMapping("/unreviewed/warehouses")
    @ApiOperation(value = "获取所有未审核的仓库")
    public Result getUnreviewedWarehouses() {
        List<Warehouse> unreviewedWarehouses = warehouseService.getUnreviewedWarehouses();
        if (unreviewedWarehouses != null && !unreviewedWarehouses.isEmpty()) {
            return Result.success(unreviewedWarehouses);
        } else {
            return Result.error("No unreviewed warehouses found");
        }
    }

    @GetMapping("/unreviewed")
    @ApiOperation(value = "获取所有未审核的用户和仓库")
    public Result  getUnreviewedEntities() {
        List<Object> unreviewedEntities = new ArrayList<>();
        unreviewedEntities.addAll(userService.getUnreviewedUsers());
        unreviewedEntities.addAll(warehouseService.getUnreviewedWarehouses());
        return Result.success(unreviewedEntities);
    }

    @PutMapping("/approve/user")
    @ApiOperation(value = "审核通过用户")
    public Result  approveUser(@RequestParam Integer userId) {
        User user = userService.getById(userId);
        if (user != null) {
            user.setStatus('1');
            user.setUpdateTime(new Date());
            return Result.success(userService.updateById(user));
        }
        return Result.error("User not found");
    }

    @PutMapping("/approve/warehouse")
    @ApiOperation(value = "审核通过仓库")
    public Result  approveWarehouse(@RequestParam Integer warehouseId) {
        Warehouse warehouse = warehouseService.getById(warehouseId);
        if (warehouse != null) {
            warehouse.setStatus('1');

            return Result.success(warehouseService.updateById(warehouse));
        }
        return Result.error("Warehouse not found");
    }
//<<<<<<<<<<<<<<<<<<<<<<<<<采购商
    //能够进行购买的商品信息获取 执行步骤如下，大伙可以检查下逻辑
    // 1:从inlistgoods表中查询所有isReturned值未No的数据.
    //2:将1中获取的数据中的goodsinid与goodsin表中的goodsinid进行链接匹配
    //3: 根据goodsin表中属性 `goodsInNo` 为varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入库单的编号,
    // 可以含有多个商品的id,以逗号分隔'。以逗号为单位进行解析substr后面三位字符，这三位字符对应的int值即goods表的主键id，
    //4: 将3中解析获取的主键id与goods表进行匹配查询，选取数据中onShelf为1的数据。将将相应goods信息返回
    @GetMapping("/purchasable")
    @ApiOperation(value = "获取可购买的商品信息")
    public Result getPurchasableGoods() {
        // 1: 从inlistgoods表中查询所有isReturned值为No的数据.
//        List<InListGoods> inListGoods = inListGoodsService.lambdaQuery().eq(InListGoods::getIsReturned, "No").list();
//        与下一行等价，但下一行安全
        List<InListGoods> inListGoods = inListGoodsService.lambdaQuery().eq(InListGoods::getIsReturned, IsReturned.NO).list();

        List<Goods> purchasableGoods = new ArrayList<>();
// 实现一，没利用入库记录的特点
//        for (InListGoods item : inListGoods) {
//            // 2: 根据goodsinid与goodsin表进行链接匹配.
//            GoodsIn goodsIn = goodsInService.getById(item.getGoodsInId());
//
//            if (goodsIn != null) {
//                // 3: 解析goodsInNo获取goods表的主键id.
//                String[] goodsInNos = goodsIn.getGoodsInNo().split(",");
//                for (String goodsInNo : goodsInNos) {
//                    String goodsIdStr = goodsInNo.substring(goodsInNo.length() - 3);  // 获取后三位字符
//                    Integer goodsId = Integer.parseInt(goodsIdStr);  // 转换为整型
//
//                    // 4: 根据goodsId查询goods表中onShelf为1的数据.
//                    Goods goods = goodsService.lambdaQuery().eq(Goods::getGoodsId, goodsId).eq(Goods::getOnShelf, 1).one();
//
//                    if (goods != null) {
//                        purchasableGoods.add(goods);
//                    }
//                }
//            }
//
//        }
        //实现二，可以避免重查
        for (InListGoods item : inListGoods) {
            Goods goods = goodsService.lambdaQuery().eq(Goods::getGoodsId, item.getGoodsId()).eq(Goods::getOnShelf, 1).one();

            if (goods != null) {
                purchasableGoods.add(goods);
            }
        }

        return Result.success(purchasableGoods);
    }

//>>>>>>>>>>>>>>>>>>>>>采购商
}
