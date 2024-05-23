package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "returnrequest")
@ApiModel(value = "ReturnRequest", description = "退货申请")
public class ReturnRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "requestId", type = IdType.AUTO)
    @ApiModelProperty(value = "退货申请ID")
    private Integer requestId;

    @TableField("submitterName")
    @ApiModelProperty(value = "提交人姓名")
    private String submitterName;

    @TableField("submitTime")
    @ApiModelProperty(value = "提交时间")
    private Date submitTime;

    @TableField("reason")
    @ApiModelProperty(value = "申请理由")
    private String reason;

    @TableField("goodsId")
    @ApiModelProperty(value = "退货商品ID")
    private Integer goodsId;

    @TableField("status")
    @ApiModelProperty(value = "审核状态")
    private String status;

    @TableField("reviewerName")
    @ApiModelProperty(value = "审核人姓名")
    private String reviewerName;

    @TableField("reviewTime")
    @ApiModelProperty(value = "审核时间")
    private Date reviewTime;
}
