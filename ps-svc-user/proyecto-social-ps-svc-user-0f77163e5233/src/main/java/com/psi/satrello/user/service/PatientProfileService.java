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
public class PatientProfileService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TherapistPatientRepository therapistPatientRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private ActivityRepository activityRepository;

    private Account account;

    public PatientPersonalInfo getPersonalInfo(String personalId) {
        Optional<Account> optAccount = accountRepository.findByPersonalId(personalId);

        if (optAccount.isPresent()) {
            account = optAccount.get();
            Integer age = null;
            if (account.getBirthDate() != null){
                age = Period.between(
                        account.getBirthDate().toLocalDate(),
                        LocalDate.now()).getYears();
            }

            return new PatientPersonalInfo(
                    account.getName(),
                    age,
                    account.getBirthDate(),
                    account.getGuardianName(),
                    account.getPhone(),
                    account.getEmail(),
                    account.getAvatarUrl()
            );
        }

        return null;
    }

    public PatientHistory getHistory(String personalId) {

        if (account == null) {
            throw new RuntimeException("Account cannot be null in patient profile service.");
        }

        Integer stateId = account.getStateId();
        Date createdDate = account.getCreatedDate();

        List<TherapistPatient> therapistPatients = therapistPatientRepository.findAllByPatientId(personalId);

        List<PatientTherapistsInfo> therapists = new ArrayList<>();

        for (TherapistPatient T: therapistPatients) {

            Optional<String> optTherapistName = accountRepository.findNameByPersonalId(T.getTherapist_id());

            if (optTherapistName.isPresent()) {
                therapists.add(new PatientTherapistsInfo(optTherapistName.get()));
            } else {
                log.error("Couldn't find the name of the therapist with id = " + T.getTherapist_id());
            }

        }

        return new PatientHistory(
                createdDate,
                stateRepository.getNameByStateId(stateId),
                therapists);
    }

    public List<PatientActivity> getActivities(String personalId) {

        if (account == null) {
            throw new RuntimeException("Account cannot be null in patient profile service.");
        }

        List<Activity> allActivities = activityRepository.findAllByPatientId(personalId);

        List<PatientActivity> activities = new ArrayList<>();

        for (Activity A: allActivities) {

            PatientActivity patientActivity = new PatientActivity(
                    A.getName(),
                    A.getStartDate(),
                    A.getLastAccess(),
                    A.getProgress()
            );

            activities.add(patientActivity);

        }


        return activities;
    }

    public PatientProfileResponse getProfile(String personalId) {

        PatientPersonalInfo personalInfo = getPersonalInfo(personalId);

        PatientHistory history = getHistory(personalId);

        List<PatientActivity> activities = getActivities(personalId);

        return new PatientProfileResponse(
                personalInfo,
                history,
                activities
        );

    }

}
