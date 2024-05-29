package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "Announcement", description = "公告信息")
public class Announcement implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "announcementId", type = IdType.AUTO)
    @ApiModelProperty(value = "公告ID", example = "1")
    private Integer announcementId;

    @TableField("title")
    @ApiModelProperty(value = "公告标题", example = "系统维护通知")
    private String title;

    @TableField("content")
    @ApiModelProperty(value = "公告内容", example = "系统将于2024年5月30日凌晨进行维护，届时可能会影响系统使用。")
    private String content;

    @TableField("publisherEmail")
    @ApiModelProperty(value = "发布者的邮箱", example = "admin@example.com")
    private String publisherEmail;

    @TableField("createTime")
    @ApiModelProperty(value = "创建时间", example = "2024-05-23 10:00:00")
    private Date createTime;

    @TableField("updateTime")
    @ApiModelProperty(value = "更新时间", example = "2024-05-24 15:00:00")
    private Date updateTime;
}
