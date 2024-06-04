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
@TableName(value = "inlistgoods")
@ApiModel(value = "InListGoods", description = "入库单商品")
public class InListGoods implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("inListGoodsId")
    @TableId(value = "inListGoodsId", type = IdType.AUTO)
    @ApiModelProperty(value = "入库单ID", example = "1")
    private Integer inListGoodsId;

    @TableField("goodsInId")
    @ApiModelProperty(value = "入库ID", example = "1")
    private Integer goodsInId;

    @TableField("goodsId")
    @ApiModelProperty(value = "商品ID", example = "1001")
    private Integer goodsId;
<<<<<<< HEAD
    @TableField("isReturned")
    @ApiModelProperty(value = "是否退货")
=======

    @TableField("isReturned")
    @ApiModelProperty(value = "是否退货", example = "0")
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
    private IsReturned isReturned;
}
