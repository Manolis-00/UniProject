package com.project.model.enums;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum TransactionType {

    DEPOSIT(new BigDecimal("0.0")),

    WITHDRAWAL_FROM_SAME_BANK(new BigDecimal("0.0")),

    WITHDRAWAL_FROM_OTHER_BANK(new BigDecimal("0.5")),

    TRANSFER(new BigDecimal("0.5")),

    INTEREST(new BigDecimal("0.0")),

    SERVICE_CHARGE(new BigDecimal("0.1")),

    PENALTY(new BigDecimal("1.0"));

    private final BigDecimal bankTransactionFee;

    TransactionType(BigDecimal bankTransactionFee) {
        this.bankTransactionFee = bankTransactionFee;
    }

    @Override
    public String toString() {
        return "TransactionType{}";
    }
}
