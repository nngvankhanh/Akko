package com.akkoeCommerce.service;

import com.akkoeCommerce.entity.User;


public interface UserService {
    boolean findByEmail(String email);
    void save(User user);
    boolean findByEmailAndPassword(String email, String password);
}
