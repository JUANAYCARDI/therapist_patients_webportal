package com.psi.satrello.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientProfileResponse {

    private PatientPersonalInfo personalInfo;

    private PatientHistory history;

    private List<PatientActivity> activities;

}
