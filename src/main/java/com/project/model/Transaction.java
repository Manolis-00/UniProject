package com.project.model;

import com.project.model.cards.Card;
import com.project.model.cards.CardHistory;
import com.project.model.enums.TransactionType;
import com.project.model.users.UserAccountHistory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@NonNull
@Entity
@Table(name = "transaction")
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    @Column(name = "id")
    private UUID id;

    @Size(max =  16, message = "UserAccount number cannot exceed 255 characters")
    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "id")
    private UserAccountHistory userAccountHistory;

    @ManyToOne
    @JoinColumn(name = "id")
    private CardHistory cardHistory;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "transaction_amount",nullable = false)
    private BigDecimal transactionAmount;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @Column(name="balance_before_transaction", nullable = false)
    private BigDecimal balanceBeforeTransaction;

    @Column(name = "balance_after_transaction", nullable = false)
    private BigDecimal balanceAfterTransaction;

    @Size(max =  16, message = "UserAccount number cannot exceed 255 characters")
    @Column(name = "receiver_account_number", nullable = false)
    private String receiverAccountNumber;      //TODO - There is a chance that the String will be replaced by the UserAccount.

    @ManyToOne
    @JoinColumn(name = "card_number")
    private Card debitCard;

    @ManyToOne
    @JoinColumn(name = "card_number")
    private Card creditCard;

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
