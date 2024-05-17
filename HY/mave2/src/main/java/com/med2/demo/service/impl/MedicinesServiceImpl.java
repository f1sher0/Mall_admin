package com.med2.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.med2.demo.entity.Medicines;
import com.med2.demo.mapper.MedicinesMapper;
import com.med2.demo.service.MedicinesService;
import org.springframework.stereotype.Service;

@Service
public class MedicinesServiceImpl extends ServiceImpl<MedicinesMapper, Medicines>implements MedicinesService {
}
