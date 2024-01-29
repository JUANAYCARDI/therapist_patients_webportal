package com.psi.satrello.user.controller;

import com.psi.satrello.user.entity.Account;
import com.psi.satrello.user.exception.*;
import com.psi.satrello.user.model.AuthResponse;
import com.psi.satrello.user.service.TherapistService;
import com.psi.satrello.user.util.TherapistValidator;
import com.psi.satrello.user.util.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/* Controller that handles the /therapist endpoint */
@RestController
@RequestMapping("/therapist")
public class TherapistController {
    @Autowired
    private TherapistService therapistService;
    @Autowired
    private TokenValidator tokenValidator;
    @Autowired
    private TherapistValidator therapistValidator;
    private static final int PATIENT_ROLE_ID = 3;

    @GetMapping("/uuid/{id}")
    public Account getTherapistById(@RequestHeader(value = "Authorization", required = false) String tokenHeader,
                                    @PathVariable(value = "id") String therapistString) {
        UUID therapistId;
        try {
            therapistId = UUID.fromString(therapistString);
        }
        catch (IllegalArgumentException ex) {
            throw new InvalidUUIDException("The provided UUID is not valid", 400);
        }

        Account therapist = therapistService.getTherapistByUserId(therapistId);
        therapistValidator.validate(therapist);

        //Validate the token data with the personal id
        tokenValidator.assertTokenPersonalId(tokenHeader, therapist.getPersonalId());

        return therapist;
    }

    @GetMapping("/personalid/{personalId}")
    public Account getTherapistByPersonalId(@RequestHeader(value = "Authorization", required = false) String tokenHeader,
                                              @PathVariable("personalId") String personalId) {
        tokenValidator.assertTokenPersonalId(tokenHeader, personalId);
        Account therapist = therapistService.getTherapistByPersonalId(personalId);
        therapistValidator.validate(therapist);
        return therapist;
    }

    @GetMapping ("/patients")
    private List<Optional<Account>> getAllPatients(@RequestHeader(value = "Authorization", required = false)
                                                       String tokenHeader){
        AuthResponse authResponse = tokenValidator.validateToken(tokenHeader);
        Account therapist = therapistService.getTherapistByPersonalId(authResponse.getPersonalId());
        therapistValidator.validate(therapist);
        return therapistService.getAllAccountsByRoleId(PATIENT_ROLE_ID);
    }


}
