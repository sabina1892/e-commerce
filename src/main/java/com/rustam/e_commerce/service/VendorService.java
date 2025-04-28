package com.rustam.e_commerce.service;

import com.rustam.e_commerce.dao.entity.user.BaseUser;
import com.rustam.e_commerce.dao.entity.user.User;
import com.rustam.e_commerce.dao.entity.user.Vendor;
import com.rustam.e_commerce.dao.repository.VendorRepository;
import com.rustam.e_commerce.dto.response.VendorResponse;
import com.rustam.e_commerce.mapper.VendorMapper;
import com.rustam.e_commerce.util.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendorService {
    private final UtilService utilService;
    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;
    public List<VendorResponse> read() {
        List<BaseUser> vendors = utilService.findAllExistVendor();
        return vendors.stream()
                .map(vendorMapper::toRead)
                .collect(Collectors.toList());
    }
}