package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.service.impl.DatabaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/database")
@Api(tags = "数据库备份恢复")
public class DatabaseBackupController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("/backup")
    @ApiOperation(value = "备份数据库")
    public Result backup() throws IOException {
        try {
            System.out.println("备份ing");
            databaseService.backup();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Result.error("Failed to backup database");
        }
        return Result.success();
    }

    @PostMapping("/restore")
    @ApiOperation(value = "恢复数据库")
    public Result restore() throws IOException {
        String projectPath = System.getProperty("user.dir");
        String adjustedPath = projectPath.replace("\\", "/");
        System.out.println(adjustedPath + " 测试路径位置");
        String backupPath = adjustedPath + "/src/main/resources/mybackup/" + "backup.sql"; // 保存备份的文件路径

        // 执行数据库恢复
        try {
            System.out.println("恢复ing");
            databaseService.restore(backupPath);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Result.error("Failed to restore database");
        }
        return Result.success();
    }
}
