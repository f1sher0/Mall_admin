package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.dto.ReturnRequestDTO;
import com.trade.demo.entity.Goods;
import com.trade.demo.entity.ReturnRequest;
import com.trade.demo.service.GoodsService;
import com.trade.demo.service.ReturnRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/returnrequests")
@Api(value = "ReturnRequestController", tags = {"退货申请管理"})
public class ReturnRequestController {

    @Autowired
    private ReturnRequestService returnRequestService;
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取退货申请")
    public Result getReturnRequestById(@RequestParam Integer requestId) {

        ReturnRequest returnRequest = returnRequestService.getById(requestId);
        if (returnRequest != null) {
            return Result.success(returnRequest);
        } else {
            return Result.error("退货申请不存在");
        }
    }
    @GetMapping("/getBySubid_Role")
    @ApiOperation(value = "根据提交人id,role获取退货申请")
    public Result getBySubid_Role(@RequestParam Integer id,@RequestParam String role) {
        List<ReturnRequestDTO> returnRequestDTOs = returnRequestService.getBySubid_Role2(id, role);

        if (returnRequestDTOs != null && !returnRequestDTOs.isEmpty()) {
            return Result.success(returnRequestDTOs);
        } else {
            return Result.error("退货申请不存在");
        }
    }
    @GetMapping("/all")
    @ApiOperation(value = "获取所有退货申请")
    public Result getAllReturnRequests() {
        List<ReturnRequest> returnRequests = returnRequestService.list();
        return Result.success(returnRequests);
    }

    @GetMapping("/status")
    @ApiOperation(value = "根据状态获取退货申请")
    public Result getReturnRequestsByStatus(@RequestParam String status) {
        List<ReturnRequest> returnRequests = returnRequestService.getByStatus(status);
        return Result.success(returnRequests);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加退货申请")
    public Result insertReturnRequest(@RequestBody ReturnRequest returnRequest) {
        boolean isSaved = returnRequestService.save(returnRequest);
        if (isSaved) {
            return Result.success("添加退货申请成功");
        } else {
            return Result.error("添加退货申请失败");
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新退货申请")
    public Result updateReturnRequest(@RequestBody ReturnRequest returnRequest) {
        // 检查状态是否变为已批准
        if ("已批准".equals(returnRequest.getStatus())) {
            // 获取商品ID并更新商品的onShelf值
            Goods goods = goodsService.getById(returnRequest.getGoodsId());
            if (goods != null) {
                goods.setOnShelf(goods.getOnShelf() == 1 ? 0 : 1);
                goods.setUpdateTime(new Date());
                goodsService.updateById(goods);
            }
        }
        returnRequest.setReviewTime(new Date());
        boolean isUpdated = returnRequestService.updateById(returnRequest);
        if (isUpdated) {
            return Result.success(returnRequest);
        } else {
            return Result.error("更新退货申请失败");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除退货申请")
    public Result deleteReturnRequest(@RequestParam Integer requestId) {
        boolean isRemoved = returnRequestService.removeById(requestId);
        if (isRemoved) {
            return Result.success();
        } else {
            return Result.error("删除退货申请失败");
        }
    }
}
