//package com.trade.demo.controller;
//
//import com.trade.demo.common.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@RestController
//@CrossOrigin
//public class APhotoController {
//    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
//    @Autowired
//
//
//
//    @PostMapping("/admin/upload")
//    public Result photoUpload(MultipartFile file, HttpServletRequest req){
//        try{
//            String ID = (String)req.getServletContext().getAttribute("ID");
//            String originName = file.getOriginalFilename();
//            if(! originName.endsWith(".png")){
//                return   Result.error("文件格式不是.png");
//            }
//            String format = sdf.format(new Date());
//            String realPath = req.getServletContext().getRealPath("/")+format;
//            File folder = new File(realPath);
//            if(!folder.exists()){
//                folder.mkdirs();
//            }
//            String newName = UUID.randomUUID().toString() + ".png";
//
//
//            file.transferTo(new File(folder, newName));
//            String url = req.getScheme() + "://" + req.getServerName() + ":" +req.getServerPort() + format + newName;
//            System.out.println(url);
//            adminMapper.updatePhoto(url, ID);
//            return new Result(200, url,"");
//        }
//        catch (Exception exp){
//            System.out.println(exp);
//        }
//        return new Result(200,"","");
//    }
//}
