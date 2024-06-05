package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "Goods", description = "商品信息")
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "goodsId", type = IdType.AUTO)
    @ApiModelProperty(value = "商品ID", example = "1")
    private Integer goodsId;

    @TableField("goodsName")
    @ApiModelProperty(value = "商品名称", example = "智能手机")
    private String goodsName;

    @TableField("goodsCategory")
    @ApiModelProperty(value = "商品分类", example = "电子产品")
    private String goodsCategory;

    @TableField("purchasePrice")
    @ApiModelProperty(value = "进货价格", example = "3000.00")
    private Double purchasePrice;

    @TableField("sellingPrice")
    @ApiModelProperty(value = "销售价格", example = "3500.00")
    private Double sellingPrice;

    @TableField("createTime")
    @ApiModelProperty(value = "创建时间", example = "2024-05-23 10:00:00")
    private Date createTime;

    @TableField("updateTime")
    @ApiModelProperty(value = "更新时间", example = "2024-05-24 15:00:00")
    private Date updateTime;

    @TableField("onShelf")
    @ApiModelProperty(value = "是否在货架", allowableValues = "range[0,1]", example = "1")
    private Integer onShelf;

    @TableField("warehouseId")
    @ApiModelProperty(value = "仓库ID", example = "1")
    private Integer warehouseId ;
}
