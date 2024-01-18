package com.akkoeCommerce.service;

import com.akkoeCommerce.entity.User;
import com.akkoeCommerce.payload.request.LoginRequest;
import com.akkoeCommerce.payload.request.RegisterRequest;


public interface UserService {
    boolean isRegister(RegisterRequest registerRequest);
    User save(RegisterRequest registerRequest);
    boolean isLogin(LoginRequest loginRequest);

}