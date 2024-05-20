package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity1.Customers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomersMapper extends BaseMapper<Customers> {
}
