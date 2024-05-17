package com.trade.demo.common;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trade.demo.entity.MedTime;

import java.util.List;


public class MedTimePage extends Page<MedTime> {

    public List<MedTime> records;
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
    public List<MedTime> getRecords() {
        return records;
    }

    @Override
    public MedTimePage setRecords(List<MedTime> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return total;
    }

    @Override
    public MedTimePage setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public MedTimePage setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return current;
    }

    @Override
    public MedTimePage setCurrent(long current) {
        this.current = current;
        return this;
    }
}