package com.rustam.e_commerce.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorRequestCreate {
    @NotNull(message = "The id column cannot be empty.")
    private UUID id;
    private String username;
    private String email;
    private String password;
}
