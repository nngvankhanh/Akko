package com.akkoeCommerce.converter.Impl;

import com.akkoeCommerce.converter.SellerConverter;
import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.payload.request.RegisterRequest;
import com.akkoeCommerce.payload.response.RegisterResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SellerConverterImpl implements SellerConverter {
    @Override
    public RegisterResponse entityToResponseDto(Seller source) {
        return null;
    }

    @Override
    public Seller requestDtoToEntity(RegisterRequest source) {
        Seller seller = new Seller();
        BeanUtils.copyProperties(source,seller);
        return seller;
    }
}
