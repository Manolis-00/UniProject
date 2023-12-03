package model.impl;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import model.def.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class PersonImpl
implements Person {

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String idNumber;
    @NonNull
    private String address;
    @NonNull
    private String email;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private LocalDate dateOfBirth;
    private Set<CreditCardImpl> associatedCreditCards;
    private Set<DebitCardImpl> associatedDebitCards;
    private Set<AccountImpl> associatedAccounts;
    private Set<TransactionImpl> associatedTransactions;
    private Set<LoanImpl> associatedLoans;

    @Autowired
    public void Customer(Set<CreditCardImpl> creditCards, Set<DebitCardImpl> debitCards, Set<AccountImpl> accounts,
                        Set<TransactionImpl> transactions, Set<LoanImpl> loans) {
        this.associatedCreditCards.addAll(creditCards);
        this.associatedDebitCards.addAll(debitCards);
        this.associatedAccounts.addAll(accounts);
        this.associatedTransactions.addAll(transactions);
        this.associatedLoans.addAll(loans);
    }
}
