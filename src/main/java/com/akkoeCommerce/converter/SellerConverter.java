package com.akkoeCommerce.converter;

import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.payload.request.RegisterRequest;
import com.akkoeCommerce.payload.response.RegisterResponse;

public interface SellerConverter extends GeneralConverter<Seller, RegisterRequest, RegisterResponse>{
    @Override
    RegisterResponse entityToResponseDto(Seller source);

    @Override
    Seller requestDtoToEntity(RegisterRequest source);
}
