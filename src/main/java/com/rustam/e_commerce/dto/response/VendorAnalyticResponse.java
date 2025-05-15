package com.rustam.e_commerce.dto.response;

import com.rustam.e_commerce.dao.entity.enums.OrderStatus;
import com.rustam.e_commerce.dto.response.order.MonthlySalesResponse;
import com.rustam.e_commerce.dto.response.order.OrderStatsResponse;
import com.rustam.e_commerce.dto.response.order.StatusStatsResponse;
import com.rustam.e_commerce.dto.response.order.TopProductResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendorAnalyticResponse {
    private OrderStatsResponse orderStatus;
    private List<MonthlySalesResponse> monthlySalesResponse;
    private List<StatusStatsResponse> statusStatesResponses;
    private List<TopProductResponse> topProductResponses;
}
