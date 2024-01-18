package com.akkoeCommerce.payload.request;

import com.akkoeCommerce.entity.Product;
import com.akkoeCommerce.entity.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerProductRequest {
    private Seller seller;
    private Product product;
}
