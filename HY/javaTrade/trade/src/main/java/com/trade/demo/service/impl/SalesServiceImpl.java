package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.Sales;
import com.trade.demo.mapper.SalesMapper;
import com.trade.demo.service.SalesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class SalesServiceImpl extends ServiceImpl<SalesMapper, Sales> implements SalesService {
    @Override
    public int getSalesCountByDate(String today) {
        return SalesMapper.getSalesCountByDate(today);
    }




    @Resource
    private SalesMapper salesMapper;
@Override
    public List<Map<String, Object>> getSalesWithMedicines(LocalDate startTime, LocalDate endTime) {
        return salesMapper.selectSalesWithMedicines(startTime, endTime);
    }
@Override
   public List<Map<String, Object>> forsalesload(){
    return salesMapper.forsalesload();
};

    @Override
    public List<Map<String, Object>> forsalesload2(Integer valueOf){
        return salesMapper.forsalesload2(valueOf);
    };
}
