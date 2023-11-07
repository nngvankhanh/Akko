package com.akkoeCommerce.service;

import com.akkoeCommerce.entity.SellerProduct;

import java.util.Optional;

public interface SellerProductService {
    Iterable<SellerProduct> findAll();
    Optional<SellerProduct> findById(Long id);
    void save(SellerProduct sellerProduct);
}
