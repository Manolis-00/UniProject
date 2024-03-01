package com.project.model.cards;

import com.project.model.Transaction;
import com.project.model.banks.Bank;
import com.project.model.users.UserAccount;
import com.project.model.enums.PaymentProcessingNetwork;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cards")
@EntityListeners(AuditingEntityListener.class)
public class Card {

    @Id
    @Size(min = 16, max = 16, message = "Card number must be exactly 16 characters")
    @Column(name="card_number", nullable = false)           //TODO - Hash it
    private Integer cardNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number")
    private UserAccount UserAccount;

    @Size(min = 3, max = 3, message = "Security code must be exactly 3 characters")
    @Column(name="security_code", nullable = false)         //TODO - Hash it
    private Integer securityCode;

    @Size(min = 4, max = 4, message = "PIN code must be exactly 4 characters")
    @Column(name = "card_pin_code", nullable = false)       //TODO - Hash it
    private Integer cardPINCode;

    @Column(name="valid_thru_date", nullable = false)
    private LocalDate validThruDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_payment_processing_network", nullable = false)
    private PaymentProcessingNetwork cardPaymentProcessingNetwork;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_history_id", referencedColumnName = "id")
    private CardHistory cardHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Bank cardBank;

    @Column(name="card_daily_withdrawals_limit", nullable = false)
    private Integer cardDailyWithdrawalsLimit;

    @Column(name="card_daily_withdrawal_amount_limit", nullable = false)
    private BigDecimal cardDailyWithdrawalAmountLimit;

    @ManyToMany(mappedBy = "id")
    private Set<Transaction> cardTransactionHistory;

    @Column(name = "credit_score")        //TODO - Validator must be set on the services, to determine whether it is credit or debit card.
    private BigDecimal creditScore;

    @Column(name = "credit_limit")        //TODO - Validator must be set on the services, to determine whether it is credit or debit card.
    private BigDecimal creditLimit;

    @Column(name="credit_balance")        //TODO - Validator must be set on the services, to determine whether it is credit or debit card.
    private BigDecimal creditBalance;

    @Column(name="credit_utilization")    //TODO - Validator must be set on the services, to determine whether it is credit or debit card.
    private Double creditUtilization;

    @Column(name="bank_account")
    private String respectiveBankAccountNumber; //TODO - Only for debitCards.

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;
}
