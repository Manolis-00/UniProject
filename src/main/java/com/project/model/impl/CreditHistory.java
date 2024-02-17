package com.project.model.impl;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="credit_history")
public class CreditHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_history_id")
    private Long creditHistoryId;

    @Column(name = "credit_inquiries")
    private Integer creditInquiries;

    @OneToMany
    @JoinColumn(name = "credit_card_number")
    private List<CreditCard> functionalCreditCards;

    @OneToMany
    @JoinColumn(name = "credit_card_number")
    private List<CreditCard> closedCreditCards;
}
