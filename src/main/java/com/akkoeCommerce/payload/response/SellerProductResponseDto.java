package com.akkoeCommerce.payload.response;

import com.akkoeCommerce.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerProductResponseDto {
    private Long sellerID;
    private Product product;
}
