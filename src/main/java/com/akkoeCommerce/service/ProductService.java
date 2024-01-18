package com.akkoeCommerce.service;

import com.akkoeCommerce.payload.request.ProductRequest;
import com.akkoeCommerce.payload.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Iterable<ProductResponse> findAll();
    Optional<ProductResponse> findById(Long id);
    List<ProductResponse> findProductListByCategoryId(Long id);
    void save(ProductRequest productRequest);
    void deleteById(Long id);
}
