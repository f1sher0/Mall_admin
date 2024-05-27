package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.Warehouse;
import com.trade.demo.mapper.WarehouseMapper;
import com.trade.demo.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {

    @Override
    public List<Warehouse> getUnreviewedWarehouses() {
        return this.lambdaQuery().eq(Warehouse::getStatus, '0').list();
    }
}
