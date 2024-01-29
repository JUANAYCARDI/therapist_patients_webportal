package com.psi.satrello.user.controller;

import com.psi.satrello.user.entity.Activity;
import com.psi.satrello.user.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping()
    public Map<String, List<?>> getActivitiesOptions() {
        return activityService.getActivitiesOptions();
    }

    @GetMapping("/all")
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @PostMapping("/add")
    public Activity addActivity(@RequestBody Activity activity) {return activityService.addActivity(activity);}
}
