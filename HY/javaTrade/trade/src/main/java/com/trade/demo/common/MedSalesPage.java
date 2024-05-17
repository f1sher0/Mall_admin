package com.trade.demo.common;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trade.demo.entity.MedSales;

import java.util.List;


public class MedSalesPage extends Page<MedSales> {

    private List<MedSales> records;
    private long total;
    private long size;
    private long current;

    @Override
    public List<OrderItem> orders() {
        return null; // 返回排序信息
    }

//    @Override
//    public IPage<MedTime> orders(List<OrderItem> orders) {
//        // 设置排序信息
//        this.orders = orders;
//        return this;
//    }

    @Override
    public List<MedSales> getRecords() {
        return records;
    }

    @Override
    public MedSalesPage setRecords(List<MedSales> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return total;
    }

    @Override
    public MedSalesPage setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public MedSalesPage setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return current;
    }

    @Override
    public MedSalesPage setCurrent(long current) {
        this.current = current;
        return this;
    }
}