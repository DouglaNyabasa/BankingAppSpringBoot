package com.example.bankingApp.repository;

import com.example.bankingApp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByUserId(Integer userId);

}
