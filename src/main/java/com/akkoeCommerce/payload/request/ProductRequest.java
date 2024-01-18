package com.akkoeCommerce.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long id;
    private String name;
    private int quantity;
    private Double price;
    private Long categoryId;
    private Long sellerId;
}
