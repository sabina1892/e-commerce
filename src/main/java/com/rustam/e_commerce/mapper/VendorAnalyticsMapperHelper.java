package com.rustam.e_commerce.mapper;

import com.rustam.e_commerce.dto.response.order.MonthlySalesResponse;
import com.rustam.e_commerce.dto.response.order.OrderStatsResponse;
import com.rustam.e_commerce.dto.response.order.StatusStatsResponse;
import com.rustam.e_commerce.dto.response.order.TopProductResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class VendorAnalyticsMapperHelper {
    public OrderStatsResponse toOrderStats(Object[] row){return new OrderStatsResponse(
            ((Number) row[0]).longValue(),
            (BigDecimal) row[1]
    );}
    public MonthlySalesResponse mapToMonthlySales(Object[] row) {
        return new MonthlySalesResponse(
                (String) row[0],
                ((Number) row[1]).longValue(),
                (BigDecimal) row[2]
        );
    }
    public StatusStatsResponse toStatusStats(Object[] row){
        return new StatusStatsResponse(
                (String) row[0],
                ((Number) row[1]).longValue()
        );
    }
    public TopProductResponse toTopProduct(Object[] row){
        return new TopProductResponse(
                ((Number) row[0]).longValue(),
                (String) row[1],
                ((Number) row[2]).longValue(),
                (BigDecimal) row[3]
        );
    }
}
