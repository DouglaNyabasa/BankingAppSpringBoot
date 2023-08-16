package com.example.bankingApp.dto;

import com.example.bankingApp.model.Account;
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
public class AccountDto {
    private Long id;

    private String iban;

    private UserDto user;

    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(UserDto.fromEntity(account.getUser()))
                .build();

    }

    public static Account toEntity(AccountDto account) {
        return Account.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(UserDto.toEntity(account.getUser()))
                .build();

    }
}
