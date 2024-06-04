package com.trade.demo.controller;

<<<<<<< HEAD
import com.trade.demo.entity.ReturnRequest;
=======
import com.trade.demo.common.Result;
import com.trade.demo.entity.Goods;
import com.trade.demo.entity.ReturnRequest;
import com.trade.demo.service.GoodsService;
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
import com.trade.demo.service.ReturnRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.util.List;

@RestController
@RequestMapping("/returnrequests")
=======
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/returnrequests")
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
@Api(value = "ReturnRequestController", tags = {"退货申请管理"})
public class ReturnRequestController {

    @Autowired
    private ReturnRequestService returnRequestService;
<<<<<<< HEAD

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取退货申请")
    public ReturnRequest getReturnRequestById(@RequestParam Integer requestId) {
        return returnRequestService.getById(requestId);
=======
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
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有退货申请")
<<<<<<< HEAD
    public List<ReturnRequest> getAllReturnRequests() {
        return returnRequestService.list();
=======
    public Result getAllReturnRequests() {
        List<ReturnRequest> returnRequests = returnRequestService.list();
        return Result.success(returnRequests);
    }

    @GetMapping("/status")
    @ApiOperation(value = "根据状态获取退货申请")
    public Result getReturnRequestsByStatus(@RequestParam String status) {
        List<ReturnRequest> returnRequests = returnRequestService.getByStatus(status);
        return Result.success(returnRequests);
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加退货申请")
<<<<<<< HEAD
    public void insertReturnRequest(@RequestBody ReturnRequest returnRequest) {
        returnRequestService.save(returnRequest);
=======
    public Result insertReturnRequest(@RequestBody ReturnRequest returnRequest) {
        boolean isSaved = returnRequestService.save(returnRequest);
        if (isSaved) {
            return Result.success("添加退货申请成功");
        } else {
            return Result.error("添加退货申请失败");
        }
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新退货申请")
<<<<<<< HEAD
    public void updateReturnRequest(@RequestBody ReturnRequest returnRequest) {
        returnRequestService.updateById(returnRequest);
=======
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
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除退货申请")
<<<<<<< HEAD
    public void deleteReturnRequest(@RequestParam Integer requestId) {
        returnRequestService.removeById(requestId);
=======
    public Result deleteReturnRequest(@RequestParam Integer requestId) {
        boolean isRemoved = returnRequestService.removeById(requestId);
        if (isRemoved) {
            return Result.success();
        } else {
            return Result.error("删除退货申请失败");
        }
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
    }
}
