package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.entity.Sales;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public interface SalesService extends IService<Sales> {
    int getSalesCountByDate(String today);



    List<Map<String, Object>> getSalesWithMedicines(LocalDate today, LocalDate today1);

    List<Map<String, Object>> forsalesload();

    List<Map<String, Object>> forsalesload2(Integer valueOf);
}
