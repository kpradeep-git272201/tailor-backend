package com.tailorapp.measurement.controller;

import com.tailorapp.common.response.ApiResponse;
import com.tailorapp.measurement.dto.AddMeasurementRequest;
import com.tailorapp.measurement.dto.MeasurementDTO;
import com.tailorapp.measurement.service.MeasurementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/measurements")
@RestController
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MeasurementDTO>> addMeasurement(@Valid @RequestBody AddMeasurementRequest request) {
        MeasurementDTO measurement = measurementService.addMeasurement(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Measurement added successfully", measurement));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<MeasurementDTO>>> getMeasurementsByUserId(@PathVariable Long userId) {
        List<MeasurementDTO> measurements = measurementService.getMeasurementsByUserId(userId);

        if (measurements == null || measurements.isEmpty()) {
            return ResponseEntity.ok(
                    ApiResponse.success("No measurements found", List.of(), 0)
            );
        }

        return ResponseEntity.ok(
                ApiResponse.success("Measurements fetched successfully", measurements, measurements.size())
        );
    }

    @GetMapping("/{measurementId}")
    public ResponseEntity<ApiResponse<MeasurementDTO>> getMeasurementById(@PathVariable Long measurementId) {
        MeasurementDTO measurement = measurementService.getMeasurementById(measurementId);
        return ResponseEntity.ok(ApiResponse.success("Measurement fetched successfully", measurement));
    }

    @PutMapping("/{measurementId}")
    public ResponseEntity<ApiResponse<MeasurementDTO>> updateMeasurement(
            @PathVariable Long measurementId,
            @Valid @RequestBody AddMeasurementRequest request) {
        MeasurementDTO updatedMeasurement = measurementService.updateMeasurement(measurementId, request);
        return ResponseEntity.ok(ApiResponse.success("Measurement updated successfully", updatedMeasurement));
    }

    @DeleteMapping("/{measurementId}")
    public ResponseEntity<ApiResponse<Void>> deleteMeasurement(@PathVariable Long measurementId) {
        measurementService.deleteMeasurement(measurementId);
        return ResponseEntity.ok(ApiResponse.success("Measurement deleted successfully"));
    }

    @PatchMapping("/user/{userId}/default/{measurementId}")
    public ResponseEntity<ApiResponse<MeasurementDTO>> setDefaultMeasurement(
            @PathVariable Long userId,
            @PathVariable Long measurementId) {
        MeasurementDTO measurement = measurementService.setDefaultMeasurement(userId, measurementId);
        return ResponseEntity.ok(ApiResponse.success("Default measurement set successfully", measurement));
    }
}
