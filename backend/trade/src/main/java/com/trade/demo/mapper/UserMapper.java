package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
