package com.rustam.e_commerce.controller;

import com.rustam.e_commerce.dto.response.VendorResponse;

import com.rustam.e_commerce.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vendor")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    @GetMapping(path = "/pending")
    public ResponseEntity<List<VendorResponse>> read(){
        return new ResponseEntity<>(vendorService.read(), HttpStatus.ACCEPTED);
    }
    @PatchMapping(path ="/{id}/status")
    public ResponseEntity<String> updateVendorStatus(@PathVariable Long id, @RequestBody StatusUpdateRequest statusUpdateRequest) {

        boolean isUpdated = vendorService.updateVendorStatus(id, statusUpdateRequest.getStatus());

        if (isUpdated) {
            return ResponseEntity.ok("Satıcı statusu uğurla dəyişdirildi");
        } else {
            return ResponseEntity.badRequest().body("Satıcı tapılmadı və ya status dəyişdirilə bilmədi");
        }
    }
}