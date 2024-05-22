package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "goodsin")
@ApiModel(value = "GoodsIn", description = "商品入库")
public class GoodsIn implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "goodsInId", type = IdType.AUTO)
    @ApiModelProperty(value = "入库单ID")
    private Integer goodsInId;

    @TableField("goodsInNo")
    @ApiModelProperty(value = "入库单编号")
    private String goodsInNo;

    @TableField("supplierId")
    @ApiModelProperty(value = "供应商ID")
    private Integer supplierId;

    @TableField("supplierName")
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @TableField("goodsPrice")
    @ApiModelProperty(value = "入库商品单价")
    private Double goodsPrice;

    @TableField("goodsAmount")
    @ApiModelProperty(value = "入库商品总金额")
    private Double goodsAmount;

    @TableField("goodsInTime")
    @ApiModelProperty(value = "商品入库时间")
    private Date goodsInTime;

    @TableField("warehouseId")
    @ApiModelProperty(value = "仓库ID")
    private Integer warehouseId;

    @TableField("warehouseName")
    @ApiModelProperty(value = "仓库名称")
    private String warehouseName;

    @TableField("operatorId")
    @ApiModelProperty(value = "操作员ID")
    private Integer operatorId;

    @TableField("operatorName")
    @ApiModelProperty(value = "操作员名称")
    private String operatorName;

    @TableField("remark")
    @ApiModelProperty(value = "备注")
    private String remark;


}
