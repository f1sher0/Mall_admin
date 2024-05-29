package com.trade.demo.controller;

import com.trade.demo.common.Result;
import com.trade.demo.entity.Announcement;
import com.trade.demo.entity.Goods;
import com.trade.demo.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("/add")
    public Result addAnnouncement(@RequestBody Announcement announcement) {
        boolean isSaved = announcementService.save(announcement);
        if (isSaved) {
            return Result.success(announcement);
        } else {
            return Result.error("Failed to add announcement");
        }
    }

    @GetMapping("/list")
    public Result listAnnouncements() {
        List<Announcement> announcements = announcementService.list();
        return Result.success(announcements);
    }
    @GetMapping("/get")
    public Result getAnnouncementById(@RequestParam Integer id) {
        Announcement announcement = announcementService.getById(id);
        if(announcement != null){
            return Result.success(announcement);
        }else{
            return Result.error("announcement not found");
        }

    }
    @PutMapping("/update")
    public Result updateAnnouncement(@RequestBody Announcement announcement) {
        boolean isUpdated = announcementService.updateById(announcement);
        if (isUpdated) {
            return Result.success(announcement);
        } else {
            return Result.error("Failed to update announcement");
        }
    }

    @DeleteMapping("/delete")
    public Result deleteAnnouncement(@RequestParam Integer id) {
        boolean isRemoved = announcementService.removeById(id);
        if (isRemoved) {
            return Result.success("Announcement deleted successfully");
        } else {
            return Result.error("Failed to delete announcement");
        }
    }
}
