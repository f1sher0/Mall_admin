package com.med2.demo.entity;


import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("medicines") // 指定数据库表名
@ApiModel(value = "Medicines对象", description = "药品信息")
public class Medicines implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id",type = IdType.AUTO)

    private Integer id;

    @ApiModelProperty(value = "国药准字,药品种类id")
    @Alias("国药准字,药品种类id")
    private Integer typeNo;
    @ApiModelProperty(value = "药品名")
    @Alias("药品名")
    private String name;
    @ApiModelProperty(value = "供应商名字")
    @Alias("供应商名字")
    private String supplierName;


    @ApiModelProperty(value = "存储id")
    @Alias("存储id")
    private Integer storageId;

    @ApiModelProperty(value = "药品进价")
    @Alias("进价")
    private Integer price;
    @ApiModelProperty(value = "药品售价")
    @Alias("售价")
    private Integer selling;



//    @ApiModelProperty(value = "药品进价")
//    @Alias("药品进价")
//    private Integer price;
//
//    @ApiModelProperty(value = "药品售价")
//    @Alias("药品售价")
//    private Integer selling;



}