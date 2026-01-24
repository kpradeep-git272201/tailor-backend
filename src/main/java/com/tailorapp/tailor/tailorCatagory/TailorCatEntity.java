package com.tailorapp.tailor.tailorCatagory;


import com.tailorapp.common.constants.DatabaseConstants;
import jakarta.persistence.*;

@Entity
@Table(name = "tailor_categories", schema = DatabaseConstants.TAILOR)
public class TailorCatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(nullable = false, unique = true, length = 10)
    private String categoryCode;

    private String description;
}
