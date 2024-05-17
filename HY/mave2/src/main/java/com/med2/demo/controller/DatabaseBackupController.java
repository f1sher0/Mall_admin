package com.med2.demo.controller;

import com.med2.demo.common.Result;
import com.med2.demo.service.impl.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/database")
public class DatabaseBackupController {

    @Autowired
    private DatabaseService databaseService;

    @RequestMapping("/backup")
    public Result backup( ) throws IOException {
        try {
            System.out.println("备份ing");
            databaseService.backup();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //以下不要,没必要让前端决定保存文件在哪,已经在之前的处理决定sql数据保存位置,以下代码会导致多次发送响应数据
//        String projectPath = System.getProperty("user.dir");
//        String adjustedPath = projectPath.replace("\\", "/");
//
//        String backupPath = adjustedPath+"/src/main/resources/mybackup/"+  "store_manager_backup.sql"; // 保存备份的文件路径
//
//        // 返回备份文件给前端
//
//
//
////        String backupPath =  getClass().getResource("/store_manager_backup.sql").getPath();
//        // 设置响应的内容类型为二进制流
//        response.setContentType("application/octet-stream");
//        // 设置响应头，指定文件名
//        response.setHeader("Content-Disposition", "attachment; filename=store_manager_backup.sql");
//        // 读取备份文件数据并写入响应输出流
//        Files.copy(Paths.get(backupPath), response.getOutputStream());
//        response.flushBuffer();
        return Result.success();
    }

    @RequestMapping("/restore")
    public Result restore( ) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String adjustedPath = projectPath.replace("\\", "/");
        System.out.println(adjustedPath+" 测试路径位置");
        String backupPath = adjustedPath+"/src/main/resources/mybackup/"+  "store_manager_backup.sql"; // 保存备份的文件路径

        // 将上传的文件保存到临时文件中
//        Files.copy(file.getInputStream(), Paths.get(backupPath), StandardCopyOption.REPLACE_EXISTING);
        
        // 执行数据库恢复
        try {
            System.out.println("恢复ing");

            databaseService.restore (backupPath);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.success();
    }
}
