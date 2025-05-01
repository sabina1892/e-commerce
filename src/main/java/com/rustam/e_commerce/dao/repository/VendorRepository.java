package com.rustam.e_commerce.dao.repository;

import com.rustam.e_commerce.dao.entity.user.User;
import com.rustam.e_commerce.dao.entity.user.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {
    List<Vendor> findAllByEnabled(boolean enabled);
}
