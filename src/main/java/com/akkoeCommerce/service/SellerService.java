package com.akkoeCommerce.service;

import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.payload.request.RegisterRequestDto;

import java.util.Optional;

public interface SellerService {
    Iterable<Seller> findAll();
    Optional<Seller> findById(Long id);
    void save(RegisterRequestDto registerRequestDto);
    boolean isCheckEmailAndPassword(String email, String password);
}
