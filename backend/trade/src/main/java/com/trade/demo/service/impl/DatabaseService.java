package com.trade.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
@Slf4j
@Service
public class DatabaseService {

    public void backup() throws IOException, InterruptedException {
        String username = "root";
        String password = "198455";
        String dbName = "store_manager";
        String projectPath = System.getProperty("user.dir");
        String adjustedPath = projectPath.replace("\\", "/");

        String backupPath = adjustedPath+"/src/main/resources/mybackup/"+  "store_manager_backup.sql"; // 保存备份的文件路径

        String command = String.format(
            "mysqldump -u %s -p%s %s -r %s",
            username, password, dbName, backupPath
        );
        Process process = Runtime.getRuntime().exec(command);
        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("数据库备份成功！");
        } else {
            System.out.println("数据库备份失败！");
        }
    }

    public void restore(String restoreFilePath) throws IOException, InterruptedException {
        String userName = "root";
        String host = "localhost";

        String password = "198455";
        String database = "store_manager";

//        String command = String.format(
//            "mysql -u %s -p%s %s < %s",
//            username, password, dbName, backupPath
//        );
//
//        Process process = Runtime.getRuntime().exec(command);
//        int exitCode = process.waitFor();
//
//        if (exitCode == 0) {
//            System.out.println("数据库恢复成功！");
//        } else {
//            System.out.println("数据库恢复失败！");
//        }


        File restoreFile = new File(restoreFilePath);
        if (restoreFile.isDirectory()) {
            for (File file : restoreFile.listFiles()) {
                if (file.exists() && file.getPath().endsWith(".sql")) {
                    restoreFilePath = file.getAbsolutePath();
                    break;
                }
            }
        }

        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime
                    .exec("mysql.exe -h"+host+" -u"+userName+" -p"+password+" --default-character-set=utf8 " + database);
            OutputStream outputStream = process.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(restoreFilePath), "utf-8"));
            String str = null;
            StringBuffer sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str + "\r\n");
            }
            str = sb.toString();
            // System.out.println(str);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream, "utf-8");
            writer.write(str);
            writer.flush();
            outputStream.close();
            br.close();
            writer.close();
            log.info("数据已从 " + restoreFilePath + " 导入到数据库中");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.info("数据从 " + restoreFilePath + " 导入到数据库失败");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.info("数据从 " + restoreFilePath + " 导入到数据库失败");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("数据从 " + restoreFilePath + " 导入到数据库失败");
        }

    }
}
