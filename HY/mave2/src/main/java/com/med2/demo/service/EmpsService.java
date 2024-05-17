package com.med2.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.med2.demo.entity.Emps;
import com.med2.demo.mapper.EmpsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface EmpsService extends IService<Emps> {

    List<Emps> empsall();

    Emps MyGetByUsernameAndPassword(String username, String password);
}
