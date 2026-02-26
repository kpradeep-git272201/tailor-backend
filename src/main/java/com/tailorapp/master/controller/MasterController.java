package com.tailorapp.master.controller;

import com.tailorapp.catalog.fabric.dto.FabricWithPriceDTO;
import com.tailorapp.common.response.ApiResponse;
import com.tailorapp.master.dto.FabricColorDTO;
import com.tailorapp.master.service.FabricColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/master/api/v1")
@RestController
public class MasterController {

    @Autowired
    private FabricColorService fabricColorService;

    @GetMapping("/fabric-color/fabric/{fabricId}")
    public ResponseEntity<ApiResponse<List<FabricColorDTO>>> getFabricColor(@PathVariable Integer fabricId){
        if (fabricId == null) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error(
                            "fabricId is required",
                            "FABRIC_ID_MISSING"
                    ));
        }
        List<FabricColorDTO> fabricColor = fabricColorService.getFabricColor(fabricId);

        if (fabricColor == null || fabricColor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Fabric Color not found", "FABRIC_NOT_FOUND"));
        }
        return ResponseEntity.ok(
                ApiResponse.success("Fabric Color fetched successfully", fabricColor, fabricColor.size())
        );
    }

}
