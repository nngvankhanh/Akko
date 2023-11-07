package com.akkoeCommerce.payload.request;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String email;
    private String password;
    private String confirmPassword;
}
