package com.trade.demo.entity;


import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Customer对象", description = "客户信息")
public class Customers implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "客户姓名")
    @Alias("客户姓名")
    private String name;

    @ApiModelProperty(value = "销售单号")
    @Alias("客户的销售单号关联销售表可知道买卖时间, 是否退货")
    private Integer saleNo;

    @ApiModelProperty(value = "联系方式")
    @Alias("客户联系方式")
    private String phone;
}