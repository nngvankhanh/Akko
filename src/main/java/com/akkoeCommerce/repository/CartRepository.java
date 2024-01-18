package com.akkoeCommerce.repository;

import com.akkoeCommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUser_Id(Long id);
}
