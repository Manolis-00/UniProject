package com.project.service.bank;

import com.project.model.user.UserAccountStatus;
import org.springframework.stereotype.Service;

@Service
public class BankAccountStatusService {

    public void updateBankAccountStatus(UserAccountStatus userAccountStatus) {
        switch (userAccountStatus) {
            case ACTIVE -> activateAccount();
            case BLOCKED -> blockAccount();
            case OPEN -> openAccount();
            case SUSPENDED -> suspendAccount();
        }
    }

    public void openAccount() {

    }

    public void activateAccount() {

    }

    public void suspendAccount() {

    }

    public void blockAccount() {
        //TODO - Remove the account from the table, and from the associated tables.
    }
}
