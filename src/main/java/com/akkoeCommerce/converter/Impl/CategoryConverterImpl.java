package com.akkoeCommerce.converter.Impl;

import com.akkoeCommerce.converter.CategoryConverter;
import com.akkoeCommerce.payload.request.CategoryRequestDto;
import com.akkoeCommerce.payload.response.CategoryResponseDto;
import com.akkoeCommerce.entity.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverterImpl implements CategoryConverter {
    @Override
    public CategoryResponseDto entityToResponseDto(Category source) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        BeanUtils.copyProperties(source,categoryResponseDto);
        return categoryResponseDto;
    }

    @Override
    public Category requestDtoToEntity(CategoryRequestDto source) {
        Category category = new Category();
        BeanUtils.copyProperties(source,category);
        return category;
    }

}
