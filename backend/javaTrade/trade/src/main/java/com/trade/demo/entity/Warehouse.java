package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    @ApiModelProperty(value = "仓库ID")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "仓库位置")
    private String warehouseLocation;

    @ApiModelProperty(value = "总容量")
    private BigDecimal totalCapacity;

    @ApiModelProperty(value = "可用容量")
    private BigDecimal availableCapacity;
}