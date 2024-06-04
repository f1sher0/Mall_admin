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
@ApiModel(value = "Supplier", description = "供应商信息")
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "supplierId", type = IdType.AUTO)
    @ApiModelProperty(value = "供应商ID", example = "1")
    private Integer supplierId;

    @TableField("supplierNo")
    @ApiModelProperty(value = "供应商编号", example = "SUP001")
    private String supplierNo;

    @TableField("supplierName")
    @ApiModelProperty(value = "供应商名称", example = "华纳电子信息公司")
    private String supplierName;

    @TableField("supplierDesc")
    @ApiModelProperty(value = "供应商描述", example = "提供电子元器件的供应商")
    private String supplierDesc;

    @TableField("loginName")
    @ApiModelProperty(value = "登录名", example = "supplier_user")
    private String loginName;

    @ApiModelProperty(value = "密码", example = "password123")
    private String password;

    @ApiModelProperty(value = "联系电话", example = "12345678901")
    private String telephone;

    @ApiModelProperty(value = "邮编", example = "100000")
    private String zip;

    @ApiModelProperty(value = "地址", example = "北京市海淀区中关村")
    private String address;

    @ApiModelProperty(value = "邮箱", example = "supplier@example.com")
    private String email;

<<<<<<< HEAD
    @ApiModelProperty(value = "审核状态")
    private char status;
=======
    @TableField("status")
    @ApiModelProperty(value = "审核状态", example = "1")
    private String status;
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a

    @ApiModelProperty(value = "头像", example = "http://example.com/avatar.jpg")
    private String avatar;
}