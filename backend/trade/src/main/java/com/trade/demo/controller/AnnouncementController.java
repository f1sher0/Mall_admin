package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.Announcement;
import com.trade.demo.service.AnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
@Api(tags = "公告管理")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("/add")
    @ApiOperation(value = "添加公告")
    public Result addAnnouncement(@RequestBody Announcement announcement) {
        boolean isSaved = announcementService.save(announcement);
        if (isSaved) {
            return Result.success(announcement);
        } else {
            return Result.error("Failed to add announcement");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有公告")
    public Result listAnnouncements() {
        List<Announcement> announcements = announcementService.list();
        return Result.success(announcements);
    }

    @GetMapping("/get")
    @ApiOperation(value = "根据ID获取公告")
    public Result getAnnouncementById(@RequestParam Integer id) {
        Announcement announcement = announcementService.getById(id);
        if (announcement != null) {
            return Result.success(announcement);
        } else {
            return Result.error("Announcement not found");
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "根据ID更新公告")
    public Result updateAnnouncement(@RequestBody Announcement announcement) {
        boolean isUpdated = announcementService.updateById(announcement);
        if (isUpdated) {
            return Result.success(announcement);
        } else {
            return Result.error("Failed to update announcement");
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据ID删除公告")
    public Result deleteAnnouncement(@RequestParam Integer id) {
        boolean isRemoved = announcementService.removeById(id);
        if (isRemoved) {
            return Result.success("Announcement deleted successfully");
        } else {
            return Result.error("Failed to delete announcement");
        }
    }
}
