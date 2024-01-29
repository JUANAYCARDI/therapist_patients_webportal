package com.psi.satrello.user.service;

import com.psi.satrello.user.entity.Account;
import com.psi.satrello.user.repository.TherapistPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TherapistPatientService {
    @Autowired
    private TherapistPatientRepository therapistPatientRepository;

    public List<Account> getAllPatientsFromTherapistByPersonalId(String therapist_personal_id) {
        return therapistPatientRepository.getAllPatientsFromTherapistByPersonalId(therapist_personal_id);
    }

}
