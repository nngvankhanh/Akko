package com.akkoeCommerce.converter.Impl;

import com.akkoeCommerce.converter.SellerProductConverter;
import com.akkoeCommerce.payload.request.SellerProductRequestDto;
import com.akkoeCommerce.payload.response.SellerProductResponseDto;
import com.akkoeCommerce.entity.SellerProduct;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class SellerProductConverterImpl implements SellerProductConverter {

    @Override
    public Collection<SellerProductResponseDto> entityToResponseDto(Collection<SellerProduct> source) {
        List<SellerProductResponseDto> list = new ArrayList<>();
        SellerProductResponseDto sellerProductResponseDto = new SellerProductResponseDto();
        for(SellerProduct sellerProduct : source){
            sellerProductResponseDto.setProduct(sellerProduct.getProduct());
//            sellerProductResponseDto.setSeller(sellerProduct.getSeller());
            list.add(sellerProductResponseDto);
        }
        return list;
    }

    @Override
    public Collection<SellerProduct> requestDtoToEntity(Collection<SellerProductRequestDto> source) {
        Collection<SellerProduct> sellerProducts = new ArrayList<>();
        SellerProduct sellerProduct = new SellerProduct();
        for(SellerProductRequestDto sources : source){
            BeanUtils.copyProperties(sources,sellerProduct);
            sellerProducts.add(sellerProduct);
        }
        return sellerProducts;
    }

    @Override
    public SellerProductResponseDto entityToResponseDto(SellerProduct source) {
        return null;
    }

    @Override
    public SellerProduct requestDtoToEntity(SellerProductRequestDto source) {
        return null;
    }
}
