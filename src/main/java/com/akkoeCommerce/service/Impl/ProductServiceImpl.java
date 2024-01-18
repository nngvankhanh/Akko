package com.akkoeCommerce.service.Impl;

import com.akkoeCommerce.converter.ProductConverter;
import com.akkoeCommerce.entity.SellerProduct;
import com.akkoeCommerce.payload.request.ProductRequest;
import com.akkoeCommerce.entity.Category;
import com.akkoeCommerce.entity.Product;
import com.akkoeCommerce.entity.Seller;
import com.akkoeCommerce.repository.CategoryRepository;
import com.akkoeCommerce.repository.ProductRepository;
import com.akkoeCommerce.repository.SellerProductRepository;
import com.akkoeCommerce.repository.SellerRepository;
import com.akkoeCommerce.service.ProductService;
import com.akkoeCommerce.payload.response.ProductResponse;
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
    public Iterable<ProductResponse> findAll() {
         Iterable<Product> products = productRepository.findAll();
         List<ProductResponse> productResponseList = new ArrayList<>();
         for(Product product : products){
             ProductResponse productResponse = productConverter.convertToDto(product);
             productResponseList.add(productResponse);
         }
         return productResponseList;
    }

    @Override
    public Optional<ProductResponse> findById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductResponse productResponseDto = productConverter.convertToDto(product);
        return Optional.ofNullable(productResponseDto);
    }

    @Override
    public List<ProductResponse> findProductListByCategoryId(Long id){
        List<Product> productList = productRepository.findByCategory_Id(id);
        ArrayList<ProductResponse> productResponseArrayList = new ArrayList<>();
        for(Product product : productList){
            ProductResponse productResponse = productConverter.convertToDto(product);
            productResponseArrayList.add(productResponse);
        }
        return productResponseArrayList;
    }

    @Override
    public void save(ProductRequest productRequest) {
         try{
             Category category = categoryRepository.findById(productRequest.getCategoryId())
                     .orElseThrow(() -> new IllegalArgumentException("Invalid category id"));
            Optional<Seller> seller = sellerRepository.findById(productRequest.getSellerId());
             SellerProduct sellerProduct = new SellerProduct();
             sellerProduct.setSeller(seller.get());//lấy đối tượng
             Product product = productConverter.requestDtoToEntity(productRequest);
             product.setCategory(category);
             Product productSave = productRepository.save(product);
             sellerProduct.setProduct(productSave);
             if(productRequest.getId() == null){
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
