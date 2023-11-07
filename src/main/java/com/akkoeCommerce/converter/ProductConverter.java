package com.akkoeCommerce.converter;

import com.akkoeCommerce.payload.request.ProductRequestDto;
import com.akkoeCommerce.payload.response.ProductResponseDto;
import com.akkoeCommerce.entity.Product;

public interface ProductConverter extends GeneralConverter<Product, ProductRequestDto, ProductResponseDto>{
}
