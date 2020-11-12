package com.javastart.bank.businessLogic;

import com.javastart.bank.entity.Account;

public class Message {

    public static String adjustmentMessage(Account account, Adjustment adjustment) {
        return account.getName() + "'s bill has bees replenished for " + adjustment.getAdjustmentAmount() + ", " +
                "new amount is " + account.getBill().getAmount();
    }

    public static String paymentErrorMessage(Account account, Payment payment) {
        return account.getName() + " have not enough money for payment: " + payment.getPaymentAmount() + ", account " +
                "amount is " + account.getBill().getAmount();
    }

    public static String paymentSuccessMessage(Account account, Payment payment) {
        return account.getName() + " pay " + payment.getPaymentAmount() + ", new amount is " + account.getBill().getAmount();
    }
}
