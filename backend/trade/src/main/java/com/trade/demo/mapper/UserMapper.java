package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user WHERE email = #{email}")
    User selectByEmail(String email);
}
