package com.trade.demo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.trade.demo.common.Result;
import com.trade.demo.entity.User;
import com.trade.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
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

        // 将token发送给客户端
//        HashMap<String, Object> data = new HashMap<>();
//        data.put("user", user);
//        data.put("token", JWTtoken);

//        result.setMsg("登录成功");
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
        user.setUsername(user.getUsername());
        user.setStatus("A");  // Assuming 'A' stands for Active
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
}
