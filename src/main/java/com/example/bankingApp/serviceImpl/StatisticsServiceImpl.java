package com.example.bankingApp.serviceImpl;

import com.example.bankingApp.dto.TransactionSumDetails;
import com.example.bankingApp.model.TransactionType;
import com.example.bankingApp.repository.TransactionalRepository;
import com.example.bankingApp.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private final TransactionalRepository transactionRepository;

    public StatisticsServiceImpl(TransactionalRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionSumDetails> findSumTransactionsByDate(LocalDate startDate, LocalDate endDate, Integer userId) {
        LocalDateTime start = LocalDateTime.of(startDate, LocalTime.of(0,0,0));
        LocalDateTime end = LocalDateTime.of(endDate,LocalTime.of(23,59,59));

        return transactionRepository.findSumTransactionsByDate(start,end,userId);
    }

    @Override
    public BigDecimal getAccountBalance(Integer userId) {
        return transactionRepository.findAccountBalance(userId);
    }

    @Override
    public BigDecimal highestTransfer(Long userId) {
        return transactionRepository.findHighestAmountByTransactionType(Math.toIntExact(userId), TransactionType.TRANSFER);
    }

    @Override
    public BigDecimal highestDeposit(Long userId) {
        return  transactionRepository.findHighestAmountByTransactionType(Math.toIntExact(userId), TransactionType.DEPOSIT);
    }
}
