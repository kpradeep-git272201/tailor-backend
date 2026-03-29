package com.tailorapp.measurement.service.impl;

import com.tailorapp.common.mapper.MeasurementMapper;
import com.tailorapp.measurement.dto.AddMeasurementRequest;
import com.tailorapp.measurement.dto.MeasurementDTO;
import com.tailorapp.measurement.entity.MeasurementEntity;
import com.tailorapp.measurement.repository.MeasurementRepository;
import com.tailorapp.measurement.service.MeasurementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;

    public MeasurementServiceImpl(MeasurementRepository measurementRepository, MeasurementMapper measurementMapper) {
        this.measurementRepository = measurementRepository;
        this.measurementMapper = measurementMapper;
    }

    @Override
    @Transactional
    public MeasurementDTO addMeasurement(AddMeasurementRequest request) {
        if (Boolean.TRUE.equals(request.getIsDefault())) {
            clearDefaultMeasurement(request.getUserId());
        }

        List<MeasurementEntity> existingMeasurements = measurementRepository.findByUserId(request.getUserId());
        if (existingMeasurements.isEmpty()) {
            request.setIsDefault(true);
        }

        MeasurementEntity entity = measurementMapper.toEntity(request);
        MeasurementEntity savedEntity = measurementRepository.save(entity);
        return measurementMapper.toDto(savedEntity);
    }

    @Override
    public List<MeasurementDTO> getMeasurementsByUserId(Long userId) {
        List<MeasurementEntity> entities = measurementRepository.findByUserIdOrderByIsDefaultDescCreatedAtDesc(userId);
        return measurementMapper.toDtoList(entities);
    }

    @Override
    public MeasurementDTO getMeasurementById(Long measurementId) {
        MeasurementEntity entity = measurementRepository.findById(measurementId)
                .orElseThrow(() -> new RuntimeException("Measurement not found"));
        return measurementMapper.toDto(entity);
    }

    @Override
    @Transactional
    public MeasurementDTO updateMeasurement(Long measurementId, AddMeasurementRequest request) {
        MeasurementEntity entity = measurementRepository.findById(measurementId)
                .orElseThrow(() -> new RuntimeException("Measurement not found"));

        if (Boolean.TRUE.equals(request.getIsDefault())) {
            clearDefaultMeasurement(entity.getUserId());
        }

        measurementMapper.updateEntityFromRequest(request, entity);
        MeasurementEntity savedEntity = measurementRepository.save(entity);
        return measurementMapper.toDto(savedEntity);
    }

    @Override
    public void deleteMeasurement(Long measurementId) {
        measurementRepository.deleteById(measurementId);
    }

    @Override
    @Transactional
    public MeasurementDTO setDefaultMeasurement(Long userId, Long measurementId) {
        clearDefaultMeasurement(userId);

        MeasurementEntity entity = measurementRepository.findById(measurementId)
                .orElseThrow(() -> new RuntimeException("Measurement not found"));

        entity.setIsDefault(true);
        MeasurementEntity savedEntity = measurementRepository.save(entity);
        return measurementMapper.toDto(savedEntity);
    }

    private void clearDefaultMeasurement(Long userId) {
        measurementRepository.findByUserIdAndIsDefaultTrue(userId)
                .ifPresent(existingDefault -> {
                    existingDefault.setIsDefault(false);
                    measurementRepository.save(existingDefault);
                });
    }
}
