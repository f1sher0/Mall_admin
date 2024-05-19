package com.trade.demo.entity1;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;



@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SaleMt", description = "用于salesView显示")


public class SaleMT implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer  typeNo ;
    private String  name;
    private String supplierName;
    private Integer price;
    private Date time;

}