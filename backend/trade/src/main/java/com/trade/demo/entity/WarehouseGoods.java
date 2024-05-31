package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "warehousegoods")
@ApiModel(value = "WarehouseGoods", description = "仓库商品信息")
public class WarehouseGoods implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId("warehouseGoodsId")
    @ApiModelProperty(value = "仓库商品ID", example = "1")
    private Integer warehouseGoodsId;

    @TableField("warehouseId")
    @ApiModelProperty(value = "仓库ID", example = "1")
    private Integer warehouseId;

    @TableField("goodsId")
    @ApiModelProperty(value = "商品ID", example = "1001")
    private Integer goodsId;

    @TableField("goodsQuantity")
    @ApiModelProperty(value = "商品数量", example = "100")
    private Integer goodsQuantity;

    @TableField("quantityByName")
    @ApiModelProperty(value = "按商品名称分组的数量, 该属性可以弃用,以后端操作实现", example = "1")
    private  Integer quantityByName;
}
