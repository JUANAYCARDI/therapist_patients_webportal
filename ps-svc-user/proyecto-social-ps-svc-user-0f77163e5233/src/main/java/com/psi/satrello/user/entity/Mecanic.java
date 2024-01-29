package com.psi.satrello.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "mecanic", schema = "activity")
public class Mecanic {
    @Id
    @Column(name = "mecanic_id", updatable = false)
    private int mecanicId;
    @Column(name = "value", updatable = false)
    private String value;

    public Mecanic() {
    }

    public Mecanic(int mecanicId, String value) {
        this.mecanicId = mecanicId;
        this.value = value;
    }
}
