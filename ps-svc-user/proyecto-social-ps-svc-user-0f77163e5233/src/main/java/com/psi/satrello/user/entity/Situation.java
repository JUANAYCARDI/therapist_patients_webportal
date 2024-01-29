package com.psi.satrello.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "situation", schema = "activity")
public class Situation {
    @Id
    @Column(name = "situation_id", updatable = false)
    private int situationId;
    @Column(name = "value", updatable = false)
    private String value;
    @Column(name = "image", updatable = false)
    private String image;

    public Situation() {
    }

    public Situation(int situationId, String value, String image) {
        this.situationId = situationId;
        this.value = value;
        this.image = image;
    }
}
