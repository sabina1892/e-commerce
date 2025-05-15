package com.rustam.e_commerce.mapper;

import com.rustam.e_commerce.dao.entity.user.BaseUser;
import com.rustam.e_commerce.dto.response.VendorCreateResponse;
import com.rustam.e_commerce.dto.response.VendorResponse;
import com.rustam.e_commerce.dto.response.order.OrderStatsResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface VendorMapper {
    VendorResponse toRead(BaseUser baseUser);
    List<VendorResponse> toRead(List<BaseUser> baseUsers);
    VendorCreateResponse toResponse(BaseUser baseUser);
    //EmployeeUpdateResponse toUpdated(Employee employee);

   }
