package com.example.bankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Douglas Nyabasa
 * created on 8/10/2023
 */
@Data
@AllArgsConstructor
@Builder
public class AuthenticationRequest {
    private String email;
    private String password;
}
