package com.tailorapp.master.repository;

import com.tailorapp.master.dto.FabricColorDTO;
import com.tailorapp.master.entity.FabricColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterRespository extends JpaRepository<FabricColorEntity, Long> {


    @Query(value = """
            SELECT c.color_id, c.color_name, c.hex_code
            FROM tailor.fabric_color_map fcm
            JOIN tailor.fabric_colors c ON fcm.color_id = c.color_id
            JOIN tailor.fabrics f ON fcm.fabric_id = f.fabric_id
            WHERE f.fabric_id =:fabricId
            """, nativeQuery = true)
    List<FabricColorEntity> getFabricColorByFabricId(Integer fabricId);
}
