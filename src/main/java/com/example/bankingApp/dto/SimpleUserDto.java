package com.example.bankingApp.dto;

import com.example.bankingApp.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Douglas Nyabasa
 * created on 8/10/2023
 */
@Data
@AllArgsConstructor
@Builder
public class SimpleUserDto {
    private Long id;

    @NotNull(message = "firstname should not be Null")
    @NotEmpty(message = "firstname should not be empty !!! ")
    @NotBlank(message = "firstname should not be blank !!!")
    private String firstname;

    @NotNull(message = "lastname should not be Null")
    @NotEmpty(message = "lastname should not be empty !!!")
    @NotBlank(message = "lastname should not be blank !!!")
    private String lastname;

    public static SimpleUserDto fromEntity(User user) {
        // null check
        return SimpleUserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();
    }

    public static User toEntity(SimpleUserDto user) {
        // null check
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();
    }
}
