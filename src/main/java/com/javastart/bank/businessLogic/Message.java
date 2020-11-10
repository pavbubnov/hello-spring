package com.javastart.bank.businessLogic;

import com.javastart.bank.entity.Account;

public class Message {

    public static String adjustmentMessage(Account account, Adjustment adjustment) {
        return account.getName() + "'s bill has bees replenished for " + adjustment.getAdjustmentAmount() + ", " +
                "new amount is " + account.getBill().getAmount();
    }

    public static String paymantErrorMessage(Account account, Paymant paymant) {
        return account.getName() + " have not enough money for paymant: " + paymant.getPaymantAmount() + ", account " +
                "amount is " + account.getBill().getAmount();
    }

    public static String paymantSuccessMessage(Account account, Paymant paymant) {
        return account.getName() + " pay " + paymant.getPaymantAmount() + ", new amount is " + account.getBill().getAmount();
    }
}
