package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SalesListGoods", description = "销售单商品")
public class SalesListGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableField("salesId")
    @ApiModelProperty(value = "销售单ID")
    private Integer salesId;
    @TableField("goodsId")
    @ApiModelProperty(value = "商品ID")
    private Integer goodsId;
}