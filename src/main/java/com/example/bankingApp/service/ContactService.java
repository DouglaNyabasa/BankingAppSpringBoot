package com.example.bankingApp.service;

import com.example.bankingApp.dto.ContactDTo;
import com.example.bankingApp.generics.service.GenericService;

import java.util.List;


public interface ContactService extends GenericService<ContactDTo> {

    List<ContactDTo> findAllByUserId(Long userId);
}
