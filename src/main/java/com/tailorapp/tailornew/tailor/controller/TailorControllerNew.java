package com.tailorapp.tailornew.tailor.controller;

import com.tailorapp.common.response.ApiResponse;
import com.tailorapp.tailornew.tailor.dto.TailorResponseDto;
import com.tailorapp.tailornew.tailor.service.TailorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/tailors")
public class TailorControllerNew {

    private final TailorService tailorService;

    public TailorControllerNew(TailorService tailorService) {
        this.tailorService = tailorService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TailorResponseDto>> createTailor(
            @Valid @RequestBody TailorResponseDto tailorDto) {

        TailorResponseDto response = tailorService.createTailor(tailorDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "Tailor created successfully.",
                        response
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TailorResponseDto>>> getAllTailors() {

        List<TailorResponseDto> response = tailorService.getAllTailors();

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Tailors fetched successfully.",
                        response
                )
        );
    }
}