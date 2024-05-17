package com.trade.demo.entity;
import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "t_admin", description = "管理员信息")
public class Admins implements Serializable {
    private static final long serialVersionUID = 1L;

    private String adminuserId;
    private String adminName;
    private String loginName;
    private String password;
    private String createby;
    private Date updateTime;
    private String updateby;
    private Date lastloginTime;
    private Date createTime;
    private String status;
    private String statusDesc;
    private String avatar;
    private String email;
}
