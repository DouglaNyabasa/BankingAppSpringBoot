package com.example.bankingApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
/**
 * @author Douglas Nyabasa
 * created on 8/10/2023
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_user")
public class User extends BaseEntity {

    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean active;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;

    @OneToOne
    private Account account;

    @OneToOne
    private Role role;
}
