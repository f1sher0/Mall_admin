package com.med2.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.med2.demo.entity.Sales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface SalesMapper extends BaseMapper<Sales> {
    static int getSalesCountByDate(String today) {
        return -1;
    }
    @Select("SELECT s.no, s.state, m.price, m.selling " +
            "FROM sales s " +
            "LEFT JOIN medicines m ON s.no = m.id " +
            "WHERE s.time BETWEEN #{startTime} AND #{endTime}")
    List<Map<String, Object>> selectSalesWithMedicines(@Param("startTime") LocalDate startTime,
                                                       @Param("endTime") LocalDate endTime);


    @Select(" SELECT distinct m.id AS  id, m.type_no AS typeNo, "+
    "m.name AS name,  c.name AS custName,c.phone as phone ,m.selling as selling, s.time as time ,s.state as state"+
            "  FROM    sales s " +
            "   JOIN     medicines m ON s.no = m.id   JOIN    customers c ON s.customer_id = c.id;")

    List<Map<String, Object>> forsalesload();


    @Select(" SELECT distinct m.id AS  id, m.type_no AS typeNo, "+
            "m.name AS name,  c.name AS custName, c.phone as phone , m.selling as selling, s.time as time ,s.state as state"+
            "  FROM    sales s " +
            "   JOIN     medicines m ON s.no = m.id and m.id like CONCAT('%', #{valueOf}, '%')  JOIN    customers c ON s.customer_id = c.id "
             )

    List<Map<String, Object>> forsalesload2(@Param("valueOf") Integer valueOf);
}
