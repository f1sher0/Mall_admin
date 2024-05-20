package com.trade.demo.selfpage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.trade.demo.entity1.MedCount;

import java.util.List;
public  class MedCountPage implements IPage<MedCount> {
    private List<MedCount> records;
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
    public List<MedCount> getRecords() {
        return records;
    }

    @Override
    public MedCountPage setRecords(List<MedCount> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return total;
    }

    @Override
    public MedCountPage setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public MedCountPage setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return current;
    }

    @Override
    public MedCountPage setCurrent(long current) {
        this.current = current;
        return this;
    }
}