package com.akkoeCommerce.converter.Impl;

import com.akkoeCommerce.converter.ProductConverter;
import com.akkoeCommerce.entity.Category;
import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.entity.SellerProduct;
import com.akkoeCommerce.payload.request.ProductRequestDto;
import com.akkoeCommerce.payload.response.ProductResponseDto;
import com.akkoeCommerce.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@AllArgsConstructor
public class ProductConverterImpl implements ProductConverter {
    @Override
    public ProductResponseDto entityToResponseDto(Product source) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        BeanUtils.copyProperties(source, productResponseDto);
        Collection<SellerProduct> sellerProducts = source.getSellerProduct();
        SellerProduct sellerProduct = new SellerProduct();
        Category category = source.getCategory();
        for (SellerProduct sellerProductList : sellerProducts) {
            sellerProduct.setSeller(sellerProductList.getSeller());
        }
        Seller seller = sellerProduct.getSeller();
        productResponseDto.setSellerId(seller.getId());
        productResponseDto.setCategoryId(category.getId());
        return productResponseDto;
    }

    @Override
    public Product requestDtoToEntity(ProductRequestDto source) {
        Product product = new Product();
        BeanUtils.copyProperties(source, product);
        return product;
    }
}
