package com.example.bankingApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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
public class Transaction extends BaseEntity {
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private String destinationIban;

    @Column(updatable = false)
    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
