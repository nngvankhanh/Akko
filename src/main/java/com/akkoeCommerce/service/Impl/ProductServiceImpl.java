package com.akkoeCommerce.service.Impl;

import com.akkoeCommerce.converter.ProductConverter;
import com.akkoeCommerce.entity.SellerProduct;
import com.akkoeCommerce.payload.request.ProductRequestDto;
import com.akkoeCommerce.entity.Category;
import com.akkoeCommerce.entity.Product;
import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.repository.CategoryRepository;
import com.akkoeCommerce.repository.ProductRepository;
import com.akkoeCommerce.repository.SellerProductRepository;
import com.akkoeCommerce.repository.SellerRepository;
import com.akkoeCommerce.service.ProductService;
import com.akkoeCommerce.payload.response.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SellerProductRepository sellerProductRepository;
    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Iterable<ProductResponseDto> findAll() {
         Iterable<Product> products = productRepository.findAll();
         List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
         for(Product product : products){
             ProductResponseDto productResponseDto= productConverter.entityToResponseDto(product);
             productResponseDtoList.add(productResponseDto);
         }
         return productResponseDtoList;
    }

    @Override
    public Optional<ProductResponseDto> findById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductResponseDto productResponseDto = productConverter.entityToResponseDto(product);
        return Optional.ofNullable(productResponseDto);
    }

    @Override
    public void save(ProductRequestDto productRequestDto) {
         try{
             Category category = categoryRepository.findById(productRequestDto.getCategoryId())
                     .orElseThrow(() -> new IllegalArgumentException("Invalid category id"));
            Optional<Seller> seller = sellerRepository.findById(productRequestDto.getSellerId());
             SellerProduct sellerProduct = new SellerProduct();
             sellerProduct.setSeller(seller.get());//lấy đối tượng
             Product product = productConverter.requestDtoToEntity(productRequestDto);
             product.setCategory(category);
             Product productSave = productRepository.save(product);
             sellerProduct.setProduct(productSave);
             if(productRequestDto.getId() == null){
                 sellerProductRepository.save(sellerProduct);
             }
         }catch (Exception e){
             e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}
