package com.trade.demo.entity;


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
@TableName("emps") // 指定数据库表名
@ApiModel(value = "Emps对象", description = "员工信息")
public class Emps implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工姓名")
    @Alias("员工姓名")
    private String name;

    @ApiModelProperty(value = "员工所在部门")
    @Alias("员工所在部门")
    private String dept;

    @ApiModelProperty(value = "员工工作或管理的仓库")
    @Alias("员工工作或管理的仓库")
    private Integer manageId;
    @ApiModelProperty(value = "员工密码")
    @Alias("密码")
    private String password;
}