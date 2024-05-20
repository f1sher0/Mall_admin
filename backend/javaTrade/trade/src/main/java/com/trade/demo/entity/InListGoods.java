package com.trade.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "InListGoods", description = "入库单商品")
public class InListGoods implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "入库单ID")
    private Integer goodsInId;

    @ApiModelProperty(value = "商品ID")
    private Integer goodsId;
}
