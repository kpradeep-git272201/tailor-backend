package com.tailorapp.catalog.fabric.respository;

import com.tailorapp.catalog.fabric.entity.FabricEntity;
import com.tailorapp.catalog.fabric.projection.FabricCatalogProjection;
import com.tailorapp.catalog.fabric.projection.FabricColorProjection;
import com.tailorapp.catalog.fabric.projection.FabricWithCategoryPriceProjection;
import com.tailorapp.catalog.fabric.projection.FabricWithPriceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabricRepository extends JpaRepository<FabricEntity, Long> {

    @Query(value = """
       SELECT
            f.fabric_id            AS fabricId,
            f.name                 AS fabricName,
            f.fabric_category_id   AS fabricCategoryId,
            f.stock_qty            AS stockQty,
            f.active_flag          AS activeFlag,
            f.is_deleted           AS isDeleted,
            f.image_path           AS fabricImagePath,
        
            fc.name                AS categoryName,
            fc.description         AS categoryDescription,
            fc.image_path          AS categoryImagePath,
        
            ft.texture_name        AS textureName,
        
            fp.price_per_unit      AS pricePerUnit,
            fp.currency            AS currency,
            fp.valid_from          AS validFrom,
            fp.valid_to            AS validTo,
            fp.is_active           AS priceActive,
        
            fi.fabric_image_id     AS fabricImageId,
            fi.image_path          AS fabricImage,
            fi.profile_image       AS profileImage,
            fi.description         AS imageDescription,
            fi.fabric_category_id  AS imageCategoryId
        
        FROM tailor.fabrics f
        
        LEFT JOIN tailor.fabric_categories fc
               ON fc.fabric_category_id = f.fabric_category_id
        
        LEFT JOIN tailor.fabric_textures ft
               ON ft.texture_id = f.texture_id_fk
        
        LEFT JOIN tailor.fabric_prices fp
               ON fp.fabric_id = f.fabric_id
              AND fp.is_active = TRUE
        
        LEFT JOIN tailor.fabric_images fi
               ON fi.fabric_id = f.fabric_id
        
        WHERE f.is_deleted = 'N'
        
        ORDER BY f.fabric_id, fi.fabric_image_id
            """, nativeQuery = true)
    List<FabricCatalogProjection> fetchFabricCatalog();

    @Query(value = """
       SELECT
            fc.fabric_category_id          AS fabricCategoryId,
            fc.name                        AS categoryName,
            fc.description                 AS categoryDescription,
            fc.image_path                  AS categoryImage,
        
            f.fabric_id                    AS fabricId,
            f.name                         AS fabricName,
            f.stock_qty                    AS stockQty,
            f.active_flag                  AS isActive,
            f.is_deleted                   AS isDeleted,
            f.image_path                   AS fabricImage,
        
            fp.price_per_unit              AS pricePerMeter
        FROM tailor.fabric_categories fc
        JOIN tailor.fabrics f
            ON fc.fabric_category_id = f.fabric_category_id
        JOIN tailor.fabric_prices fp
            ON f.fabric_id = fp.fabric_id
        WHERE fc.fabric_category_id = :fabricCategoryId
          AND f.active_flag = true
          AND fp.is_active = true
        """, nativeQuery = true)
    List<FabricWithCategoryPriceProjection> findByFabricCategoryId(Long fabricCategoryId);

    @Query(value = """
            SELECT 
                 fc.name            AS categoryName,
                 fc.description     AS categoryDescription,
                 f.fabric_id        AS fabricId,
                 f.name             AS fabricName,
                 f.fabric_category_id AS fabricCategoryId,
                 fp.price_per_unit  AS pricePerMeter,
                 f.stock_qty        AS stockQty,
                 f.active_flag      AS isActive,
                 f.is_deleted       AS isDeleted,
                 f.image_path       AS imagePath
            
             FROM tailor.fabrics f
             JOIN tailor.fabric_prices fp
                 ON f.fabric_id = fp.fabric_id
            JOIN tailor.fabric_categories fc
                 ON f.fabric_category_id=fc.fabric_category_id
             WHERE f.active_flag = true
               AND fp.is_active = true
            """, nativeQuery = true)
    List<FabricWithPriceProjection> getAllFabricsWithPrice();

    @Query(value = """
            SELECT 
                 fc.name            AS categoryName,
                 fc.description     AS categoryDescription,
                 f.fabric_id        AS fabricId,
                 f.name             AS fabricName,
                 f.fabric_category_id AS fabricCategoryId,
                 fp.price_per_unit  AS pricePerMeter,
                 f.stock_qty        AS stockQty,
                 f.active_flag      AS isActive,
                 f.is_deleted       AS isDeleted,
                 f.image_path       AS imagePath
            
             FROM tailor.fabrics f
             JOIN tailor.fabric_prices fp
                 ON f.fabric_id = fp.fabric_id
            JOIN tailor.fabric_categories fc
                 ON f.fabric_category_id=fc.fabric_category_id
             WHERE f.active_flag = true
                AND f.fabric_id=:fabricId
               AND fp.is_active = true
            """, nativeQuery = true)
    List<FabricWithPriceProjection> getFabricsWithPriceByFabricId(Long fabricId);

    @Query(value = """
        SELECT
            fcmap.fabric_id    AS fabricId,
            c.color_id         AS colorId,
            c.color_name       AS colorName,
            c.hex_code         AS hexCode,
            c.color_image      AS colorImage
        FROM tailor.fabric_color_map fcmap
        JOIN tailor.fabric_colors c
             ON c.color_id = fcmap.color_id
        WHERE fcmap.fabric_id = :fabricId
        ORDER BY c.color_name
        """, nativeQuery = true)
    List<FabricColorProjection> fetchColorsByFabricId(Long fabricId);

}
