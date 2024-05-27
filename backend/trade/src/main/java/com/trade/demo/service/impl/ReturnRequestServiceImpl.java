package com.trade.demo.service.impl;

import com.trade.demo.entity.ReturnRequest;
import com.trade.demo.mapper.ReturnRequestMapper;
import com.trade.demo.service.ReturnRequestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ReturnRequestServiceImpl extends ServiceImpl<ReturnRequestMapper, ReturnRequest> implements ReturnRequestService {
}
