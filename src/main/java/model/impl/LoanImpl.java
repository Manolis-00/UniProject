package model.impl;

import lombok.Getter;
import lombok.Setter;
import model.def.Loan;

import java.math.BigDecimal;

@Getter
@Setter
public class LoanImpl
implements Loan {

    private Boolean isAuthorized;
    private BigDecimal loanAmount;
    private BigDecimal loanInterest;
    private Integer monthsForPayback;
}
