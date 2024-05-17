package com.trade.demo.entity;

import cn.hutool.core.annotation.Alias;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "MedSale对象", description = "用于显示药品售卖信息,如时间,顾客")


public class MedSales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Alias("药品id")
    private Integer id;
    @Alias("国药准字")
    private Integer  typeNo ;
    @Alias("药品名字")
    private String  name;
    @Alias("客户")
    private String custName;
    @Alias("客户联系方式")
    private String phone;
    @Alias("售价")
    private Integer selling;
    @Alias("销售时间")
    private Date time;


}
