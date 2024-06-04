package com.trade.demo.service;

import com.trade.demo.entity.ReturnRequest;
import com.baomidou.mybatisplus.extension.service.IService;

<<<<<<< HEAD
public interface ReturnRequestService extends IService<ReturnRequest> {
=======
import java.util.List;

public interface ReturnRequestService extends IService<ReturnRequest> {
    List<ReturnRequest> getByStatus(String status);
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
}
