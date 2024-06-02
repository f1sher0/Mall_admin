package com.trade.demo.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.trade.demo.common.Result;
import com.trade.demo.entity.WarehouseGoods;
import com.trade.demo.entity.WarehouseGoodsGroupedInfo;
import com.trade.demo.entity.WarehouseGoodsInfo;
import com.trade.demo.service.WarehouseGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/warehouseGoods")
@Api(tags ="库存信息管理")
public class WarehouseGoodsController {

    @Autowired
    private WarehouseGoodsService warehouseGoodsService;

    @ApiOperation(value = "添加新的仓库商品条目")
    @PostMapping("/add")
    public Result addWarehouseGoods(@RequestBody WarehouseGoods warehouseGoods) {
        boolean isSaved = warehouseGoodsService.save(warehouseGoods);
        if (isSaved) {
            return Result.success(warehouseGoods);
        } else {
            return Result.error("添加仓库商品失败");
        }
    }

    @ApiOperation(value = "根据ID获取仓库商品信息")
    @GetMapping("/get")
    public Result getWarehouseGoodsById(@RequestParam Integer id) {
        WarehouseGoods warehouseGoods = warehouseGoodsService.getById(id);
        if (warehouseGoods != null) {
            return Result.success(warehouseGoods);
        } else {
            return Result.error("未找到仓库商品");
        }
    }

    @ApiOperation(value = "获取所有仓库商品列表")
    @GetMapping("/list")
    public Result listWarehouseGoods() {
        List<WarehouseGoods> warehouseGoodsList = warehouseGoodsService.list();
        return Result.success(warehouseGoodsList);
    }

    @GetMapping("/info")
    @ApiOperation(value = "查询每个仓库的存储商品的信息 商品名字/价格等")
    public Result getWarehouseGoodsInfo(@RequestParam(required = false) String id) {
        List<WarehouseGoodsInfo> info;
        if (StringUtils.isNotBlank(id)) {
            info = warehouseGoodsService.getWarehouseGoodsInfo(Integer.parseInt(id));
        } else {
            // todo 可以遍历所有的warehouseid,进行封装返回数据
            Set<Integer> warehouseIds = new HashSet<>();
            List<WarehouseGoods> allWarehouseGoods = warehouseGoodsService.list();

            for (WarehouseGoods warehouseGoods : allWarehouseGoods) {
                warehouseIds.add(warehouseGoods.getWarehouseId());
            }

            info = new ArrayList<>();
            for (Integer warehouseId : warehouseIds) {
                info.addAll(warehouseGoodsService.getWarehouseGoodsInfo(warehouseId));
            }
//            System.out.println("ok null");
        }
        return Result.success(info);
    }
    @ApiOperation(value = "导出仓库的存储商品的信息 商品名字/价格等")
    @GetMapping("/LeftExportInfo")
    public void export(HttpServletResponse response) throws Exception {


            List<WarehouseGoodsInfo> info;

            Set<Integer> warehouseIds = new HashSet<>();
            List<WarehouseGoods> allWarehouseGoods = warehouseGoodsService.list();

            for (WarehouseGoods warehouseGoods : allWarehouseGoods) {
                warehouseIds.add(warehouseGoods.getWarehouseId());
            }

            info = new ArrayList<>();
            for (Integer warehouseId : warehouseIds) {
                info.addAll(warehouseGoodsService.getWarehouseGoodsInfo(warehouseId));
            }
            // 在内存操作，写出到浏览器
            ExcelWriter writer = ExcelUtil.getWriter(true);

            // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
            writer.write(info, true);

            // 设置浏览器响应的格式
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            String fileName = URLEncoder.encode("库存报表", "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

            ServletOutputStream out = response.getOutputStream();
            writer.flush(out, true);
            out.close();
            writer.close();

        }

    @GetMapping("/groupedinfo")
    @ApiOperation(value = "查询每个仓库的存储商品的信息，并按商品名分组")
    public Result getWarehouseGoodsGroupedInfo() {
        List<WarehouseGoodsGroupedInfo> groupedInfo = warehouseGoodsService.getWarehouseGoodsGroupedInfo();
        return Result.success(groupedInfo);
    }

    @ApiOperation(value = "更新现有的仓库商品条目")
    @PutMapping("/update")
    public Result updateWarehouseGoods(@RequestBody WarehouseGoods warehouseGoods) {
        boolean isUpdated = warehouseGoodsService.updateById(warehouseGoods);
        if (isUpdated) {
            return Result.success(warehouseGoods);
        } else {
            return Result.error("更新仓库商品失败");
        }
    }

    @ApiOperation(value = "根据ID删除仓库商品条目")
    @DeleteMapping("/delete")
    public Result deleteWarehouseGoods(@RequestParam Integer id) {
        boolean isRemoved = warehouseGoodsService.removeById(id);
        if (isRemoved) {
            return Result.success("仓库商品删除成功");
        } else {
            return Result.error("删除仓库商品失败");
        }
    }

//    @ApiOperation(value = "计算仓库中特定商品的数量")
//    @GetMapping("/calculateQuantity")
//    public Result calculateGoodsQuantity(@RequestParam Integer warehouseId, @RequestParam Integer goodsId) {
//        WarehouseGoods warehouseGoods = warehouseGoodsService.getById(warehouseId);
//        if (warehouseGoods != null) {
//            String[] goodsIds = warehouseGoods.getGoodsId().split(",");
//            String[] quantities = warehouseGoods.getGoodsQuantity().split(",");
//            for (int i = 0; i < goodsIds.length; i++) {
//                if (Integer.parseInt(goodsIds[i]) == goodsId) {
//                    return Result.success(quantities[i]);
//                }
//            }
//            return Result.error("仓库中未找到该商品");
//        } else {
//            return Result.error("未找到仓库");
//        }
//    }
}
