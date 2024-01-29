package com.psi.satrello.user.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity with the data required to create a new login access in the database 
@Entity
@Table(name = "user_login", schema = "login")
@Data
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "login_id", columnDefinition = "uuid", updatable = false)
    private UUID loginId;
    @Column(name = "personal_id", insertable = false, updatable = false)
    private String personalId;
    private String password;

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "personal_id", referencedColumnName = "personal_id")
    private Account account;

    // Generic Constructor
    public Login(UUID loginId, String personalId, String password) {
        this.loginId = loginId;
        this.personalId = personalId;
        this.password = password;
    }

}