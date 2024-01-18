package com.akkoeCommerce.payload.response;

import com.akkoeCommerce.entity.Category;
import com.akkoeCommerce.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private int quantity;
    private Double price;
    private Image image;
    private Category category;
//    private Long sellerId;
}
