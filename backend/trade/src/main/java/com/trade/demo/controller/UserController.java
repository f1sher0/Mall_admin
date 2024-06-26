package com.trade.demo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trade.demo.common.Result;
import com.trade.demo.entity.*;
import com.trade.demo.service.*;
<<<<<<< HEAD
=======
import io.swagger.annotations.Api;
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
=======
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a

@RestController
@RequestMapping("/api/user")
@Api(tags = "用户管理")
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
<<<<<<< HEAD
=======
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private PurchaserService purchaserService;
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result login(@RequestBody User loginUser) {
        User user = userService.findByEmail(loginUser.getEmail());
        if (user == null || !user.getPassword().equals(loginUser.getPassword())) {
            return Result.error("Invalid email or password");
        }
<<<<<<< HEAD

=======
        if(user.getStatus()=='0'){
            return  Result.unauthorized("该用户暂没有通过审核,无法使用");
        }
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
        String JWTtoken = JWT.create()
                .withSubject(user.getEmail().toString() + user.getPassword())
                .withExpiresAt(new java.sql.Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 设置过期时间
                .sign(Algorithm.HMAC256("secret")); // 使用秘钥签名
        String role = user.getRole();
        Integer id=-1;
        System.out.println(JWTtoken);
        if ("Supplier".equals(role)) {
            // 通过user.getEmail()与Supplier中的email关联, 获取实体Supplier
            Supplier supplier = supplierService.getOne(new QueryWrapper<Supplier>().eq("email", user.getEmail()));
            if (supplier != null) {
                id=supplier.getSupplierId();
            } else {
                System.out.println("No Supplier found with email: " + user.getEmail());
            }
        } else if ("Purchaser".equals(role)) {
            Purchaser purchaser = purchaserService.getOne(new QueryWrapper<Purchaser>().eq("email", user.getEmail()));
            if (purchaser != null) {
                 id=purchaser.getPurchaserId();
            } else {
                System.out.println("No Purchaser found with email: " + user.getEmail());
            }
        } else {
            System.out.println("Role not recognized: " + role);
        }
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("role", role);
        responseMap.put("token", JWTtoken);
        responseMap.put("email",user.getEmail());

<<<<<<< HEAD
        return Result.success(JWTtoken);
=======
        responseMap.put("username",user.getUsername());
        responseMap.put("id",id.toString());
        return Result.success(responseMap);
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a

    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Result registerUser(@RequestBody User user) {

        user.setStatus('0');
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        System.out.println(user.getEmail());

        System.out.println(user.getRole());
        if (user.getEmail() == null || user.getPassword() == null || user.getRole() == null) {
            return Result.error("Email, Password, and Role are required.");
        }
<<<<<<< HEAD
        // Check if the email is already in use
        if (userService.isEmailTaken(user.getEmail())) {
            return Result.error("Email is already in use.");
        }
        // Setting default values for other fields
        user.setEmail(user.getEmail());
//        user.setStatus('0');  // Assuming 'A' stands for Active
        user.setCreateTime(new Date( ));
        user.setUpdateTime(new Date());

=======
         if (userService.isEmailTaken(user.getEmail())) {
            return Result.error("Email is already in use.");
        }

//        user.setEmail(user.getEmail());
//        user.setStatus('0');
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());
//        user.setPassword(user.getPassword());
//        System.out.println(user.getRole());
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
        boolean isSaved = userService.save(user);
        if (isSaved) {

//            String email = user.getEmail();
//            String name = user.getUsername();
//            String password = user.getPassword();
//            String role = user.getRole();
//            if ("Supplier".equals(role)) {
//                Supplier supplier = new Supplier();
//                supplier.setEmail(email);
//                supplier.setSupplierName(name );
//                supplier.setPassword(password);
//                supplier.setStatus('0');
//                supplierService.save(supplier);
//            } else if ("Purchaser".equals(role)) {
//                Purchaser purchaser = new Purchaser();
//                purchaser.setEmail(email);
//                purchaser.setPurchaserName(name);
//                purchaser.setPassword(password);
//                purchaser.setStatus('0');
//                purchaserService.save(purchaser);
//            }else if("Warehouse Admin".equals(role)){
//                //todo
//            }
            return Result.success(user);
        } else {
            return Result.error("Failed to register user.");
        }
    }

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取用户信息")
    public Result getUserById(@RequestParam Integer id) {
        User user = userService.getById(id);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error("User not found");
        }
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加用户")
    public Result addUser(@RequestBody User user) {
        boolean isSaved = userService.save(user);
        if (isSaved) {
            return Result.success(user);
        } else {
            return Result.error("Failed to add user");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有用户信息")
    public Result listUsers() {
        List<User> userList = userService.list();
        return Result.success(userList);
    }
    @GetMapping("/list/Purchaser")
    @ApiOperation(value = "获取所有采购商用户信息")
    public Result listPurchasers() {
        List<User> userList = userService.list();
        List<User> purchasers = userList.stream()
                .filter(user -> "Purchaser".equals(user.getRole()))
                .collect(Collectors.toList());
        return Result.success(purchasers);
    }

    @GetMapping("/list/WarehouseAdmin")
    @ApiOperation(value = "获取所有仓库管理员用户信息")
    public Result listWarehouseAdmins() {
        List<User> userList = userService.list();
        List<User> warehouseAdmins = userList.stream()
                .filter(user -> "Warehouse Admin".equals(user.getRole()))
                .collect(Collectors.toList());
        return Result.success(warehouseAdmins);
    }

    @GetMapping("/list/Supplier")
    @ApiOperation(value = "获取所有供应商用户信息")
    public Result listSuppliers() {
        List<User> userList = userService.list();
        List<User> suppliers = userList.stream()
                .filter(user -> "Supplier".equals(user.getRole()))
                .collect(Collectors.toList());
        return Result.success(suppliers);
    }
    @PutMapping("/update")
    @ApiOperation(value = "更新用户信息")
    public Result updateUser(@RequestBody User user) {
        boolean isUpdated = userService.updateById(user);
        String username,password,email,role;

        if (isUpdated) {
            return Result.success(user);
        } else {
            return Result.error("Failed to update user");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除用户")
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
    public List<User> getUnreviewedUsers() {
        return userService.getUnreviewedUsers();
    }

    @GetMapping("/unreviewed/warehouses")
    @ApiOperation(value = "获取所有未审核的仓库")
    public List<Warehouse> getUnreviewedWarehouses() {
        return warehouseService.getUnreviewedWarehouses();
    }
<<<<<<< HEAD
    @GetMapping("/unreviewed")
    @ApiOperation(value = "获取所有未审核的用户和仓库")
    public Result  getUnreviewedEntities() {
=======

    @GetMapping("/unreviewed")
    @ApiOperation(value = "获取所有未审核的用户和仓库")
    public Result getUnreviewedEntities() {
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
        List<Object> unreviewedEntities = new ArrayList<>();
        unreviewedEntities.addAll(userService.getUnreviewedUsers());
        unreviewedEntities.addAll(warehouseService.getUnreviewedWarehouses());
        return Result.success(unreviewedEntities);
    }
<<<<<<< HEAD

    @PutMapping("/approve/user")
    @ApiOperation(value = "审核通过用户")
    public Result  approveUser(@RequestParam Integer userId) {
        User user = userService.getById(userId);
        if (user != null) {
            user.setStatus('1');
=======
    @GetMapping("/review/list")
    @ApiOperation(value = "获取所有用户和仓库的审核信息")
    public Result getReviewEntities() {
        List<Object> reviewEntities = new ArrayList<>();

        reviewEntities.addAll(userService.list());
        reviewEntities.addAll(warehouseService.list());
        return Result.success(reviewEntities);
    }

    @PutMapping("/approve/user")
    @ApiOperation(value = "审核通过用户")
    public Result approveUser(@RequestParam Integer userId) {
        User user = userService.getById(userId);
        if (user != null) {
            user.setStatus('1');
            user.setUpdateTime(new Date());
            //todo 根据用户的role进行相应表 的同步

>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
            return Result.success(userService.updateById(user));
        }
        return Result.error("User not found");
    }

    @PutMapping("/approve/warehouse")
    @ApiOperation(value = "审核通过仓库")
<<<<<<< HEAD
    public Result  approveWarehouse(@RequestParam Integer warehouseId) {
=======
    public Result approveWarehouse(@RequestParam Integer warehouseId) {
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
        Warehouse warehouse = warehouseService.getById(warehouseId);
        if (warehouse != null) {
            warehouse.setStatus('1');
            return Result.success(warehouseService.updateById(warehouse));
        }
        return Result.error("Warehouse not found");
    }
<<<<<<< HEAD
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

        for (InListGoods item : inListGoods) {
            // 2: 根据goodsinid与goodsin表进行链接匹配.
            GoodsIn goodsIn = goodsInService.getById(item.getGoodsInId());

            if (goodsIn != null) {
                // 3: 解析goodsInNo获取goods表的主键id.
                String[] goodsInNos = goodsIn.getGoodsInNo().split(",");
                for (String goodsInNo : goodsInNos) {
                    String goodsIdStr = goodsInNo.substring(goodsInNo.length() - 3);  // 获取后三位字符
                    Integer goodsId = Integer.parseInt(goodsIdStr);  // 转换为整型

                    // 4: 根据goodsId查询goods表中onShelf为1的数据.
                    Goods goods = goodsService.lambdaQuery().eq(Goods::getGoodsId, goodsId).eq(Goods::getOnShelf, 1).one();

                    if (goods != null) {
                        purchasableGoods.add(goods);
                    }
                }
            }
        }

        return Result.success(purchasableGoods);
    }

//>>>>>>>>>>>>>>>>>>>>>采购商
=======

    @GetMapping("/purchasable")
    @ApiOperation(value = "获取可购买的商品信息")
    public Result getPurchasableGoods() {
        List<InListGoods> inListGoods = inListGoodsService.lambdaQuery().eq(InListGoods::getIsReturned, IsReturned.NO).list();
        List<Goods> purchasableGoods = new ArrayList<>();
        for (InListGoods item : inListGoods) {
            Goods goods = goodsService.lambdaQuery().eq(Goods::getGoodsId, item.getGoodsId()).eq(Goods::getOnShelf, 1).one();
            if (goods != null) {
                purchasableGoods.add(goods);
            }
        }
        return Result.success(purchasableGoods);
    }



>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
}
