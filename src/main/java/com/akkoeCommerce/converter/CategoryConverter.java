package com.akkoeCommerce.converter;

import com.akkoeCommerce.payload.request.CategoryRequestDto;
import com.akkoeCommerce.payload.response.CategoryResponseDto;
import com.akkoeCommerce.entity.Category;


public interface CategoryConverter extends GeneralConverter<Category, CategoryRequestDto, CategoryResponseDto>{
}
