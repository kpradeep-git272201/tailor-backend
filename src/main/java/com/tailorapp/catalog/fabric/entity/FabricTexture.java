package com.tailorapp.catalog.fabric.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fabric_textures", schema = "tailor")
@Getter @Setter
public class FabricTexture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "texture_id")
    private Integer textureId;

    @Column(name = "texture_name")
    private String textureName;

    @Column(name = "hex_code")
    private String hexCode;
}
