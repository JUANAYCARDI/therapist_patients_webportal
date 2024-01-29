package com.psi.satrello.user.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "therapist_patient", schema = "account")
public class TherapistPatient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "therapist_patient_id")
    private UUID id;

    @Column(name = "therapist_id")
    private String therapist_id;
    @Column(name = "patient_id")
    private String patient_id;

    public TherapistPatient() {
    }

    public TherapistPatient(String therapist_id, String patient_id) {
        this.therapist_id = therapist_id;
        this.patient_id = patient_id;
    }

    public UUID getId() {
        return id;
    }

    public String getTherapist_id() {
        return therapist_id;
    }

    public void setTherapist_id(String therapist_id) {
        this.therapist_id = therapist_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }
}
