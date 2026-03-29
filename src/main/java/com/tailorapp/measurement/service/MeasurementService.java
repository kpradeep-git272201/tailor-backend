package com.tailorapp.measurement.service;

import com.tailorapp.measurement.dto.AddMeasurementRequest;
import com.tailorapp.measurement.dto.MeasurementDTO;

import java.util.List;

public interface MeasurementService {

    MeasurementDTO addMeasurement(AddMeasurementRequest request);

    List<MeasurementDTO> getMeasurementsByUserId(Long userId);

    MeasurementDTO getMeasurementById(Long measurementId);

    MeasurementDTO updateMeasurement(Long measurementId, AddMeasurementRequest request);

    void deleteMeasurement(Long measurementId);

    MeasurementDTO setDefaultMeasurement(Long userId, Long measurementId);
}
