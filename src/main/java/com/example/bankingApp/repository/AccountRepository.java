package com.example.bankingApp.repository;

import com.example.bankingApp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByIban(String iban);

    Optional<Account> findByUserId(Integer id);
}
