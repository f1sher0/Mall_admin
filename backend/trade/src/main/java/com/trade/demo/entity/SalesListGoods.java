package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SalesListGoods", description = "销售单商品")
public class SalesListGoods implements Serializable {
    private static final long serialVersionUID = 1L;
   @TableId(value="salesListGoodsId" , type = IdType.AUTO)
    @ApiModelProperty(value = "销售单ID")
    private Integer salesListGoodsId;
    @TableField("salesId")
    @ApiModelProperty(value = "销售ID")
    private Integer salesId;
    @TableField("goodsId")
    @ApiModelProperty(value = "商品ID")
    private Integer goodsId;
}
