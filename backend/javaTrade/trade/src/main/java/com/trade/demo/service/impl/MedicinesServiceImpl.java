package com.trade.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trade.demo.entity1.Medicines;
import com.trade.demo.mapper.MedicinesMapper;
import com.trade.demo.service.MedicinesService;
import org.springframework.stereotype.Service;

@Service
public class MedicinesServiceImpl extends ServiceImpl<MedicinesMapper, Medicines>implements MedicinesService {
}
