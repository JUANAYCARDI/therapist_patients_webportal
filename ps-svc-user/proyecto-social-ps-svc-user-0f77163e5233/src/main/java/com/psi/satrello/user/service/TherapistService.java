package com.psi.satrello.user.service;

import com.psi.satrello.user.entity.Account;
import com.psi.satrello.user.repository.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TherapistService {

    @Autowired
    private TherapistRepository therapistRepository;

    public Account getTherapistByUserId(UUID therapistId) {
        return therapistRepository.findByUserId(therapistId).orElse(null);
    }

    public Account getTherapistByPersonalId(String personalId) {
        return therapistRepository.findByPersonalId(personalId).orElse(null);
    }

    public List<Optional<Account>> getAllAccountsByRoleId(Integer roleId) {
        return therapistRepository.findAllByRoleId(roleId);
    }
}
