package com.trade.demo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.trade.demo.common.Result;
import com.trade.demo.entity.*;
import com.trade.demo.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result login(@RequestBody User loginUser) {
        User user = userService.findByEmail(loginUser.getEmail());
        if (user == null || !user.getPassword().equals(loginUser.getPassword())) {
            return Result.error("Invalid email or password");
        }
        if(user.getStatus()=='0'){
            return  Result.unauthorized("该用户暂没有通过审核,无法使用");
        }

        String JWTtoken = JWT.create()
                .withSubject(user.getEmail().toString() + user.getPassword())
                .withExpiresAt(new java.sql.Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 设置过期时间
                .sign(Algorithm.HMAC256("secret")); // 使用秘钥签名
        String role = user.getRole();
        System.out.println(JWTtoken);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("role", role);
        responseMap.put("token", JWTtoken);

        return Result.success(responseMap);

    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Result registerUser(@RequestBody User user) {
        user.setEmail(user.getEmail());
        user.setStatus('0');
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        System.out.println(user.getEmail());
        user.setPassword(user.getPassword());
        System.out.println(user.getRole());
        if (user.getEmail() == null || user.getPassword() == null || user.getRole() == null) {
            return Result.error("Email, Password, and Role are required.");
        }
         if (userService.isEmailTaken(user.getEmail())) {
            return Result.error("Email is already in use.");
        }

//        user.setEmail(user.getEmail());
//        user.setStatus('0');
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());
//        user.setPassword(user.getPassword());
//        System.out.println(user.getRole());
        boolean isSaved = userService.save(user);
        if (isSaved) {
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

    @GetMapping("/unreviewed")
    @ApiOperation(value = "获取所有未审核的用户和仓库")
    public Result getUnreviewedEntities() {
        List<Object> unreviewedEntities = new ArrayList<>();
        unreviewedEntities.addAll(userService.getUnreviewedUsers());
        unreviewedEntities.addAll(warehouseService.getUnreviewedWarehouses());
        return Result.success(unreviewedEntities);
    }
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
            return Result.success(userService.updateById(user));
        }
        return Result.error("User not found");
    }

    @PutMapping("/approve/warehouse")
    @ApiOperation(value = "审核通过仓库")
    public Result approveWarehouse(@RequestParam Integer warehouseId) {
        Warehouse warehouse = warehouseService.getById(warehouseId);
        if (warehouse != null) {
            warehouse.setStatus('1');
            return Result.success(warehouseService.updateById(warehouse));
        }
        return Result.error("Warehouse not found");
    }

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
}
