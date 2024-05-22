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
    @ApiModelProperty(value = "公告ID")
    private Integer announcementId;

    @TableField("title")
    @ApiModelProperty(value = "公告标题")
    private String title;

    @TableField("content")
    @ApiModelProperty(value = "公告内容")
    private String content;

    @TableField("publisherEmail")
    @ApiModelProperty(value = "发布者的邮箱")
    private String publisherEmail;

    @TableField("createTime")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField("updateTime")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
