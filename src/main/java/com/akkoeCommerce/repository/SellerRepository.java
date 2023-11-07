package com.akkoeCommerce.repository;

import com.akkoeCommerce.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    boolean existsByEmailAndPassword(String email,String password);
}
