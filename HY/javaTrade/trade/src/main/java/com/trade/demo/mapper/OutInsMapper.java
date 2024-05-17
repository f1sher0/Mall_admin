package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.OutIns;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface OutInsMapper extends BaseMapper<OutIns> {

    @Select("SELECT o.no, o.state, m.price, m.selling " +
            "FROM out_ins o " +
            "LEFT JOIN medicines m ON o.no = m.id " +
            "WHERE o.time BETWEEN #{startTime} AND #{endTime}")
    List<Map<String, Object>> getOutInsWithMedicines(@Param("startTime") LocalDate startTime,
                                                       @Param("endTime") LocalDate endTime);
}