package com.trade.demo.entity1;

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
@ApiModel(value = "MedTime对象", description = "用于进货相关显示")


public class MedTime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Alias("药品id")

    private Integer id;
    @Alias("国药准字")

    private Integer  typeNo ;
    @Alias("药品名字")
    private String  name;
    @Alias("供应商")
    private String supplierName;
    @Alias("供应商联系方式")
    private String phone;
    @Alias("进货价")
    private Integer price;
    @Alias("入库时间")
    private Date time;


}
