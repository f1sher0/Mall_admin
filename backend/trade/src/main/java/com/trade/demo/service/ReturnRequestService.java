package com.trade.demo.service;

import com.trade.demo.entity.ReturnRequest;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ReturnRequestService extends IService<ReturnRequest> {
    List<ReturnRequest> getByStatus(String status);
}
