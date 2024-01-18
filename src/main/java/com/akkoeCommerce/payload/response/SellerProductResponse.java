package com.akkoeCommerce.payload.response;

import com.akkoeCommerce.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerProductResponse {
    private Long sellerID;
    private Product product;
}
