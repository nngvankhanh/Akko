package com.akkoeCommerce.converter;

import com.akkoeCommerce.entity.User;
import com.akkoeCommerce.payload.request.RegisterRequest;

public interface UserConverter {
    User convertToEntity(RegisterRequest registerRequest);
}
