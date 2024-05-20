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
@ApiModel(value = "WarehouseGoods", description = "仓库商品信息")
public class WarehouseGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableField("warehouseId")
    @ApiModelProperty(value = "仓库ID")
    private Integer warehouseId;
    @TableField("goodsId")
    @ApiModelProperty(value = "商品ID")
    private String goodsId;
    @TableField("goodsQuantity")
    @ApiModelProperty(value = "商品数量")
    private String goodsQuantity;
}
