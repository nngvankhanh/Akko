package com.akkoeCommerce.service.Impl;

import com.akkoeCommerce.converter.UserConverter;
import com.akkoeCommerce.entity.User;
import com.akkoeCommerce.payload.request.LoginRequest;
import com.akkoeCommerce.payload.request.RegisterRequest;
import com.akkoeCommerce.repository.UserRepository;
import com.akkoeCommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private UserConverter userConverter;

    @Override
    public boolean isLogin(LoginRequest loginRequest) {
        boolean result = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).isPresent();
        return result;
    }

    @Override
    public boolean isRegister(RegisterRequest registerRequest) {
        boolean result = false;
        boolean isEmail = userRepository.findByEmail(registerRequest.getEmail()).isPresent();
        if(registerRequest.getPassword().equals(registerRequest.getConfirmPassword()) && !isEmail){
            result = true;
        }
        return result;
    }

    @Override
    public User save(RegisterRequest registerRequest) {
        User user = userConverter.convertToEntity(registerRequest);
        User newUser = userRepository.save(user);
        return newUser;
    }
}
