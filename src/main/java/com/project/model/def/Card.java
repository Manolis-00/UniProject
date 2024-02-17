package com.project.model.def;

import com.project.model.enums.Bank;
import com.project.model.enums.PaymentProcessingNetwork;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Card {
    Integer getCardNumber();

    void setCardNumber(Integer cardNumber);

    Integer getSecurityCode();

    void setSecurityCode(Integer securityCode);

    String getOwnerName();

    void setOwnerName(String ownerName);

    LocalDate getValidThruDate();

    void setValidThruDate(LocalDate validThruDate);

    PaymentProcessingNetwork getCardPaymentProcessingNetwork();

    void setCardPaymentProcessingNetwork(PaymentProcessingNetwork paymentProcessingNetwork);

    Bank getCardBank();

    void setCardBank(Bank cardBank);

    Integer getCardDailyWithdrawalsLimit();

    void setCardDailyWithdrawalsLimit(Integer cardDailyWithdrawalsLimit);

    BigDecimal getCardDailyWithdrawalAmountLimit();

    void setCardDailyWithdrawalAmountLimit(BigDecimal cardDailyWithdrawalAmountLimit);

    Integer getCardPINCode();

    void setCardPINCode();
}
