package com.akkoeCommerce.converter.Impl;

import com.akkoeCommerce.converter.CartConverter;
import com.akkoeCommerce.entity.Cart;
import com.akkoeCommerce.payload.request.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartConverterImpl implements CartConverter {
    @Override
    public Cart convertToEntity(CartRequest cartRequest) {
        return Cart.builder()
                .size(cartRequest.getSize())
                .color(cartRequest.getColor())
                .quantity(cartRequest.getQuantity())
                .build();
    }
}
