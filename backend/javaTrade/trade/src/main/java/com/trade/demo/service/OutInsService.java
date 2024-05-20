package com.trade.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trade.demo.entity1.OutIns;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public interface OutInsService extends IService<OutIns> {
    List<Map<String, Object>> getOutInsWithMedicines(LocalDate today, LocalDate today1);
}
