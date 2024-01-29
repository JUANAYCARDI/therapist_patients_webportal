package com.psi.satrello.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity with the data of the account state of any user
@Entity
@Table(name = "user_state", schema = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class State {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Long stateId;

    @Column(name = "name")
    private String name;

}
