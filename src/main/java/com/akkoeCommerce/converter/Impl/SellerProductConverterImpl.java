package com.akkoeCommerce.converter.Impl;

import com.akkoeCommerce.converter.SellerProductConverter;
import com.akkoeCommerce.payload.request.SellerProductRequest;
import com.akkoeCommerce.payload.response.SellerProductResponse;
import com.akkoeCommerce.entity.SellerProduct;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class SellerProductConverterImpl implements SellerProductConverter {

    @Override
    public Collection<SellerProductResponse> entityToResponseDto(Collection<SellerProduct> source) {
        List<SellerProductResponse> list = new ArrayList<>();
        SellerProductResponse sellerProductResponse = new SellerProductResponse();
        for(SellerProduct sellerProduct : source){
            sellerProductResponse.setProduct(sellerProduct.getProduct());
//            sellerProductResponseDto.setSeller(sellerProduct.getSeller());
            list.add(sellerProductResponse);
        }
        return list;
    }

    @Override
    public Collection<SellerProduct> requestDtoToEntity(Collection<SellerProductRequest> source) {
        Collection<SellerProduct> sellerProducts = new ArrayList<>();
        SellerProduct sellerProduct = new SellerProduct();
        for(SellerProductRequest sources : source){
            BeanUtils.copyProperties(sources,sellerProduct);
            sellerProducts.add(sellerProduct);
        }
        return sellerProducts;
    }

    @Override
    public SellerProductResponse entityToResponseDto(SellerProduct source) {
        return null;
    }

    @Override
    public SellerProduct requestDtoToEntity(SellerProductRequest source) {
        return null;
    }
}
