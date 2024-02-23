package com.project.model.user;

import com.project.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="user_accounts")
public class UserAccount {

    @Id
    @Column(name="social_security_number", nullable = false)
    private String socialSecurityNumber;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "social_security_number")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name="user_account_status")
    private UserAccountStatus userAccountStatus;

    @Version
    private Integer version;
}
