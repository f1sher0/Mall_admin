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
@ApiModel(value = "GoodsIn", description = "商品入库")
public class GoodsIn implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "goodsInId", type = IdType.AUTO)
    @ApiModelProperty(value = "入库单ID")
    private Integer goodsInId;

    @ApiModelProperty(value = "入库单号")
    private String goodsInNo;

    @ApiModelProperty(value = "供应商ID")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty(value = "入库价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "入库金额")
    private BigDecimal goodsAmount;

    @ApiModelProperty(value = "入库时间")
    private Date goodsInTime;

    @ApiModelProperty(value = "入库仓库ID")
    private Integer warehouseId;

    @ApiModelProperty(value = "入库仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "操作人ID")
    private Integer operatorId;

    @ApiModelProperty(value = "操作人名称")
    private String operatorName;

    @ApiModelProperty(value = "备注")
    private String remark;
}
