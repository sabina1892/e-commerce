package com.rustam.e_commerce.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorCreateRequest {
    @NotNull(message = "The id column cannot be empty.")
    private UUID id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String phone;
    private Boolean enabled;


}
