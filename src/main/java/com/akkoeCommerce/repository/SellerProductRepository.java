package com.akkoeCommerce.repository;

import com.akkoeCommerce.entity.Product;
import com.akkoeCommerce.entity.SellerProduct;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SellerProductRepository extends JpaRepository<SellerProduct, Long> {
    SellerProduct findAllByProduct(Product product);
}
