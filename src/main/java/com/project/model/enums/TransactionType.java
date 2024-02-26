package com.project.model.enums;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * An enum of the available processing networks
 */
@Getter
public enum TransactionType {

    DEPOSIT,
    INTEREST,
    PENALTY,
    SERVICE_CHARGE,
    TRANSFER,
    WITHDRAWAL_FROM_OTHER_BANK,
    WITHDRAWAL_FROM_SAME_BANK;

}
