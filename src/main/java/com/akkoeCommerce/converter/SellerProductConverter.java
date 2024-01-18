package com.akkoeCommerce.converter;

import com.akkoeCommerce.payload.request.SellerProductRequest;
import com.akkoeCommerce.payload.response.SellerProductResponse;
import com.akkoeCommerce.entity.SellerProduct;

import java.util.Collection;

public interface SellerProductConverter extends GeneralConverter<SellerProduct, SellerProductRequest, SellerProductResponse>{
    Collection<SellerProductResponse> entityToResponseDto(Collection<SellerProduct> source);
    Collection<SellerProduct> requestDtoToEntity(Collection<SellerProductRequest> source);
}
