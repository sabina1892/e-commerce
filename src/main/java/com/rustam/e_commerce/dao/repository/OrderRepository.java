package com.rustam.e_commerce.dao.repository;

import com.rustam.e_commerce.dao.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order,Long> {
    // Satıcının ümumi sifariş sayı və gəliri
    @Query("SELECT COUNT(o),coalesce(sum(o.totalAmount), 0) from Order o where o.vendor.id = :vendorId")
    Object[] getOrderCountAndRevenue(@Param("vendorId") UUID vendorId);
    // Satıcının ay ərzində satışı
    @Query("select function('date_format',o.localDateTime,'%Y-%m'),coalesce(sum(o.totalAmount),0) from Order o where o.vendor.id = :vendorId group by function('date_format', o.localDateTime, '%Y-%m') order by 1")
    List<Object[]> getMonthlySales(@Param("vendorId") UUID vendorId);

    @Query("select o.orderStatus, count(o) from Order o where o.vendor.id = :vendorId group by o.orderStatus")
    List<Object[]> getOrderStatus(@Param("vendorId") UUID vendorId);

}
