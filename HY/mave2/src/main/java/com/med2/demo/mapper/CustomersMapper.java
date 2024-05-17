package com.med2.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.med2.demo.entity.Customers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomersMapper extends BaseMapper<Customers> {
}
