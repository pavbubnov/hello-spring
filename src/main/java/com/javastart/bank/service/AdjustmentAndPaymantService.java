package com.javastart.bank.service;

import com.javastart.bank.businessLogic.Adjustment;
import com.javastart.bank.businessLogic.Message;
import com.javastart.bank.businessLogic.Payment;
import com.javastart.bank.entity.Account;
import com.javastart.bank.exception.NotEnoughMoneyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdjustmentAndPaymantService {

    private final AccountService accountService;

    @Autowired
    public AdjustmentAndPaymantService(AccountService accountService) {
        this.accountService = accountService;
    }

    public String adjustAmount(Long id, Adjustment adjustment) {
        Account account = accountService.getAccountById(id);
        String message = doAdjustment(account, adjustment);
        accountService.saveAccount(account);
        return message;
    }

    public String payBill(Long id, Payment payment) {
        Account account = accountService.getAccountById(id);
        String message = doPayment(account, payment);
        accountService.saveAccount(account);
        return message;
    }

    private static String doAdjustment(Account account, Adjustment adjustment) {
        account.getBill().setAmount(adjustment.getAdjustmentAmount() + account.getBill().getAmount());
        return Message.adjustmentMessage(account, adjustment);
    }

    private static String doPayment(Account account, Payment payment) {
        if (account.getBill().getAmount() - payment.getPaymentAmount() >= 0) {
            account.getBill().setAmount(account.getBill().getAmount() - payment.getPaymentAmount());
            return Message.paymentSuccessMessage(account, payment);
        } else throw new NotEnoughMoneyException(account, payment);
    }
}
