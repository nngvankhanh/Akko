package com.akkoeCommerce.service;

import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.payload.request.RegisterRequest;

import java.util.Optional;

public interface SellerService {
    Iterable<Seller> findAll();
    Optional<Seller> findById(Long id);
    void save(RegisterRequest registerRequest);
    boolean isCheckEmailAndPassword(String email, String password);
}
