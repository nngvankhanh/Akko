package com.akkoeCommerce.service;

import com.akkoeCommerce.entity.Cart;
import com.akkoeCommerce.payload.request.CartRequest;

import java.util.List;

public interface CartService {
    List<Cart> save(CartRequest cartRequest, Long id);
}
