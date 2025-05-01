package com.rustam.e_commerce.service;

import com.rustam.e_commerce.dao.entity.user.BaseUser;
import com.rustam.e_commerce.dao.entity.user.Vendor;
import com.rustam.e_commerce.dao.repository.VendorRepository;
import com.rustam.e_commerce.dto.request.VendorCreateRequest;
import com.rustam.e_commerce.dto.request.VendorUpdateRequest;
import com.rustam.e_commerce.dto.response.EmployeeCreateResponse;
import com.rustam.e_commerce.dto.response.VendorCreateResponse;
import com.rustam.e_commerce.dto.response.VendorUpdateResponse;
import com.rustam.e_commerce.mapper.VendorMapper;
import com.rustam.e_commerce.util.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendorService {
    private final UtilService utilService;
    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorCreateResponse createVendor(VendorCreateRequest request) {
        //BaseUser baseUser = utilService.findById(request.getId());
        Vendor vendor = new Vendor();
        vendor.setName(request.getName());
        vendor.setSurname(request.getSurname());
        vendor.setUsername(request.getUsername());
        vendor.setEmail(request.getEmail());
        vendor.setPassword(request.getPassword());
        vendor.setPhone(request.getPhone());
        vendor.setEnabled(false); // PENDING

        vendorRepository.save(vendor);

        VendorCreateResponse.builder()
                .name(vendor.getName())
                .surname(vendor.getSurname())
                .username(vendor.getName())
                .email(vendor.getEmail())
                .enabled(Boolean.valueOf("Vendor created and pending approval."))
                .build();
        return vendorMapper.toResponse(vendor);
    }


    public List<VendorCreateResponse> getPendingVendors() {
        return vendorRepository.findAllByEnabled(false).stream()
                .map(vendor -> VendorCreateResponse.builder()
                        .username(vendor.getName())
                        .email(vendor.getEmail())
                        .enabled(Boolean.valueOf("Vendor created and pending approval."))
                        .build())
                .toList();
    }

    public void updateVendorStatus(UUID id, boolean enabled) {
        Vendor vendor = utilService.findByVendorId(id);
        vendor.setEnabled(enabled);
        vendorRepository.save(vendor);
    }

    public VendorUpdateResponse updateVendor(UUID id, VendorUpdateRequest request) {
        Vendor vendor = utilService.findByVendorId(id);
        BaseUser baseUser = utilService.findById(request.getId());
        vendor.setName(baseUser.getName());
        vendor.setEmail(baseUser.getEmail());
        vendor.setPhone(baseUser.getPhone());

        vendorRepository.save(vendor);

        return VendorUpdateResponse.builder()
                .name(vendor.getName())
                .email(vendor.getEmail())
                .text("Vendor updated.")
                .build();
    }
}