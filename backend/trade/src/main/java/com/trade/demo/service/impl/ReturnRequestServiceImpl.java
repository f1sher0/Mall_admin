package com.trade.demo.service.impl;

import com.trade.demo.entity.ReturnRequest;
import com.trade.demo.mapper.ReturnRequestMapper;
import com.trade.demo.service.ReturnRequestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
@Service
public class ReturnRequestServiceImpl extends ServiceImpl<ReturnRequestMapper, ReturnRequest> implements ReturnRequestService {
=======
import java.util.List;

@Service
public class ReturnRequestServiceImpl extends ServiceImpl<ReturnRequestMapper, ReturnRequest> implements ReturnRequestService {

    @Override
    public List<ReturnRequest> getByStatus(String status) {
        return lambdaQuery().eq(ReturnRequest::getStatus, status).list();
    }
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
}
