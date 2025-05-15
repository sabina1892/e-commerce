package com.rustam.e_commerce.dto.response.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatsResponse {
    private Long orderCount;
    private BigDecimal totalRevenue;
}
