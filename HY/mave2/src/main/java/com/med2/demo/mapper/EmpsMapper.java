package com.med2.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.med2.demo.entity.Emps;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpsMapper extends BaseMapper<Emps> {
    List<Emps> empsall();

    Emps MyGetByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
