package model.impl;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import model.def.CreditCard;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class CreditCardImpl implements CreditCard {

    @NonNull private Integer creditScore;
    @NonNull private BigDecimal creditLimit;
    @NonNull private BigDecimal creditBalance;
    Set<String> transactionHistory;
}
