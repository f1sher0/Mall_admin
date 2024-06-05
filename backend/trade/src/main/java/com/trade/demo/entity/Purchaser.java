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
@ApiModel(value = "Purchaser", description = "采购商信息")
public class Purchaser implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("purchaserId")
    @TableId(value = "purchaserId", type = IdType.AUTO)
    @ApiModelProperty(value = "采购商ID", example = "1")
    private Integer purchaserId;

    @TableField("purchaserNo")
    @ApiModelProperty(value = "采购商编号", example = "PUR001")
    private String purchaserNo;

    @TableField("purchaserName")
    @ApiModelProperty(value = "采购商名称", example = "华纳电子信息公司")
    private String purchaserName;

    @TableField("purchaserDesc")
    @ApiModelProperty(value = "采购商描述", example = "华纳电子信息公司是一家主要从事电子产品采购的公司")
    private String purchaserDesc;

    @TableField("loginName")
    @ApiModelProperty(value = "登录名", example = "huawei_user")
    private String loginName;

    @ApiModelProperty(value = "密码", example = "password123")
    private String password;

    @ApiModelProperty(value = "联系电话", example = "12345678901")
    private String telephone;

    @ApiModelProperty(value = "邮编", example = "100000")
    private String zip;

    @ApiModelProperty(value = "地址", example = "北京市海淀区中关村")
    private String address;

    @ApiModelProperty(value = "邮箱", example = "purchaser@example.com")
    private String email;

    @ApiModelProperty(value = "审核状态", example = "1")
    private String status;

    @ApiModelProperty(value = "头像", example = "http://example.com/avatar.jpg")
    private String avatar;
}
