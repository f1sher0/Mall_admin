package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value = "Goods", description = "商品信息")
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "goodsId", type = IdType.AUTO)
    @ApiModelProperty(value = "商品ID")
    private Integer goodsId;
    @TableField("goodsName")
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    @TableField("goodsCategory")
    @ApiModelProperty(value = "商品分类")
    private String goodsCategory;
    @TableField("purchasePrice")
    @ApiModelProperty(value = "进货价格")
    private BigDecimal purchasePrice;
    @TableField("sellingPrice")
    @ApiModelProperty(value = "销售价格")
    private BigDecimal sellingPrice;
    @TableField("createTime")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @TableField("updateTime")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
