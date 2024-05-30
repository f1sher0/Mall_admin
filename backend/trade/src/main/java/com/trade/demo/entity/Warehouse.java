package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Warehouse", description = "仓库信息")
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "warehouseId", type = IdType.AUTO)
    @ApiModelProperty(value = "仓库ID", example = "1")
    private Integer warehouseId;

    @TableField("warehouseName")
    @ApiModelProperty(value = "仓库名称", example = "北京仓库")
    private String warehouseName;

    @TableField("warehouseLocation")
    @ApiModelProperty(value = "仓库位置", example = "北京市海淀区")
    private String warehouseLocation;

    @TableField("totalCapacity")
    @ApiModelProperty(value = "总容量", example = "10.00")
    private Double totalCapacity;

    @TableField("availableCapacity")
    @ApiModelProperty(value = "可用容量", example = "10.00")
    private Double availableCapacity;

    @ApiModelProperty(value = "审核状态", example = "1")
    private char status;
}
