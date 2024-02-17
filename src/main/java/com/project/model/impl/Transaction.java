package com.project.model.impl;

import com.project.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NonNull
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @NonNull
    @Column(name="transaction_id")
    private String transactionId;

    @NonNull
    @Column(name = "account_number")
    private String accountNumber;

    @NonNull
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @NonNull
    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;

    @NonNull
    @Column(name = "transaction_date_and_time")
    private LocalDateTime transactionDateAndTime;

    @NonNull
    @Column(name="balance_before_transaction")
    private BigDecimal balanceBeforeTransaction;

    @NonNull
    @Column(name = "balance_after_transaction")
    private BigDecimal balanceAfterTransaction;

    @Column(name = "receiver_account_number")
    private String receiverAccountNumber;

    @ManyToOne
    @JoinColumn(name = "debit_card_number")
    private DebitCard debitCard;

    @ManyToOne
    @JoinColumn(name = "credit_card_number")
    private CreditCard creditCard;
}
