package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.User;
import com.trade.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Result getAllUsers() {
        List<User> users = userService.list();
        return Result.success(users);
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

    @PostMapping
    public Result createUser(@RequestBody User user) {
        boolean isSaved = userService.save(user);
        if (isSaved) {
            return Result.success(user);
        } else {
            return Result.error("Failed to create user");
        }
    }

    @PutMapping("/{id}")
    public Result updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setUserId(id);
        boolean isUpdated = userService.updateById(user);
        if (isUpdated) {
            return Result.success(user);
        } else {
            return Result.error("Failed to update user");
        }
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        boolean isRemoved = userService.removeById(id);
        if (isRemoved) {
            return Result.success();
        } else {
            return Result.error("Failed to delete user");
        }
    }
}
