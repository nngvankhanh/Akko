package com.akkoeCommerce.converter;

import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.payload.request.RegisterRequestDto;
import com.akkoeCommerce.payload.response.RegisterResponseDto;

public interface SellerConverter extends GeneralConverter<Seller, RegisterRequestDto, RegisterResponseDto>{
    @Override
    RegisterResponseDto entityToResponseDto(Seller source);

    @Override
    Seller requestDtoToEntity(RegisterRequestDto source);
}
