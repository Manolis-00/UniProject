package com.project.model.impl;

import com.project.model.enums.Bank;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name="bank_account")
public class BankAccount {

    @Id
    @NotNull
    @Column(name="account_number")
    private String accountNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name="user_account_id")
    @Column(name = "account_holder")
    private UserAccount accountHolder;

    @NotNull
    @Column(name = "balance")
    private BigDecimal balance;

    @NotNull
    @Column(name="banking_institution")
    private Bank associatedBankingInstitution;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "id")
    @NotNull
    private AccountCredentials credentials;

    public BankAccount() {
        //empty constructor
    }

    public BankAccount(String accountNumber, UserAccount accountHolderName) {
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolderName;
        this.balance = new BigDecimal("0.00");
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
           balance.add(amount);
        }
    }

    public void withdraw(BigDecimal amount) {
        if ((amount.compareTo(BigDecimal.ZERO) > 0) && (balance.compareTo(amount) > 0)) {
            balance.subtract(amount);
        }
    }

    public void transfer(BigDecimal amount, BankAccount targetAccount) {
        if ((amount.compareTo(BigDecimal.ZERO) > 0) && (balance.compareTo(amount) < 0)) {
            withdraw(amount);
            targetAccount.deposit(amount);
        }
    }

    public void closeAccount() {
        //TODO - Remove the account from the table, and from the associated tables.
    }
}
