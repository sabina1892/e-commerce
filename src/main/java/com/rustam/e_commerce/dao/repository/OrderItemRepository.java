package com.rustam.e_commerce.dao.repository;

import com.rustam.e_commerce.dao.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    @Query("select orderItem.product, orderItem.productName, sum(orderItem.quantity),sum(orderItem.quantity*orderItem.orderedProductPrice) from OrderItem orderItem where orderItem.order.vendor.id = :vendorId group by orderItem.productName,orderItem.product order by sum(orderItem.quantity) desc")
    List<Object[]> getTopProducts(@Param("vendorId") UUID vendorId);
}
