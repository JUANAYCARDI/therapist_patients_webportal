package com.psi.satrello.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "patient_activity", schema = "activity")
public class Activity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "patient_activity_id", columnDefinition = "uuid", updatable = false)
    private UUID patient_activity_id;

    @Column(name = "patient_id", updatable = false, nullable = false)
    private String patientId;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "last_acess", nullable = false)
    private Date lastAccess;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "progress")
    private int progress;

    @Column(name = "description")
    private String description;

    @Column(name = "category", nullable = false)
    private int category;

    @Column(name = "subcategory", nullable = false)
    private int subCategory;

    @Column(name = "mecanic", nullable = false)
    private int mecanic;

    @Column(name = "situation", nullable = false)
    private int situation;

    @Column(name = "verbal_time", nullable = false)
    private String verbalTime;

    @Column(name = "reading_process")
    private Boolean readingProcess;

    public Activity() {
    }

    public Activity(String name, String description, Date start_date) {
        this.name = name;
        this.description = description;
        this.startDate = start_date;
    }

    public Activity(String patient_id, Date start_date, Date last_access, String name, int progress, String description, String verbal_time, Boolean reading_process, int situation, int mecanic, int subCategory, int category) {
        this.patientId = patient_id;
        this.startDate = start_date;
        this.lastAccess = last_access;
        this.name = name;
        this.progress = progress;
        this.description = description;
        this.verbalTime = verbal_time;
        this.readingProcess = reading_process;
        this.situation = situation;
        this.mecanic = mecanic;
        this.category = category;
        this.subCategory = subCategory;
    }
}
