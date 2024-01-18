package com.akkoeCommerce.entity;

import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
//
//    @Column(name = "FIRST_NAME")
//    private String firstName;
//
//    @Column(name = "LAST_NAME")
//    private String lastName;
//    @Pattern(regexp = "^[a-zA-Z0-9_]{4,}$")

//    @Column(name = "USERNAME")
//    private String userName;

    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    Collection<Cart> carts;

//    @Column(name = "ADDRESS")
//    private String address;
//
//    @Pattern(regexp = "^\\+?(?:\\d{2})?[0]\\d{9}$")
//    @Column(name = "PHONE_NUMBER")
//    private String phoneNumber;
//
//    @Column(name = "IS_SEX")
//    private byte isSex;
//
//    @DateTimeFormat(pattern = "dd/mm/yyyy")
//    @Column(name = "BIRTH_DATE")
//    private LocalDate birthDate;
//
//    @URL
//    @Column(name = "AVATAR")
//    private String avatar;
}
