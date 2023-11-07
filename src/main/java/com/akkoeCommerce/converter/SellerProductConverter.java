package com.akkoeCommerce.converter;

import com.akkoeCommerce.payload.request.SellerProductRequestDto;
import com.akkoeCommerce.payload.response.SellerProductResponseDto;
import com.akkoeCommerce.entity.SellerProduct;

import java.util.Collection;

public interface SellerProductConverter extends GeneralConverter<SellerProduct, SellerProductRequestDto, SellerProductResponseDto>{
    Collection<SellerProductResponseDto> entityToResponseDto(Collection<SellerProduct> source);
    Collection<SellerProduct> requestDtoToEntity(Collection<SellerProductRequestDto> source);
}
