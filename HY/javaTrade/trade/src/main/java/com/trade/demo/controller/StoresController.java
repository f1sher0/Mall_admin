package com.trade.demo.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.trade.demo.common.Result;
import com.trade.demo.entity.*;
import com.trade.demo.entity.*;
import com.trade.demo.selfpage.MedCountPage;
import com.trade.demo.service.*;
import com.trade.demo.service.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/stores")
public class StoresController {
    @Autowired
    private StoresService storesService;
@Autowired
private StoragesService storagesService;
@Autowired
private SalesService salesService;
@Autowired
private OutInsService outInsService;
@Autowired
private ManagesService managesService;
@Autowired
private MedicinesService medicinesService;
    // 查询所有商店信息
    @RequestMapping("/list")
    public Result list() {
        return Result.success(storesService.list());
    }

    // 分页查询商店信息
    @RequestMapping("/page")
    public Result page(long current, long size) {
        Page<Stores> page = new Page<>(current, size);
        return Result.success(storesService.page(page));
    }

    // 根据ID查询商店信息
    @RequestMapping("/getById")
    public Result getById(long id) {
        return Result.success(storesService.getById(id));
    }

    // 添加商店信息
    @RequestMapping("/save")
    public Result save(@RequestBody Stores stores) {
        return Result.success(storesService.save(stores));
    }

    // 更新商店信息
    @RequestMapping("/updateById")
    public Result updateById(Stores stores) {
        return Result.success(storesService.updateById(stores));
    }

    // 删除商店信息
//    @RequestMapping("/removeById")
//    public boolean removeById(long id) {
//        return storesService.removeById(id);
//    }

    @RequestMapping("/removeById")
    public Result removeById(long id) {


//        LambdaQueryWrapper<Medicines> QueryWrapper = new LambdaQueryWrapper<>();
//        QueryWrapper.eq(Medicines::getId, id);//逻辑出错!!
//        medicinesService.remove( QueryWrapper);
        // 查询 storages 表中与给定 id 相等的记录
//        LambdaQueryWrapper<Storages>  QueryWrapper = new LambdaQueryWrapper<>();
//        QueryWrapper.eq(Storages::getId, id);
//        Storages storage = storagesService.getOne( QueryWrapper);//只有一条,BUG捏
//
//        // 删除 medicines 表中与该仓库相关的记录
//        if (storage != null) {
//            LambdaQueryWrapper<Medicines> medicinesQueryWrapper = new LambdaQueryWrapper<>();
//            medicinesQueryWrapper.eq(Medicines::getId, storage.getMedicineId());
//            return medicinesService.remove(medicinesQueryWrapper);
//        }

        // 查询 storages 表中与给定 id 相等的所有记录
        //存储所有这个id的数据, 然后遍历删除四个分支的数据
        LambdaQueryWrapper<Stores> storesQueryWrapper = new LambdaQueryWrapper<>();
        storesQueryWrapper.eq(Stores::getId, id);
        List<Stores> stores = storesService.list(storesQueryWrapper);

        // 删除 medicines , stores表中 相关的记录
        for (Stores store : stores) {
            LambdaQueryWrapper<Sales> salesLambdaQueryWrapper = new LambdaQueryWrapper<>();
            LambdaQueryWrapper<Storages>storagesLambdaQueryWrapper = new LambdaQueryWrapper<>();
            LambdaQueryWrapper<Manages>managesLambdaQueryWrapper = new LambdaQueryWrapper<>();
            LambdaQueryWrapper<OutIns>outInsLambdaQueryWrapper = new LambdaQueryWrapper<>();

            salesLambdaQueryWrapper.eq(Sales::getNo, store.getSaleNo());
            storagesLambdaQueryWrapper.eq(Storages::getId,store.getStorageId());
            managesLambdaQueryWrapper.eq(Manages::getId,store.getManageId());
            outInsLambdaQueryWrapper.eq(OutIns::getNo,store.getOutInId());

            salesService.remove(salesLambdaQueryWrapper);
            storagesService.remove(storagesLambdaQueryWrapper);
            managesService.remove(managesLambdaQueryWrapper);
            outInsService.remove(outInsLambdaQueryWrapper);

        }

        // 删除 storages 表中与给定 id 相等的所有记录
        return Result.success(storesService.remove(storesQueryWrapper));
    }
    //查询剩余库存  返回药品以及数量
    @RequestMapping("/loadPost")
    public Result leftlist(String backname, long current,long size) {

        //查询供应商提供的物品(state=1) 成功提供
        LambdaQueryWrapper<OutIns> outInsLambdaQueryWrapper=new LambdaQueryWrapper<>();
        outInsLambdaQueryWrapper.eq(OutIns::getState,1);

        List<OutIns>outInsList=outInsService.list(outInsLambdaQueryWrapper);
        System.out.println(outInsList);
         //查询销售出去的物品,state=1  1==true, 代表成功销售
        LambdaQueryWrapper<Sales> salesLambdaQueryWrapper=new LambdaQueryWrapper<>();
        salesLambdaQueryWrapper.eq(Sales::getState,1);
        List<Sales>salesList=salesService.list(salesLambdaQueryWrapper);
        System.out.println(salesList);
//    进货但没卖物品
//        outInsLambdaQueryWrapper.and(wrapper -> wrapper.ne(OutIns::getNo, salesLambdaQueryWrapper));
////返回这些药品数据
//        LambdaQueryWrapper<Medicines>medicinesLambdaQueryWrapper=new LambdaQueryWrapper<>();
//        medicinesLambdaQueryWrapper.eq(Medicines::getId,outInsLambdaQueryWrapper.select(OutIns::getNo));
//        List<Medicines> list =medicinesService.list(medicinesLambdaQueryWrapper);
//        return Result.success(list);
//    进货但没卖物品
        List<String> listA = outInsList.stream()
                .map(OutIns::getNo)
                .collect(Collectors.toList());

        List<String> listB = salesList.stream()
                .map(Sales::getNo)
                .collect(Collectors.toList());

        List<String> listC = listA.stream()
                .filter(no -> !listB.contains(no))
                .collect(Collectors.toList());

        if (listC.isEmpty()) {
            return Result.success(new ArrayList<>()); // 没有剩余库存的情况
        }

        // 查询剩余库存的药品数据
        LambdaQueryWrapper<Medicines> medicinesWrapper = new LambdaQueryWrapper<>();

            if (backname == null || backname.trim().isEmpty()) {
                System.out.println("名字都不说啦? 默认查询全部啦~");

            }
            else {
                medicinesWrapper.like(Medicines::getName,backname);
            }
        medicinesWrapper.in(Medicines::getId, listC);

        List<Medicines> list = medicinesService.list(medicinesWrapper);
       // return Result.success(list);

        //尝试记录数量
        // 使用Map来记录药品名和对应的数量
        Map<String, Integer> medicineCountMap = new HashMap<>();

        // 遍历剩余库存的药品列表，计算药品名的数量
        for (Medicines medicine : list) {
            String medicineName = medicine.getName();
            medicineCountMap.put(medicineName, medicineCountMap.getOrDefault(medicineName, 0) + 1);
        }

        // 将药品名和数量存储在一个结果列表中
        List<MedCount> medicineCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : medicineCountMap.entrySet()) {
            medicineCounts.add(new MedCount((String)entry.getKey(), (Integer)entry.getValue()));
        }
        //裂开的鬼畜的BUG,手动分页
        int startIdx = (int) ((current - 1) * size);
        int endIdx = Math.min(startIdx + (int) size, medicineCounts.size());

        List<MedCount> pagedMedCountList = medicineCounts.subList(startIdx, endIdx);

        // 将处理后的结果放回分页对象
        System.out.println(medicineCounts.size());
        MedCountPage medCountPage = new MedCountPage();
        medCountPage.setRecords(pagedMedCountList);
        medCountPage.setCurrent(current);
        medCountPage.setSize(size);
        medCountPage.setTotal((long)medicineCounts.size());
        return Result.success(medCountPage);
    }

    //退货的药品
    // Stores表关联Medicines   数据在data中了  URL:stores/returnlist  , 前端res.data即可, 这里不用res.data.records
    @RequestMapping("/returnlist")
    public Result returnlist() {

        LambdaQueryWrapper<Sales> salesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        salesLambdaQueryWrapper.eq(Sales::getState, 0).select(Sales::getNo);


        List<Object> selectedNoList = salesService.listObjs(salesLambdaQueryWrapper);

        LambdaQueryWrapper<Medicines> medicinesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        medicinesLambdaQueryWrapper.in(Medicines::getId, selectedNoList);

        // Perform the query
        List<Medicines> relist = medicinesService.list(medicinesLambdaQueryWrapper);

        return Result.success(relist);
    }

//    @RequestMapping("/returnlist")
//    public Result returnlist (){
//
//        LambdaQueryWrapper<Sales> salesLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        salesLambdaQueryWrapper.eq(Sales::getState, 0).select(Sales::getNo);
//
//
//        LambdaQueryWrapper<Medicines> medicinesLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        medicinesLambdaQueryWrapper.in(Medicines::getId, salesLambdaQueryWrapper);
//
//
////
////        LambdaQueryWrapper<Sales> salesLambdaQueryWrapper = new LambdaQueryWrapper<>();
////        salesLambdaQueryWrapper.eq(Sales::getState,0);
////        LambdaQueryWrapper<Medicines>medicinesLambdaQueryWrapper= new LambdaQueryWrapper<>();
////        medicinesLambdaQueryWrapper.eq(Medicines::getId,salesLambdaQueryWrapper.select(Sales::getNo));
//        List<Medicines>relist=medicinesService.list(medicinesLambdaQueryWrapper);
//        return Result.success(relist);
//
//
//    }


    // 8 月 8日, 实现库存报表
    @GetMapping("/LeftExport")
    public void export(HttpServletResponse response) throws Exception {
        //查询供应商提供的物品(state=1) 成功提供
        LambdaQueryWrapper<OutIns> outInsLambdaQueryWrapper=new LambdaQueryWrapper<>();
        outInsLambdaQueryWrapper.eq(OutIns::getState,1);

        List<OutIns>outInsList=outInsService.list(outInsLambdaQueryWrapper);
        System.out.println(outInsList);
        //查询销售出去的物品,state=1  1==true, 代表成功销售
        LambdaQueryWrapper<Sales> salesLambdaQueryWrapper=new LambdaQueryWrapper<>();
        salesLambdaQueryWrapper.eq(Sales::getState,1);
        List<Sales>salesList=salesService.list(salesLambdaQueryWrapper);
        System.out.println(salesList);
//    进货但没卖物品
//        outInsLambdaQueryWrapper.and(wrapper -> wrapper.ne(OutIns::getNo, salesLambdaQueryWrapper));
////返回这些药品数据
//        LambdaQueryWrapper<Medicines>medicinesLambdaQueryWrapper=new LambdaQueryWrapper<>();
//        medicinesLambdaQueryWrapper.eq(Medicines::getId,outInsLambdaQueryWrapper.select(OutIns::getNo));
//        List<Medicines> list =medicinesService.list(medicinesLambdaQueryWrapper);
//        return Result.success(list);
//    进货但没卖物品
        List<String> listA = outInsList.stream()
                .map(OutIns::getNo)
                .collect(Collectors.toList());

        List<String> listB = salesList.stream()
                .map(Sales::getNo)
                .collect(Collectors.toList());

        List<String> listC = listA.stream()
                .filter(no -> !listB.contains(no))
                .collect(Collectors.toList());




        if (listC.isEmpty()) {
            ; // 没有剩余库存的情况
            listC.add("库存为空");
        }

        // 查询剩余库存的药品数据
        LambdaQueryWrapper<Medicines> medicinesWrapper = new LambdaQueryWrapper<>();
        medicinesWrapper.in(Medicines::getId, listC);

        List<Medicines> list = medicinesService.list(medicinesWrapper);

        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("库存报表", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

    @RequestMapping("/dayRecord")
    public Result daysRecord( ){
        Finance finance = new Finance();
        LocalDate today = LocalDate.now().minusDays(1) ;

        System.out.println(today.toString());

        LambdaQueryWrapper<Sales> salesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<OutIns> outInsLambdaQueryWrapper = new LambdaQueryWrapper<>();

        salesLambdaQueryWrapper.between(Sales::getTime, today , today );
        outInsLambdaQueryWrapper.between(OutIns::getTime,today,today);

//        IPage<Sales> salesIPage=salesService.page(page,salesLambdaQueryWrapper);

       long salesCount=(long) salesService.count(salesLambdaQueryWrapper) ;
       long buyCount=  (long)  outInsService.count(outInsLambdaQueryWrapper) ;

        salesLambdaQueryWrapper.eq(Sales::getState,1);
        outInsLambdaQueryWrapper.eq(OutIns::getState,1);
        long sucSales = (long)  salesService.count(salesLambdaQueryWrapper) ;
        long sucBuy=(long)  outInsService.count(outInsLambdaQueryWrapper) ;



        //自定义方法 额,配置侠
        List<Map<String, Object>> salesList = salesService.getSalesWithMedicines(today,today);
         List<Map<String, Object>> buylist = outInsService.getOutInsWithMedicines(today,today);

        Integer totalRevenue = 0;
        Integer totalProfit =0;

        for (Map<String, Object> sale : salesList) {
            if ((int) sale.get("state") == 1) {

                Integer price = (Integer)  sale.get("price");
                Integer selling = (Integer)  sale.get("selling");
                totalRevenue += selling;
//                totalProfit += (selling - price);
            }
        }
        Integer totalExpenses =0;
        for (Map<String, Object> buy : buylist) {
            if ((int) buy.get("state") == 1) {

                Integer cost = (Integer) buy.get("price");

                totalExpenses +=  cost;
            }
        }



        totalProfit = totalRevenue- totalExpenses ;
        finance.setSalesCount((int)salesCount);
        finance.setBuyCount((int)buyCount);
        finance.setSucSales((int)sucSales);
        finance.setSucBuy((int)sucBuy);

        finance.setTotalRevenue(totalRevenue);
        finance.setTotalProfit(totalProfit);
        finance.setTotalExpenses((int)totalExpenses);
        System.out.println(finance.toString());
        List<Finance> financeList = new ArrayList<>();
        financeList.add(finance);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("records", financeList);
        return Result.success(resultMap);
    }
    @RequestMapping("/dayfortableData")
    public Result fortableData(long current,long size){
        LocalDate today = LocalDate.now().minusDays(1) ;

        List<Map<String, Object>> statisticsList = new ArrayList<>();

        // 查询销售记录
        LambdaQueryWrapper<Sales> salesWrapper = new LambdaQueryWrapper<>();
        salesWrapper.eq(Sales::getState, 1)
                .between(Sales::getTime, today.atStartOfDay(), today.plusDays(1).atStartOfDay())
                .select(Sales::getNo, Sales::getTime);
        List<Sales> salesList = salesService.list(salesWrapper);
        for (Sales sale : salesList) {
            Map<String, Object> record = createStatisticsRecord(Integer.valueOf(sale.getNo()), sale.getTime(), 1);
            statisticsList.add(record);
        }

        // 查询进货记录
        LambdaQueryWrapper<OutIns> outInsWrapper = new LambdaQueryWrapper<>();
        outInsWrapper.eq(OutIns::getState, 1).between(OutIns::getTime, today.atStartOfDay(), today.plusDays(1).atStartOfDay())
                .select(OutIns::getNo, OutIns::getTime);
        List<OutIns> outInsList = outInsService.list(outInsWrapper);
        for (OutIns outIns : outInsList) {
            Map<String, Object> record = createStatisticsRecord(Integer.valueOf(outIns.getNo()), outIns.getTime(), 0);
            statisticsList.add(record);
        }
        Map<String, Object> resultMap = new HashMap<>();
//        resultMap.put("records", statisticsList);
        //尝试实现分页功能
        int start = (int) ((current - 1) * size);
        int end = Math.min(start + (int) size, statisticsList.size());

        List<Map<String, Object>> paginatedList = statisticsList.subList(start, end);


        resultMap.put("records", paginatedList);
        resultMap.put("total", statisticsList.size());

        return Result.success(resultMap);
    }

    private Map<String, Object> createStatisticsRecord(Integer medicineId, java.sql.Date time, int flag) {
        Map<String, Object> record = new HashMap<>();
        record.put("id", medicineId);
        record.put("typeNo", "");
        record.put("name", "");
        record.put("price", "");
        record.put("selling", "");
        record.put("time", time);
        record.put("flag", flag);
        // 查询药品信息并填充
        Medicines medicine = medicinesService.getById(medicineId);
        if (medicine != null) {
            record.put("typeNo", medicine.getTypeNo());
            record.put("name", medicine.getName());
            record.put("price", medicine.getPrice());
            record.put("selling", medicine.getSelling());
        }
        return record;
    }
    @RequestMapping("/monthfortableData")
    public Result monthfortableData(long current ,long size){
        YearMonth currentYearMonth = YearMonth.now();
        LocalDate firstDayOfMonth = currentYearMonth.atDay(1);
        LocalDate lastDayOfMonth = currentYearMonth.atEndOfMonth();

//        LocalDate today = LocalDate.now().minusDays(1);
        List<Map<String, Object>> statisticsList = new ArrayList<>();

        // 查询销售记录
        LambdaQueryWrapper<Sales> salesWrapper = new LambdaQueryWrapper<>();
        salesWrapper.eq(Sales::getState, 1)
                .between(Sales::getTime, firstDayOfMonth.atStartOfDay(), lastDayOfMonth.atStartOfDay())
                .select(Sales::getNo, Sales::getTime);
        List<Sales> salesList = salesService.list(salesWrapper);
        for (Sales sale : salesList) {
            Map<String, Object> record = createStatisticsRecord(Integer.valueOf(sale.getNo()), sale.getTime(), 1);
            statisticsList.add(record);
        }

        // 查询进货记录
        LambdaQueryWrapper<OutIns> outInsWrapper = new LambdaQueryWrapper<>();
        outInsWrapper.eq(OutIns::getState, 1).between(OutIns::getTime, firstDayOfMonth.atStartOfDay(), lastDayOfMonth.atStartOfDay())
                .select(OutIns::getNo, OutIns::getTime);
        List<OutIns> outInsList = outInsService.list(outInsWrapper);
        for (OutIns outIns : outInsList) {
            Map<String, Object> record = createStatisticsRecord(Integer.valueOf(outIns.getNo()), outIns.getTime(), 0);
            statisticsList.add(record);
        }
        Map<String, Object> resultMap = new HashMap<>();
//        resultMap.put("records", statisticsList);
        //尝试实现分页功能
        int start = (int) ((current - 1) * size);
        int end = Math.min(start + (int) size, statisticsList.size());

        List<Map<String, Object>> paginatedList = statisticsList.subList(start, end);


        resultMap.put("records", paginatedList);
        resultMap.put("total", statisticsList.size());

        return Result.success(resultMap);
    }
    @RequestMapping("/monthRecord")
    public Result monthRecord(){
        Finance finance = new Finance();
        YearMonth currentYearMonth = YearMonth.now();
        LocalDate firstDayOfMonth = currentYearMonth.atDay(1);
        LocalDate lastDayOfMonth = currentYearMonth.atEndOfMonth();


        LambdaQueryWrapper<Sales> salesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<OutIns> outInsLambdaQueryWrapper = new LambdaQueryWrapper<>();

        salesLambdaQueryWrapper.between(Sales::getTime, firstDayOfMonth.atStartOfDay(),lastDayOfMonth.atStartOfDay() );
        outInsLambdaQueryWrapper.between(OutIns::getTime,firstDayOfMonth.atStartOfDay(),lastDayOfMonth.atStartOfDay());

//        IPage<Sales> salesIPage=salesService.page(page,salesLambdaQueryWrapper);

        long salesCount=(long) salesService.count(salesLambdaQueryWrapper) ;
        long buyCount=  (long)  outInsService.count(outInsLambdaQueryWrapper) ;

        salesLambdaQueryWrapper.eq(Sales::getState,1);
        outInsLambdaQueryWrapper.eq(OutIns::getState,1);
        long sucSales = (long)  salesService.count(salesLambdaQueryWrapper) ;
        long sucBuy=(long)  outInsService.count(outInsLambdaQueryWrapper) ;



        //自定义方法 额,配置侠
        List<Map<String, Object>> salesList = salesService.getSalesWithMedicines(firstDayOfMonth.atStartOfDay().toLocalDate(),lastDayOfMonth.atStartOfDay().toLocalDate());
        List<Map<String, Object>> buylist = outInsService.getOutInsWithMedicines(firstDayOfMonth.atStartOfDay().toLocalDate(),lastDayOfMonth.atStartOfDay().toLocalDate());

        Integer totalRevenue = 0;
        Integer totalProfit =0;

        for (Map<String, Object> sale : salesList) {
            if ((int) sale.get("state") == 1) {

                Integer price = (Integer)  sale.get("price");
                Integer selling = (Integer)  sale.get("selling");
                totalRevenue += selling;
//                totalProfit += (selling - price);
            }
        }
        Integer totalExpenses =0;
        for (Map<String, Object> buy : buylist) {
            if ((int) buy.get("state") == 1) {

                Integer cost = (Integer) buy.get("price");

                totalExpenses +=  cost;
            }
        }

        totalProfit= totalRevenue-totalExpenses;


        finance.setSalesCount((int)salesCount);
        finance.setBuyCount((int)buyCount);
        finance.setSucSales((int)sucSales);
        finance.setSucBuy((int)sucBuy);

        finance.setTotalRevenue(totalRevenue);
        finance.setTotalProfit(totalProfit);
        finance.setTotalExpenses((int)totalExpenses);
        System.out.println(finance.toString());
        List<Finance> financeList = new ArrayList<>();
        financeList.add(finance);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("records", financeList);
        return Result.success(resultMap);

    }
    @RequestMapping("/dayExport")
    public void dayexport(HttpServletResponse response) throws Exception {
//考虑涉及两类数据的拼接,用Apache POI等库来创建和填充Excel表格。
        Result result = daysRecord();
        // 获取返回数据中的records字段，这是一个包含Finance对象的列表
        //  List<Map<String, Object>> records = (List<Map<String, Object>>) result.getData().get("records");
//由于显示隐式转换问题,583,584等价 580的逻辑,但后者get函数无法使用
        Map<String, Object> data = (Map<String, Object>) result.getData();
        List<Finance> records = (List<Finance>) data.get("records");

        Finance finance = records.get(0);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=daily paper.xlsx");

//Finance finance = new Finance();
//                finance.setSalesCount((Integer) financeData.get("salesCount"));
//                finance.setSucSales((Integer)   financeData.get("sucSales"));
//                finance.setBuyCount((Integer)   financeData.get("buyCount"));
//                finance.setSucBuy((Integer)     financeData.get("sucBuy"));
//              finance.setTotalRevenue((Integer) financeData.get("totalRevenue"));
//             finance.setTotalExpenses((Integer) financeData.get("totalExpenses"));
//               finance.setTotalProfit((Integer) financeData.get("totalProfit"));


        // 创建一个Excel工作簿和工作表
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("汇总统计数据");


// 创建标题行
        Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("进货交易次数");
        headerRow.createCell(1).setCellValue("进货交易成功次数");
        headerRow.createCell(2).setCellValue("总进货额");

        headerRow.createCell(3).setCellValue("销售交易次数");
        headerRow.createCell(4).setCellValue("销售交易成功次数");
        headerRow.createCell(5).setCellValue("总销售额");
        headerRow.createCell(6).setCellValue("总利润");

// 创建数据行
        Row dataRow0 = sheet.createRow(1);
//        dataRow.createCell(3).setCellValue((Integer) financeData.get("salesCount"));
//        dataRow.createCell(4).setCellValue((Integer) financeData.get("sucSales"));
//        dataRow.createCell(0).setCellValue((Integer) financeData.get("buyCount"));
//        dataRow.createCell(1).setCellValue((Integer) financeData.get("sucBuy"));
//        dataRow.createCell(5).setCellValue((Integer) financeData.get("totalRevenue"));
//        dataRow.createCell(2).setCellValue((Integer) financeData.get("totalExpenses"));
//        dataRow.createCell(6).setCellValue((Integer) financeData.get("totalProfit"));
        dataRow0.createCell(3).setCellValue(finance.getSalesCount());
        dataRow0.createCell(4).setCellValue(finance.getSucSales());
        dataRow0.createCell(0).setCellValue(finance.getBuyCount());
        dataRow0.createCell(1).setCellValue(finance.getSucBuy());
        dataRow0.createCell(5).setCellValue(finance.getTotalRevenue());
        dataRow0.createCell(2).setCellValue(finance.getTotalExpenses());
        dataRow0.createCell(6).setCellValue(finance.getTotalProfit());

        Result detail = fortableData(1,999);
        Map<String, Object> detaildata = (Map<String, Object>) detail.getData();
        List<Map<String, Object>> detailedDataList = (List<Map<String, Object>>) detaildata.get("records");




        Sheet detailSheet = workbook.createSheet("详细数据");
        Row headerRow1 = detailSheet.createRow(0);

        headerRow1.createCell(0).setCellValue("药品id");
        headerRow1.createCell(1).setCellValue("国药准字");
        headerRow1.createCell(2).setCellValue("药品名字");

        headerRow1.createCell(3).setCellValue("进货价");
        headerRow1.createCell(4).setCellValue("售价");
        headerRow1.createCell(5).setCellValue("时间");
        headerRow1.createCell(6).setCellValue("类型,1为成功销售,0为成功进货");
        // 使用你的代码填充详细数据工作表...
        int rowIndex = 1;
        for (Map<String, Object> record : detailedDataList) {
            Row dataRow = detailSheet.createRow(rowIndex);
            dataRow.createCell(0).setCellValue(record.get("id").toString());
            dataRow.createCell(1).setCellValue(record.get("typeNo").toString());
            dataRow.createCell(2).setCellValue(record.get("name").toString());
            dataRow.createCell(3).setCellValue(record.get("price").toString());
            dataRow.createCell(4).setCellValue(record.get("selling").toString());
            dataRow.createCell(5).setCellValue(record.get("time").toString());
            dataRow.createCell(6).setCellValue(record.get("flag").toString());


            rowIndex++;
        }



// 将工作簿写入文件或输出流
        try (OutputStream outputStream = response.getOutputStream()) {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            // 处理异常
            System.out.println("导出异常");
        }
    }


    @GetMapping("/monthExport")
    public void monthExport(HttpServletResponse response) throws Exception {
    Result result = monthRecord();

        // 获取返回数据中的records字段，这是一个包含Finance对象的列表
        //  List<Map<String, Object>> records = (List<Map<String, Object>>) result.getData().get("records");
//由于显示隐式转换问题,583,584等价 580的逻辑,但后者get函数无法使用

        Map<String, Object> data = (Map<String, Object>) result.getData();
        List<Finance> records = (List<Finance>) data.get("records");

        Finance finance = records.get(0);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=monthly paper.xlsx");



        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("汇总统计数据");


// 创建标题行
        Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("进货交易次数");
        headerRow.createCell(1).setCellValue("进货交易成功次数");
        headerRow.createCell(2).setCellValue("总进货额");

        headerRow.createCell(3).setCellValue("销售交易次数");
        headerRow.createCell(4).setCellValue("销售交易成功次数");
        headerRow.createCell(5).setCellValue("总销售额");
        headerRow.createCell(6).setCellValue("总利润");

// 创建数据行
        Row dataRow0 = sheet.createRow(1);
//        dataRow.createCell(3).setCellValue((Integer) financeData.get("salesCount"));
//        dataRow.createCell(4).setCellValue((Integer) financeData.get("sucSales"));
//        dataRow.createCell(0).setCellValue((Integer) financeData.get("buyCount"));
//        dataRow.createCell(1).setCellValue((Integer) financeData.get("sucBuy"));
//        dataRow.createCell(5).setCellValue((Integer) financeData.get("totalRevenue"));
//        dataRow.createCell(2).setCellValue((Integer) financeData.get("totalExpenses"));
//        dataRow.createCell(6).setCellValue((Integer) financeData.get("totalProfit"));
        dataRow0.createCell(3).setCellValue(finance.getSalesCount());
        dataRow0.createCell(4).setCellValue(finance.getSucSales());
        dataRow0.createCell(0).setCellValue(finance.getBuyCount());
        dataRow0.createCell(1).setCellValue(finance.getSucBuy());
        dataRow0.createCell(5).setCellValue(finance.getTotalRevenue());
        dataRow0.createCell(2).setCellValue(finance.getTotalExpenses());
        dataRow0.createCell(6).setCellValue(finance.getTotalProfit());

        Result detail = monthfortableData(1,999);
        Map<String, Object> detaildata = (Map<String, Object>) detail.getData();
        List<Map<String, Object>> detailedDataList = (List<Map<String, Object>>) detaildata.get("records");




        Sheet detailSheet = workbook.createSheet("详细数据");
        Row headerRow1 = detailSheet.createRow(0);

        headerRow1.createCell(0).setCellValue("药品id");
        headerRow1.createCell(1).setCellValue("国药准字");
        headerRow1.createCell(2).setCellValue("药品名字");

        headerRow1.createCell(3).setCellValue("进货价");
        headerRow1.createCell(4).setCellValue("售价");
        headerRow1.createCell(5).setCellValue("时间");
        headerRow1.createCell(6).setCellValue("类型,1为成功销售,0为成功进货");
        // 使用你的代码填充详细数据工作表...
        int rowIndex = 1;
        for (Map<String, Object> record : detailedDataList) {
            Row dataRow = detailSheet.createRow(rowIndex);
            dataRow.createCell(0).setCellValue(record.get("id").toString());
            dataRow.createCell(1).setCellValue(record.get("typeNo").toString());
            dataRow.createCell(2).setCellValue(record.get("name").toString());
            dataRow.createCell(3).setCellValue(record.get("price").toString());
            dataRow.createCell(4).setCellValue(record.get("selling").toString());
            dataRow.createCell(5).setCellValue(record.get("time").toString());
            dataRow.createCell(6).setCellValue(record.get("flag").toString());


            rowIndex++;
        }



// 将工作簿写入文件或输出流
        try (OutputStream outputStream = response.getOutputStream()) {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            // 处理异常
            System.out.println("导出异常");
        }

    }
 }
