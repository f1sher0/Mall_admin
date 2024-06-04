package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "saleslistgoods")
public class SalesListGoods implements Serializable {
 private static final long serialVersionUID = 1L;

<<<<<<< HEAD
    @ApiModelProperty(value = "销售单ID")
    private Integer salesListGoodsId;
    @TableField("salesId")
    @ApiModelProperty(value = "销售ID")
    private Integer salesId;
    @TableField("goodsId")
    @ApiModelProperty(value = "商品ID")
    private Integer goodsId;
    @TableField("isReturned")
    @ApiModelProperty(value = "是否退货")
    private IsReturned isReturned;
=======
 @TableId(value = "salesListGoodsId", type = IdType.AUTO)
 @ApiModelProperty(value = "销售单ID", example = "1")
 private Integer salesListGoodsId;

 @TableField("salesId")
 @ApiModelProperty(value = "销售ID", example = "1")
 private Integer salesId;

 @TableField("goodsId")
 @ApiModelProperty(value = "商品ID", example = "1001")
 private Integer goodsId;

 @TableField("isReturned")
 @ApiModelProperty(value = "是否退货" )
 private IsReturned isReturned;
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
}
