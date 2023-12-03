package model.impl;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import model.def.Card;

import java.time.LocalDate;

@Getter
@Setter
@NonNull
public class CardImpl
implements Card {

    private String provider;
    private Integer number;
    private Integer securityNumber;
    private String cardHolderName;
    private LocalDate issueDate;
    private LocalDate expirationDate;
}
