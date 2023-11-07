package com.akkoeCommerce.service;

import com.akkoeCommerce.entity.Category;

import java.util.Optional;
public interface CategoryService {
    Iterable<Category> findAll();
    Optional<Category> findById(Long id);
}
