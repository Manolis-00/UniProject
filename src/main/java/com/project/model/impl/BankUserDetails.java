package com.project.model.impl;

import com.project.model.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="bank_user_details")
public class BankUserDetails {

    @Id
    @NotNull
    @Column(name="social_security_number")
    private String socialSecurityNumber;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name="lastName")
    private String lastName;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="phone_number")
    private Long phoneNumber;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "has_active_bank_account")
    private Boolean hasActiveBankAccount;

    @NotNull
    @Column(name = "user_role")
    private UserRole userRole;
}
