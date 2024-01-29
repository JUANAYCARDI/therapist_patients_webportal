package com.psi.satrello.user.controller;

import com.psi.satrello.user.entity.Activity;
import com.psi.satrello.user.exception.InvalidTokenException;
import com.psi.satrello.user.service.PatientService;
import com.psi.satrello.user.util.TokenValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private TokenValidator tokenValidator;
    @Autowired
    private PatientService patientService;

    @GetMapping("/home")
    public List<Optional<Activity>> getPatientActivities (
            @RequestHeader(value = "Authorization", required = false) String tokenHeader) {

        String personalId;

        try {
            personalId = tokenValidator.validateToken(tokenHeader).getPersonalId();
            log.info("The personal id is " + personalId);
        } catch ( RuntimeException ex ) {
            log.error(ex.getMessage());
            throw new InvalidTokenException(ex.getMessage(), 401);
        }

        List<Optional<Activity>> patientActivities = patientService.getActivities(personalId);

        return patientActivities;
    }
}
