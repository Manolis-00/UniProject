package com.project.model.users;

import com.project.model.Address;
import com.project.model.Telephone;
import com.project.model.banks.Bank;
import com.project.model.cards.Card;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
 * This class, specifies the entity of the Bank UserAccount that a user of the Bank might have.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user_accounts")
@EntityListeners(AuditingEntityListener.class)
public class UserAccount {

    @Id
    @Column(name="account_number", nullable = false)
    private String accountNumber;                       //TODO - Hash it during service-repository

    @Column(name="social_security_number", nullable = false)
    private String socialSecurityNumber;

    @Size(min = 1, max = 255, message = "The first name must not be null or empty and must be at most 255 characters.")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 1, max = 255, message = "Last name must not be null or empty, and must be at most 255 characters.")
    @Column(name="lastName", nullable = false)
    private String lastName;

    @Size(min = 1, max = 255, message = "Email must not be null or empty, and must be at most 255 characters.")
    @Column(name="email", nullable = false)
    private String email;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "number", referencedColumnName = "telephone_id")
    private Telephone telephone;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "address_id")
    private Address address;

    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @Enumerated(EnumType.STRING)
    @Column(name="user_account_status", nullable = false)
    private UserAccountStatus userAccountStatus;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_history_id", referencedColumnName = "user_account_history_id")
    private UserAccountHistory userAccountHistory;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Card> cards;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private UserAccountCredentials userAccountCredentials;

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
