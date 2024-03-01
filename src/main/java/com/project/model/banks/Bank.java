package com.project.model.banks;

import com.project.model.Address;
import com.project.model.Telephone;
import com.project.model.cards.Card;
import com.project.model.users.UserAccount;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * The Bank entity.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "banks")
@EntityListeners(AuditingEntityListener.class)
public class Bank {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    @Column(name = "id")
    private UUID id;

    @Size(max =  255, message = "Name cannot exceed 255 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @NotNull
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private Set<Telephone> telephones;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Card> cards;

    @Email()
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "bank_accounts",
            joinColumns =  @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_number")
    )
    private Set<UserAccount> accounts;

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
