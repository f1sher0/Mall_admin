package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.entity.Warehouse;

import java.util.List;

public interface WarehouseService extends IService<Warehouse> {
    List<Warehouse> getUnreviewedWarehouses();
}
