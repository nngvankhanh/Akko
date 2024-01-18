package com.akkoeCommerce.converter.Impl;

import com.akkoeCommerce.converter.ProductConverter;
import com.akkoeCommerce.entity.Category;
import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.entity.SellerProduct;
import com.akkoeCommerce.payload.request.ProductRequest;
import com.akkoeCommerce.payload.response.ProductResponse;
import com.akkoeCommerce.entity.Product;
import lombok.AllArgsConstructor;
import org.apache.maven.model.Build;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@AllArgsConstructor
public class ProductConverterImpl implements ProductConverter {

    @Override
    public ProductResponse convertToDto(Product product) {
//        ProductResponse productResponse = new ProductResponse();
//        BeanUtils.copyProperties(product, productResponse);
//        Collection<SellerProduct> sellerProducts = product.getSellerProduct();
//        SellerProduct sellerProduct = new SellerProduct();
//        Category category = product.getCategory();
//        for (SellerProduct sellerProductList : sellerProducts) {
//            sellerProduct.setSeller(sellerProductList.getSeller());
//        }
//        Seller seller = sellerProduct.getSeller();
//        productResponse.setSellerId(seller.getId());
//        productResponse.setCategoryId(category.getId());

       return ProductResponse.builder()
               .id(product.getId())
               .name(product.getName())
               .quantity(product.getQuantity())
               .price(product.getPrice())
               .image(product.getImage())
               .category(product.getCategory())
               .build();
    }

    @Override
    public Product requestDtoToEntity(ProductRequest source) {
        Product product = new Product();
        BeanUtils.copyProperties(source, product);
        return product;
    }
}
