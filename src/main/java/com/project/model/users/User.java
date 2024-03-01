package com.project.model.users;

import com.project.model.Address;
import com.project.model.Telephone;
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

/**
 * The basic User entity. Specifies the general information of a person, who could potentially start a bank account, or get a Card.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
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
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private Set<Telephone> telephones;

    @NotNull
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserAccount> userAccounts;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
