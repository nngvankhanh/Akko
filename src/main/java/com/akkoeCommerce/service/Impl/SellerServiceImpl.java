package com.akkoeCommerce.service.Impl;

import com.akkoeCommerce.converter.SellerConverter;
import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.repository.ProductRepository;
import com.akkoeCommerce.repository.SellerProductRepository;
import com.akkoeCommerce.repository.SellerRepository;
import com.akkoeCommerce.service.SellerService;
import com.akkoeCommerce.payload.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;
@Component
@Transactional
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SellerConverter sellerConverter;
    @Autowired
    private SellerProductRepository sellerProductRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Iterable<Seller> findAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Optional<Seller> findById(Long id) {
        return sellerRepository.findById(id);
    }

    @Override
    public void save(RegisterRequest registerRequest) {
        Seller seller = sellerConverter.requestDtoToEntity(registerRequest);
        sellerRepository.save(seller);
    }

    @Override
    public boolean isCheckEmailAndPassword(String email, String password) {
        boolean result = sellerRepository.existsByEmailAndPassword(email, password);
        return result;
    }
}
