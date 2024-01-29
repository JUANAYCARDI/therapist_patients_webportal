package com.psi.satrello.user.service;

import com.psi.satrello.user.entity.Account;
import com.psi.satrello.user.entity.Activity;
import com.psi.satrello.user.entity.TherapistPatient;
import com.psi.satrello.user.model.*;
import com.psi.satrello.user.repository.AccountRepository;
import com.psi.satrello.user.repository.ActivityRepository;
import com.psi.satrello.user.repository.StateRepository;
import com.psi.satrello.user.repository.TherapistPatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class PatientService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TherapistPatientRepository therapistPatientRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private ActivityRepository activityRepository;

    public List<Optional<Activity>> getActivities(String personalId) {

        List<Optional<Activity>> activities = activityRepository.findAllByPersonalId(personalId);

        return activities;
    }
}
