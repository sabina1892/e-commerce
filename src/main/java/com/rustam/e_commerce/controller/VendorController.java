package com.rustam.e_commerce.controller;

import com.rustam.e_commerce.dto.request.VendorCreateRequest;
import com.rustam.e_commerce.dto.request.VendorUpdateRequest;
import com.rustam.e_commerce.dto.response.VendorCreateResponse;

import com.rustam.e_commerce.dto.response.VendorUpdateResponse;
import com.rustam.e_commerce.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vendor")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    @PostMapping
    public ResponseEntity<VendorCreateResponse> createVendor(@RequestBody VendorCreateRequest request) {
        return new ResponseEntity<>(vendorService.createVendor(request), HttpStatus.CREATED);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<VendorCreateResponse>> getPendingVendors() {
        return ResponseEntity.ok(vendorService.getPendingVendors());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateVendorStatus(@PathVariable UUID id, @RequestParam boolean enabled) {
        vendorService.updateVendorStatus(id, enabled);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorUpdateResponse> updateVendor(@PathVariable UUID id, @RequestBody VendorUpdateRequest request) {
        return ResponseEntity.ok(vendorService.updateVendor(id, request));
    }
}