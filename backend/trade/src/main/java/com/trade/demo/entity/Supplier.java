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
    @ApiModelProperty(value = "供应商ID")
    private Integer supplierId;

    @TableField("supplierNo")
    @ApiModelProperty(value = "供应商编号")
    private String supplierNo;

    @TableField("supplierName")
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @TableField("supplierDesc")
    @ApiModelProperty(value = "供应商描述")
    private String supplierDesc;

    @TableField("loginName")
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
