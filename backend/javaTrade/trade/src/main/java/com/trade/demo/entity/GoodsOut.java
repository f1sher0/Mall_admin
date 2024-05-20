package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "GoodsOut", description = "销售")
public class GoodsOut implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "salesId", type = IdType.AUTO)
    @ApiModelProperty(value = "销售单ID")
    private Integer salesId;

    @ApiModelProperty(value = "销售单号")
    private String salesNo;

    @ApiModelProperty(value = "采购商ID")
    private Integer purchaserId;

    @ApiModelProperty(value = "采购商名称")
    private String purchaserName;

    @ApiModelProperty(value = "销售价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "销售金额")
    private BigDecimal goodsAmount;

    @ApiModelProperty(value = "销售时间")
    private Date salesTime;

    @ApiModelProperty(value = "仓库ID")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "操作人ID")
    private Integer operatorId;

    @ApiModelProperty(value = "操作人名称")
    private String operatorName;

    @ApiModelProperty(value = "备注")
    private String remark;
}
