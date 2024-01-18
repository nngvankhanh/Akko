package com.akkoeCommerce.service.Impl;

import com.akkoeCommerce.converter.CartConverter;
import com.akkoeCommerce.entity.Cart;
import com.akkoeCommerce.entity.Product;
import com.akkoeCommerce.entity.User;
import com.akkoeCommerce.payload.request.CartRequest;
import com.akkoeCommerce.repository.CartRepository;
import com.akkoeCommerce.repository.ProductRepository;
import com.akkoeCommerce.repository.UserRepository;
import com.akkoeCommerce.service.CartService;
import com.akkoeCommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartConverter cartConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Cart> save(CartRequest cartRequest, Long idProduct) {
        Cart cart = cartConverter.convertToEntity(cartRequest);
        Product product = productRepository.findById(idProduct).get();
        cart.setProduct(product);
        Long idUser = 1L;
        User user =  userRepository.findById(idUser).get();
        cart.setUser(user);
        cartRepository.save(cart);
        List<Cart> cartList = cartRepository.findAllByUser_Id(idUser);
        return cartList;
    }
}
