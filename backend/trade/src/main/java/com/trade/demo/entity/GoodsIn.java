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
@AllArgsConstructor@TableName(value = "goodsin")
@ApiModel(value = "GoodsIn", description = "商品入库")
public class GoodsIn implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "goodsInId", type = IdType.AUTO)
    @ApiModelProperty(value = "入库单ID", example = "1")
    private Integer goodsInId;

    @TableField("goodsInNo")
    @ApiModelProperty(value = "入库商品编号,以逗号分隔,后三位为有效数字", example = "GIN001,GIN003")
    private String goodsInNo  ;

    @TableField("supplierId")
    @ApiModelProperty(value = "供应商ID", example = "1")
    private Integer supplierId = 2;

    @TableField("supplierName")
    @ApiModelProperty(value = "供应商名称", example = "华纳电子信息公司")
    private String supplierName = "华纳电子信息公司";

    @TableField("goodsName")
    @ApiModelProperty(value = "入库商品的名称,以逗号分隔", example = "平板,商品C")
    private String goodsName = "商品A,商品C";

    @TableField("goodsPrice")
    @ApiModelProperty(value = "入库商品的单价,以逗号分隔", example = "5000.00,8000.00")
    private String goodsPrice = "5000.00,8000.00";

    @TableField("goodsAmount")
    @ApiModelProperty(value = "入库商品总金额", example = "50000.00")
    private Double goodsAmount = 50000.00;

    @TableField("goodsInTime")
    @ApiModelProperty(value = "商品入库时间", example = "2024-05-23 10:00:00")
    private Date goodsInTime = new Date(); // 使用当前时间作为默认值

    @TableField("warehouseId")
    @ApiModelProperty(value = "仓库ID", example = "1")
    private Integer warehouseId = 1;

    @TableField("warehouseName")
    @ApiModelProperty(value = "仓库名称", example = "北京仓库")
    private String warehouseName = "北京仓库";

    @TableField("operatorId")
    @ApiModelProperty(value = "操作员ID", example = "1")
    private Integer operatorId = 1;

    @TableField("operatorName")
    @ApiModelProperty(value = "操作员名称", example = "操作员张三")
    private String operatorName = "操作员张三";

    @TableField("remark")
    @ApiModelProperty(value = "备注", example = "首次入库")
    private String remark = "首次入库";

    @TableField("goodsCategory")
    @ApiModelProperty(value = "入库商品的分类,以逗号分隔", example = "分类1,分类3")
    private String goodsCategory = "分类1,分类3";

}
