package com.example.bankingApp.service;

import com.example.bankingApp.dto.TransactionDto;
import com.example.bankingApp.generics.service.GenericService;

import java.util.List;


public interface TransactionalService extends GenericService<TransactionDto> {
    List<TransactionDto> findAllByUserId(Long userId);
}
