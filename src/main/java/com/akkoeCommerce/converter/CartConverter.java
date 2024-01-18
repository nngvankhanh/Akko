package com.akkoeCommerce.converter;

import com.akkoeCommerce.entity.Cart;
import com.akkoeCommerce.payload.request.CartRequest;

public interface CartConverter {
    Cart convertToEntity(CartRequest cartRequest);
}
