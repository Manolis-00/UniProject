package model.impl;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import model.def.Transaction;

import java.time.LocalDate;

@Getter
@Setter
@NonNull
public class TransactionImpl
implements Transaction {

    private LocalDate transactionDate;
    private PersonImpl senderOfFunds;
    private PersonImpl receiverOfFunds;
}
