package com.akkoeCommerce.service.Impl;

import com.akkoeCommerce.entity.User;
import com.akkoeCommerce.repository.UserRepository;
import com.akkoeCommerce.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).isPresent();
    }

    @Override
    public boolean findByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
