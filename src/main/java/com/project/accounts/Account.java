package com.project.accounts;

import com.project.model.Card;
import com.project.model.bank.Bank;
import com.project.model.user.UserAccount;
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


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="bank_accounts")
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    @Column(name="account_number", nullable = false)
    private String accountNumber;                       //TODO - Hash it during service-repository

    @NotNull
    @ManyToOne
    @JoinColumn(name="user_account_id", nullable = false)
    private UserAccount accountHolder;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @NotNull
    @ManyToMany
    @JoinColumn(name = "id")
    private Set<Bank> associatedBankingInstitution; //TODO will change along with Bank

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
