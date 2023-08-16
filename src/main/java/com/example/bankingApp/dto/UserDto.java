package com.example.bankingApp.dto;

import com.example.bankingApp.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author Douglas Nyabasa
 * created on 8/10/2023
 */
@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;

    @NotNull(message = "firstname should not be Null")
    @NotEmpty(message = "firstname should not be empty !!! ")
    @NotBlank(message = "firstname should not be blank !!!")
    private String firstname;

    @NotNull(message = "lastname should not be Null")
    @NotEmpty(message = "lastname should not be empty !!!")
    @NotBlank(message = "lastname should not be blank !!!")
    private String lastname;

    @NotNull(message = "email should not be Null")
    @NotEmpty(message = "email should not be empty !!!")
    @NotBlank(message = "email should not be blank !!!")
    @Email(message = "wrong email format !!! please enter again")
    private String email;

    @NotNull(message = "password should not be Null")
    @NotEmpty(message = "password should not be empty !!!")
    @NotBlank(message = "password should not be blank !!!")
    @Size(min = 8, max = 16, message = "password must have at-least 8 et 16 characters")
    private String password;

    private String iban;

    private boolean active;

    public static UserDto fromEntity(User user) {
        // null check
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .iban(user.getAccount() == null ? "" : user.getAccount().getIban())
                .active(user.isActive())
                .build();
    }

    public static User toEntity(UserDto user) {
        // null check
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
