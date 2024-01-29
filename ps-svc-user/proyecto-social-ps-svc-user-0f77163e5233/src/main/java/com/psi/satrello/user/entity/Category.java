package com.psi.satrello.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "semantic_category", schema = "activity")
public class Category {

    @Id
    @Column(name = "category_id", updatable = false)
    private int categoryId;
    @Column(name = "value", updatable = false)
    private String value;
    @Column(name = "image", updatable = false)
    private String image;

    public Category() {
    }

    public Category(int categoryId, String value, String image) {
        this.categoryId = categoryId;
        this.value = value;
        this.image = image;
    }
}
