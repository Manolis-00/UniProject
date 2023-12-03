package model.impl;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import model.def.Account;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountImpl
implements Account {

    @NonNull
    private String accountNumber;
    private DebitCardImpl associatedDebitCard;
    private String history;
    private BigDecimal balance;
}
