package com.tailorapp.catalog.fabric.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fabric_colors", schema = "tailor")
@Getter @Setter
public class FabricColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private Integer colorId;

    @Column(name = "color_name")
    private String colorName;

    @Column(name = "hex_code")
    private String hexCode;

    @Column(name = "color_image")
    private String colorImage;
}
