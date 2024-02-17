package com.project.model.impl;

import com.project.model.def.Card;
import com.project.model.enums.Bank;
import com.project.model.enums.PaymentProcessingNetwork;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="debit_cards")
public class DebitCard implements Card {

    @Id
    @NonNull
    @Column(name="debit_card_number")
    private Integer debitCardNumber;

    @NonNull
    @Column(name="security_code")
    private Integer securityCode;

    @NonNull
    @Column(name = "owner_name")
    private String ownerName;

    @NonNull
    @Column(name="valid_thru_date")
    private LocalDate validThruDate;

    @NonNull
    @Column(name = "card_payment_processing_network")
    private PaymentProcessingNetwork cardPaymentProcessingNetwork;

    @NonNull
    @Column(name="card_bank")
    private Bank cardBank;

    @NonNull
    @Column(name="card_daily_withdrawals_limit")
    private Integer cardDailyWithdrawalsLimit;

    @NonNull
    @Column(name="card_daily_withdrawal_amount_limit")
    private BigDecimal cardDailyWithdrawalAmountLimit;

    @NonNull
    @Column(name = "card_PIN_code")
    private Integer cardPINCode;

    @NonNull
    @ManyToMany(mappedBy = "transactionId")
    private Set<Transaction> cardTransactionHistory;

    @NonNull
    @Column(name="bank_account")
    private String respectiveBankAccountNumber; //TODO - make an Account class. There will probably a one-to-many relationship account-cards.
}
