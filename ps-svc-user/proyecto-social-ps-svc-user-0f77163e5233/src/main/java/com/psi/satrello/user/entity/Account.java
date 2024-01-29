package com.psi.satrello.user.entity;

import java.sql.Date;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


// Entity with the data required to create a new user account in the database
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "user_account", schema = "account")
@Data
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "user_id", columnDefinition = "uuid", updatable = false)
    private UUID userId;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "personal_id")
    private String personalId;
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "state_id")
    private Integer stateId;
    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;
    @Column(name = "birthdate")
    private Date birthDate;
    @Column(name = "legal_guardian")
    private String guardianName;
    
    @JsonIgnore
    @OneToOne(mappedBy = "account", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
    @JoinColumn(name = "personal_id", referencedColumnName = "personal_id", unique = true)
    public Login login;

    // Generic Constructor
    public Account(UUID userId, String name, String username, String personal_id, Long roleId, String phone,
            String email, String avatarUrl, Integer stateId) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.personalId = personal_id;
        this.roleId = roleId;
        this.phone = phone;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.stateId = stateId;
    }

    // Custom Constructor for retrieving relevant data of a patient
    public Account(String name, String avatarUrl, Date createdDate) {
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.createdDate = createdDate;
    }

}