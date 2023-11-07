package com.akkoeCommerce.service;

import com.akkoeCommerce.payload.request.ProductRequestDto;
import com.akkoeCommerce.payload.response.ProductResponseDto;

import java.util.Optional;

public interface ProductService {
    Iterable<ProductResponseDto> findAll();
    Optional<ProductResponseDto> findById(Long id);
    void save(ProductRequestDto productRequestDto);
    void deleteById(Long id);
}
