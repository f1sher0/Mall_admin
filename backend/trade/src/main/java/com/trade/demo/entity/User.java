package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "User", description = "用户信息")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "userId", type = IdType.AUTO)
    @ApiModelProperty(value = "用户ID", example = "1")
    private Integer userId;

    @ApiModelProperty(value = "用户名", example = "johndoe")
    private String username;

    @ApiModelProperty(value = "密码", example = "password123")
    private String password;

    @ApiModelProperty(value = "性别", example = "男")
    private String gender;

    @ApiModelProperty(value = "年龄", example = "30")
    private Integer age;

    @ApiModelProperty(value = "联系电话", example = "12345678901")
    private String phone;

    @ApiModelProperty(value = "邮箱", example = "johndoe@example.com")
    private String email;

    @ApiModelProperty(value = "角色", example = "管理员")
    private String role;

    @ApiModelProperty(value = "审核状态", dataType = "char", example = "0", required = false)
    private char status;

    @TableField("createTime")
    @ApiModelProperty(value = "创建时间", example = "2024-05-23 10:00:00")
    private Date createTime;

    @TableField("updateTime")
    @ApiModelProperty(value = "更新时间", example = "2024-05-24 15:00:00")
    private Date updateTime;

    @ApiModelProperty(value = "头像", example = "http://example.com/avatar.jpg")
    private String avatar;
}
