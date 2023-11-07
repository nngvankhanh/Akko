package com.akkoeCommerce.service.Impl;

import com.akkoeCommerce.entity.SellerProduct;
import com.akkoeCommerce.repository.SellerProductRepository;
import com.akkoeCommerce.service.SellerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SellerProductServiceImpl implements SellerProductService {
    @Autowired
    private SellerProductRepository sellerProductRepository;
    @Override
    public Iterable<SellerProduct> findAll() {
        return sellerProductRepository.findAll();
    }

    @Override
    public Optional<SellerProduct> findById(Long id) {
        return sellerProductRepository.findById(id);
    }

    @Override
    public void save(SellerProduct sellerProduct) {
        sellerProductRepository.save(sellerProduct);
    }

}
