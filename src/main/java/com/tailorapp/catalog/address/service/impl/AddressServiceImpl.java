package com.tailorapp.catalog.address.service.impl;

import com.tailorapp.catalog.address.dto.AddAddressRequest;
import com.tailorapp.catalog.address.dto.AddressDTO;
import com.tailorapp.catalog.address.entity.AddressEntity;
import com.tailorapp.catalog.address.repository.AddressRepository;
import com.tailorapp.catalog.address.service.AddressService;
import com.tailorapp.common.mapper.AddressMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    @Transactional
    public AddressDTO addAddress(AddAddressRequest request) {
        if (Boolean.TRUE.equals(request.getIsDefault())) {
            clearDefaultAddress(request.getUserId());
        }

        List<AddressEntity> existingAddresses = addressRepository.findByUserId(request.getUserId());
        if (existingAddresses.isEmpty()) {
            request.setIsDefault(true);
        }

        AddressEntity entity = addressMapper.toEntity(request);
        AddressEntity savedEntity = addressRepository.save(entity);
        return addressMapper.toDto(savedEntity);
    }

    @Override
    public List<AddressDTO> getAddressesByUserId(Long userId) {
        List<AddressEntity> entities = addressRepository.findByUserIdOrderByIsDefaultDescCreatedAtDesc(userId);
        return addressMapper.toDtoList(entities);
    }

    @Override
    public AddressDTO getDefaultAddress(Long userId) {
        return addressRepository.findByUserIdAndIsDefaultTrue(userId)
                .map(addressMapper::toDto)
                .orElse(null);
    }

    @Override
    @Transactional
    public AddressDTO updateAddress(Long addressId, AddAddressRequest request) {
        AddressEntity entity = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        if (Boolean.TRUE.equals(request.getIsDefault())) {
            clearDefaultAddress(entity.getUserId());
        }

        addressMapper.updateEntityFromRequest(request, entity);
        AddressEntity savedEntity = addressRepository.save(entity);
        return addressMapper.toDto(savedEntity);
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    @Transactional
    public AddressDTO setDefaultAddress(Long userId, Long addressId) {
        clearDefaultAddress(userId);

        AddressEntity entity = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        entity.setIsDefault(true);
        AddressEntity savedEntity = addressRepository.save(entity);
        return addressMapper.toDto(savedEntity);
    }

    private void clearDefaultAddress(Long userId) {
        addressRepository.findByUserIdAndIsDefaultTrue(userId)
                .ifPresent(existingDefault -> {
                    existingDefault.setIsDefault(false);
                    addressRepository.save(existingDefault);
                });
    }
}
