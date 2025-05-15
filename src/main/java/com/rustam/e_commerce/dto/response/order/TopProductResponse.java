package com.rustam.e_commerce.dto.response.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TopProductResponse {
    private Long productId;
    private String name;
    private Long quantitySold;
    private BigDecimal revenue;
}
