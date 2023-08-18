package com.example.bankingApp.serviceImpl;

import com.example.bankingApp.dto.TransactionDto;
import com.example.bankingApp.model.Transaction;
import com.example.bankingApp.model.TransactionType;
import com.example.bankingApp.repository.TransactionalRepository;
import com.example.bankingApp.service.TransactionalService;

import com.example.bankingApp.validator.ObjectsValidator;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionalService {

    private final TransactionalRepository transactionRepository;
    private final ObjectsValidator<TransactionDto> objectsValidator;

    public TransactionServiceImpl(TransactionalRepository transactionRepository, ObjectsValidator<TransactionDto> objectsValidator) {
        this.transactionRepository = transactionRepository;
        this.objectsValidator = objectsValidator;
    }

    @Override
    public Integer save(TransactionDto dto) {
        objectsValidator.validate(dto);
        Transaction transaction = TransactionDto.toEntity(dto);
        BigDecimal transactionCharges = BigDecimal.valueOf(getTransactionMultiplier(transaction.getType()));
        BigDecimal amount = transaction.getAmount().multiply(transactionCharges);
        transaction.setAmount(amount);
        return Math.toIntExact(transactionRepository.save(transaction).getId());
    }

    private long getTransactionMultiplier(TransactionType type) {
        return TransactionType.TRANSFER == type ? -1:1;
    }

    @Override
    public List<TransactionDto> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto findById(Long id) {
        return transactionRepository.findById(id)
                .map(TransactionDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No transaction was found with the ID: " + id));
    }

    @Override
    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public List<TransactionDto> findAllByUserId(Long userId) {
        return transactionRepository.findAllByUserId(Math.toIntExact(userId))
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }
}
