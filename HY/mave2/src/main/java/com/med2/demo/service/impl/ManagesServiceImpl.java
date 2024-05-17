package com.med2.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.med2.demo.entity.Emps;
import com.med2.demo.entity.Manages;
import com.med2.demo.mapper.EmpsMapper;
import com.med2.demo.mapper.ManagesMapper;
import com.med2.demo.service.EmpsService;
import com.med2.demo.service.ManagesService;
import org.springframework.stereotype.Service;

@Service
public class ManagesServiceImpl extends ServiceImpl<ManagesMapper, Manages> implements ManagesService {
}
