package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.Purchaser;
import com.trade.demo.mapper.PurchaserMapper;
import com.trade.demo.service.PurchaserService;
import org.springframework.stereotype.Service;

@Service
public class PurchaserServiceImpl extends ServiceImpl<PurchaserMapper, Purchaser> implements PurchaserService {
}
