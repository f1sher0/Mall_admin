package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity.OutIns;
import com.trade.demo.mapper.OutInsMapper;
import com.trade.demo.service.OutInsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class OutInsServiceImpl extends ServiceImpl<OutInsMapper, OutIns> implements OutInsService {
    @Resource
    private OutInsMapper outInsMapper;
    @Override
    public List<Map<String, Object>> getOutInsWithMedicines(LocalDate today, LocalDate today1) {
        return outInsMapper.getOutInsWithMedicines(today,today1) ;
    }


}
