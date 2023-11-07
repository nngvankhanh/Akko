package com.akkoeCommerce.converter.Impl;

import com.akkoeCommerce.converter.SellerConverter;
import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.payload.request.RegisterRequestDto;
import com.akkoeCommerce.payload.response.RegisterResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SellerConverterImpl implements SellerConverter {
    @Override
    public RegisterResponseDto entityToResponseDto(Seller source) {
        return null;
    }

    @Override
    public Seller requestDtoToEntity(RegisterRequestDto source) {
        Seller seller = new Seller();
        BeanUtils.copyProperties(source,seller);
        return seller;
    }
}
