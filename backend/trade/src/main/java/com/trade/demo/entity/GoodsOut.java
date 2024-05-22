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
@TableName(value = "goodsout")

@ApiModel(value = "GoodsOut", description = "销售")
public class GoodsOut implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "salesId", type = IdType.AUTO)
    @ApiModelProperty(value = "销售单ID")
    private Integer salesId;

    @TableField("salesNo")
    @ApiModelProperty(value = "销售单编号")
    private String salesNo;

    @TableField("purchaserId")
    @ApiModelProperty(value = "采购商ID")
    private Integer purchaserId;

    @TableField("purchaserName")
    @ApiModelProperty(value = "采购商名称")
    private String purchaserName;

    @TableField("goodsPrice")
    @ApiModelProperty(value = "销售商品单价")
    private Double goodsPrice;

    @TableField("goodsAmount")
    @ApiModelProperty(value = "销售商品总金额")
    private Double goodsAmount;

    @TableField("salesTime")
    @ApiModelProperty(value = "商品销售时间")
    private Date salesTime;

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

//    @TableField("createTime")
//    @ApiModelProperty(value = "创建时间")
//    private Date createTime;

//    @TableField("updateTime")
//    @ApiModelProperty(value = "更新时间")
//    private Date updateTime;
}
