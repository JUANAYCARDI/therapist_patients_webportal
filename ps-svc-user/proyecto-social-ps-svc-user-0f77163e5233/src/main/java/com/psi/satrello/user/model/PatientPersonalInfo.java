package com.psi.satrello.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientPersonalInfo {

    private String name;
    private Integer age;
    private Date birthdate;
    private String guardianName;
    private String contactNumber;
    private String email;
    private String avatarUrl;

}
