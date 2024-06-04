package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
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
    @ApiModelProperty(value = "销售单ID", example = "1")
    private Integer salesId;

    @TableField("salesNo")
    @ApiModelProperty(value = "销售单编号", example = "SO20240523001")
    private String salesNo;

    @TableField("purchaserId")
    @ApiModelProperty(value = "采购商ID", example = "2")
    private Integer purchaserId;

    @TableField("purchaserName")
    @ApiModelProperty(value = "采购商名称", example = "华纳电子信息公司")
    private String purchaserName;

    @TableField("goodsPrice")
    @ApiModelProperty(value = "销售商品单价", example = "3500.00")
    private String goodsPrice;

    @TableField("goodsAmount")
    @ApiModelProperty(value = "销售商品总金额", example = "70000.00")
    private Double goodsAmount;

    @TableField("salesTime")
    @ApiModelProperty(value = "商品销售时间", example = "2024-05-23 10:00:00")
    private Date salesTime;

    @TableField("warehouseId")
    @ApiModelProperty(value = "仓库ID", example = "1")
    private String warehouseId;

    @TableField("warehouseName")
    @ApiModelProperty(value = "仓库名称", example = "北京仓库")
    private String warehouseName;

    @TableField("operatorId")
    @ApiModelProperty(value = "操作员ID", example = "1")
    private Integer operatorId;

    @TableField("operatorName")
    @ApiModelProperty(value = "操作员名称", example = "操作员李四")
    private String operatorName;

    @TableField("remark")
    @ApiModelProperty(value = "备注", example = "本次销售包含优惠")
    private String remark;

    // @TableField("createTime")
    // @ApiModelProperty(value = "创建时间")
    // private Date createTime;

    // @TableField("updateTime")
    // @ApiModelProperty(value = "更新时间")
    // private Date updateTime;
}
