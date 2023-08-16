package com.example.bankingApp.dto;

import com.example.bankingApp.model.Contact;
import com.example.bankingApp.model.User;
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
public class ContactDTo {
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String iban;

    private Long userId;

    public static ContactDTo fromEntity(Contact contact) {
        return ContactDTo.builder()
                .id(contact.getId())
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .userId(contact.getUser().getId())
                .build();

    }

    public static Contact toEntity(ContactDTo contact) {
        return Contact.builder()
                .id(contact.getId())
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .user(
                        User.builder()
                                .id(contact.getUserId())
                                .build()
                )
                .build();
    }
}
