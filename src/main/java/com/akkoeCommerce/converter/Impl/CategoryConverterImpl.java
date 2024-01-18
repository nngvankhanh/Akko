package com.akkoeCommerce.converter.Impl;

import com.akkoeCommerce.converter.CategoryConverter;
import com.akkoeCommerce.payload.request.CategoryRequest;
import com.akkoeCommerce.payload.response.CategoryResponse;
import com.akkoeCommerce.entity.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverterImpl implements CategoryConverter {
    @Override
    public CategoryResponse entityToResponseDto(Category source) {
        CategoryResponse categoryResponse = new CategoryResponse();
        BeanUtils.copyProperties(source, categoryResponse);
        return categoryResponse;
    }

    @Override
    public Category requestDtoToEntity(CategoryRequest source) {
        Category category = new Category();
        BeanUtils.copyProperties(source,category);
        return category;
    }

}
