package com.project.model;

import com.project.model.banks.Bank;
import com.project.model.users.UserAccount;
import jakarta.persistence.*;
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
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "addresses")
@EntityListeners(AuditingEntityListener.class)  //TODO - Check the documentation
public class Address {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    @Column(name = "address_id")
    private UUID addressId;

    @Size(max =  255, message = "Street must be at most  255 characters")
    @Column(name = "street")
    private String street;

    @Size(min = 1, max =  255, message = "City must not be blank or null, and must be at most  255 characters")
    @Column(name = "city", nullable = false)
    private String city;

    @Size(min = 1, max =  255, message = "County must not be blank or null, and must be at most  255 characters")
    @Column(name="county", nullable = false)
    private String county;

    @Size(max =  255, message = "Country must be at most  255 characters")
    @Column(name = "country", nullable = false)
    private String country;

    @Size(min = 5, max =  10, message = "Postal code must be between 5 and 10 characters")
    @Column(name = "postalcode", nullable = false)
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToOne
    @JoinColumn(name = "account_number")
    private UserAccount userAccount;

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
