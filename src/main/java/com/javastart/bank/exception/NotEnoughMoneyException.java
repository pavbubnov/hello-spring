package com.javastart.bank.exception;

import com.javastart.bank.businessLogic.Message;
import com.javastart.bank.businessLogic.Payment;
import com.javastart.bank.entity.Account;

public class NotEnoughMoneyException extends RuntimeException {

    public NotEnoughMoneyException(Account account, Payment payment) {
        super(Message.paymentErrorMessage(account, payment));
    }
}
