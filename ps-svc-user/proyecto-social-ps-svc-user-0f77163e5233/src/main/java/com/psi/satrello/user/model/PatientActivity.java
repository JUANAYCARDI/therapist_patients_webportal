package com.psi.satrello.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientActivity {

    private String activityTitle;
    private Date startDate;
    private Date lastAccessDate;
    private Integer progress;

}
