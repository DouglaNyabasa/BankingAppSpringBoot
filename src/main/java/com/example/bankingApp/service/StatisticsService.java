package com.example.bankingApp.service;

import com.example.bankingApp.dto.TransactionSumDetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface StatisticsService {
    List<TransactionSumDetails> findSumTransactionsByDate(LocalDate startDate, LocalDate endDate, Integer userId);

    BigDecimal getAccountBalance(Integer userId);

    BigDecimal highestTransfer(Integer userId);

    BigDecimal highestDeposit(Integer userId);
}
