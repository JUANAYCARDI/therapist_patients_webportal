package com.psi.satrello.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientHistory {

    private Date sinceDate;
    private String status;
    private List<PatientTherapistsInfo> therapists;

}
