package com.project.model.banks;

import com.project.model.accounts.AccountHistory;
import com.project.model.cards.Card;
import com.project.model.users.UserAccount;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;


/**
 * This class, specifies the entity of the Bank BankAccount that a user of the Bank might have.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="bank_accounts")
@EntityListeners(AuditingEntityListener.class)
public class BankAccount {

    @Id
    @Column(name="account_number", nullable = false)
    private String accountNumber;                       //TODO - Hash it during service-repository

    @ManyToOne
    @JoinColumn(name="user_account_id", nullable = false)
    private UserAccount accountHolder;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @ManyToMany
    @JoinColumn(name = "id")
    @NotNull
    private Set<Bank> associatedBankingInstitution;

    @OneToOne
    @JoinColumn(name = "card_number")
    @Column(name = "card", nullable = false)
    private Card card;

    @OneToOne
    @Column(name = "account_history")
    private AccountHistory accountHistory;

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
