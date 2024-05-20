package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value = "Purchaser", description = "采购商信息")
public class Purchaser implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "purchaserId", type = IdType.AUTO)
    @ApiModelProperty(value = "采购商ID")
    private Integer purchaserId;

    @ApiModelProperty(value = "采购商编号")
    private String purchaserNo;

    @ApiModelProperty(value = "采购商名称")
    private String purchaserName;

    @ApiModelProperty(value = "采购商描述")
    private String purchaserDesc;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "联系电话")
    private String telephone;

    @ApiModelProperty(value = "邮编")
    private String zip;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "头像")
    private String avatar;
}
