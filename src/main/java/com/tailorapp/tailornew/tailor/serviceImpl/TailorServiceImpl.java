package com.tailorapp.tailornew.tailor.serviceImpl;

import com.tailorapp.common.exception.ResourceAlreadyExistsException;
import com.tailorapp.tailornew.expertise.entity.ExpertiseEntity;
import com.tailorapp.tailornew.expertise.entity.TailorExpertiseEntity;
import com.tailorapp.tailornew.tailor.dto.TailorResponseDto;
import com.tailorapp.tailornew.tailor.entity.TailorEntity;
import com.tailorapp.tailornew.tailor.repository.TailorRepository;
import com.tailorapp.tailornew.tailor.service.TailorService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TailorServiceImpl implements TailorService {

    private final TailorRepository tailorRepository;
    private final ModelMapper modelMapper;

    public TailorServiceImpl(TailorRepository tailorRepository,
                             ModelMapper modelMapper) {
        this.tailorRepository = tailorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TailorResponseDto createTailor(TailorResponseDto dto) {

        // Duplicate Mobile Check
        if (tailorRepository.existsByMobileNumberAndDeletedFalse(dto.getMobileNumber())) {
            throw new ResourceAlreadyExistsException("Mobile number already exists.");
        }

        // Duplicate Email Check
        if (dto.getEmail() != null &&
                tailorRepository.existsByEmailAndDeletedFalse(dto.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already exists.");
        }

        // DTO -> Entity
        TailorEntity tailor = modelMapper.map(dto, TailorEntity.class);

        // Default Values
        if (tailor.getAverageRating() == null) {
            tailor.setAverageRating(BigDecimal.ZERO);
        }

        if (tailor.getReviewCount() == null) {
            tailor.setReviewCount(0);
        }

        // OneToOne Relation
        if (tailor.getAddress() != null) {
            tailor.getAddress().setTailor(tailor);
        }

        // OneToMany Relation
        if (tailor.getTailorExpertises() != null) {

            for (TailorExpertiseEntity te : tailor.getTailorExpertises()) {

                te.setTailor(tailor);

                if (te.getExpertise() != null &&
                        te.getExpertise().getExpertiseId() != null) {

                    ExpertiseEntity expertise = new ExpertiseEntity();
                    expertise.setExpertiseId(
                            te.getExpertise().getExpertiseId());

                    te.setExpertise(expertise);
                }
            }
        }

        // Save
        TailorEntity saved = tailorRepository.save(tailor);

        // Entity -> DTO
        return modelMapper.map(saved, TailorResponseDto.class);
    }

    @Override
    public List<TailorResponseDto> getAllTailors() {
        List<TailorEntity> tailors =
                tailorRepository.findAllByDeletedFalseAndActiveTrueOrderByTailorIdDesc();

        return tailors.stream()
                .map(tailor -> modelMapper.map(tailor, TailorResponseDto.class))
                .toList();
    }
}