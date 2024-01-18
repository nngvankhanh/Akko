package com.akkoeCommerce.converter;

import com.akkoeCommerce.payload.request.ProductRequest;
import com.akkoeCommerce.payload.response.ProductResponse;
import com.akkoeCommerce.entity.Product;

public interface ProductConverter{
    ProductResponse convertToDto(Product product);
    Product requestDtoToEntity(ProductRequest source);
}
