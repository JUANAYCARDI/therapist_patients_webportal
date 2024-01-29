package com.psi.satrello.user.service;

import com.psi.satrello.user.entity.*;
import com.psi.satrello.user.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Map<String, List<?>> getActivitiesOptions() {
        List<Mecanic> mecanic = activityRepository.findAllMecanics();
        List<Category> category = activityRepository.findAllCategory();
        List<SubCategory> subCategory = activityRepository.findAllSubCategory();
        List<Situation> situation = activityRepository.findAllSituation();

        Map<String, List<?>> resultMap = new HashMap<>();
        resultMap.put("mecanic", mecanic);
        resultMap.put("category", category);
        resultMap.put("subCategory", subCategory);
        resultMap.put("situation", situation);


        return resultMap;
    }
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }
}
