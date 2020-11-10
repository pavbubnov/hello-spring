package com.javastart.bank.businessLogic;

import com.javastart.bank.entity.Account;
import org.springframework.data.repository.query.Param;

import java.awt.event.MouseWheelEvent;

public class PaymantService {

    public String getPaymant (Account account, Paymant paymant) {
        if (account.getBill().getAmount() - paymant.getPaymantAmount() >= 0 ) {
            account.getBill().setAmount(account.getBill().getAmount() - paymant.getPaymantAmount());
            return Message.paymantSuccessMessage(account, paymant);
        } else return Message.paymantErrorMessage(account, paymant);
    }
}
