package com.akkoeCommerce.entity;

import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Pattern(regexp = "^[a-zA-Z0-9_]{4,}$")
    private String userName;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{6,10}$")
    @Size(min = 6, max = 10, message = "password phải chứa ít nhất 6 đến 10 ký tự")
    private String password;
    private String address;
    @Pattern(regexp = "^\\+?(?:\\d{2})?[0]\\d{9}$")
    private String phoneNumber;
    private byte sex;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDate birthDate;
    @URL
    private String avatar;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
