package com.project.model.user;

import com.project.model.impl.AccountCredentials;
import com.project.model.impl.Address;
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

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @NotNull
    @Column(name="social_security_number")
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

    @Size(min = 10, max = 10, message = "Phone number must have precisely 10 digits.")
    @Column(name="phone_number", nullable = false)
    private Long phoneNumber;

    @OneToMany
    @JoinColumn(name="address_id")
    @Column(name = "address", nullable = false)
    private Set<Address> addresses;

    @NotNull
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @Column(name = "account_credentials", nullable = false)
    @OneToOne
    @JoinColumn(name = "username", nullable = false)
    private AccountCredentials accountCredentials;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
