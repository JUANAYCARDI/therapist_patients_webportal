package com.psi.satrello.user.repository;

import com.psi.satrello.user.entity.Account;
import com.psi.satrello.user.entity.TherapistPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TherapistPatientRepository extends JpaRepository<TherapistPatient, UUID> {

    @Query("SELECT a FROM TherapistPatient tp INNER JOIN Account a ON tp.patient_id = a.personalId WHERE tp.therapist_id = ?1")
    List<Account> getAllPatientsFromTherapistByPersonalId(String therapist_personal_id);

    @Query("SELECT tp FROM TherapistPatient tp WHERE tp.patient_id = ?1")
    List<TherapistPatient> findAllByPatientId(String patient_id);


}