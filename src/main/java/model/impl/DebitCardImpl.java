package model.impl;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import model.def.DebitCard;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class DebitCardImpl
implements DebitCard {

    @NonNull
    private BigDecimal dailyWithdrawalLimit;
    Set<String> transactionHistory;
}
