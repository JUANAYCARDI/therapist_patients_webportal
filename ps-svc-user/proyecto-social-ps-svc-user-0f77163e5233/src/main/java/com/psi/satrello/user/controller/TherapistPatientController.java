package com.psi.satrello.user.controller;

import com.psi.satrello.user.entity.Account;
import com.psi.satrello.user.service.TherapistPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class TherapistPatientController {

    @Autowired
    private TherapistPatientService therapistPatientService;

    @GetMapping("/all/{id}")
    public List<Account> getAllPatientsFromTherapistByPersonalId(@PathVariable("id") String therapist_id){

        return therapistPatientService.getAllPatientsFromTherapistByPersonalId(therapist_id);
    }
}
