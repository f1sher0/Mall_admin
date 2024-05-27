package com.trade.demo.controller;

import com.trade.demo.entity.ReturnRequest;
import com.trade.demo.service.ReturnRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returnrequests")
@Api(value = "ReturnRequestController", tags = {"退货申请管理"})
public class ReturnRequestController {

    @Autowired
    private ReturnRequestService returnRequestService;

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取退货申请")
    public ReturnRequest getReturnRequestById(@RequestParam Integer requestId) {
        return returnRequestService.getById(requestId);
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有退货申请")
    public List<ReturnRequest> getAllReturnRequests() {
        return returnRequestService.list();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加退货申请")
    public void insertReturnRequest(@RequestBody ReturnRequest returnRequest) {
        returnRequestService.save(returnRequest);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新退货申请")
    public void updateReturnRequest(@RequestBody ReturnRequest returnRequest) {
        returnRequestService.updateById(returnRequest);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除退货申请")
    public void deleteReturnRequest(@RequestParam Integer requestId) {
        returnRequestService.removeById(requestId);
    }
}
