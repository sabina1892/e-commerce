package com.rustam.e_commerce.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendorUpdateRequest {
    @NotNull(message = "The id column cannot be empty.")
    private UUID id;
    private Boolean enabled;

    public boolean isEnabled(){
        return enabled;
    }
}
