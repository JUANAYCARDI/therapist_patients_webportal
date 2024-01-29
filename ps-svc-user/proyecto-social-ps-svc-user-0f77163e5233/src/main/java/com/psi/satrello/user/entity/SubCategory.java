package com.psi.satrello.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "semantic_subcategory", schema = "activity")
public class SubCategory {
    @Id
    @Column(name = "subcategory_id", updatable = false)
    private int subCategoryId;
    @Column(name = "category", updatable = false)
    private int category;
    @Column(name = "value", updatable = false)
    private String value;
    @Column(name = "image", updatable = false)
    private String image;

    public SubCategory() {
    }

    public SubCategory(int subCategoryId, int category, String value, String image) {
        this.subCategoryId = subCategoryId;
        this.category = category;
        this.value = value;
        this.image = image;
    }
}
