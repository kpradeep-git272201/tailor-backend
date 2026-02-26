package com.tailorapp.catalog.fabric_category.entity;

import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fabric_categories", schema = DatabaseConstants.TAILOR)
public class FabricCategory {
    @Id
    @Column(name = "fabric_category_id")
    private Long fabricCategoryId;
    private String name;
    @Column(name ="image_path")
    private String imagePath;
}
