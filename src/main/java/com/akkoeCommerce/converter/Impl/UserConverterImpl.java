package com.akkoeCommerce.converter.Impl;

import com.akkoeCommerce.converter.UserConverter;
import com.akkoeCommerce.entity.User;
import com.akkoeCommerce.payload.request.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public User convertToEntity(RegisterRequest registerRequest) {
        return User
                .builder()
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .build();
    }
}
