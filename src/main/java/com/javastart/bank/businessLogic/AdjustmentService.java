package com.javastart.bank.businessLogic;

import com.javastart.bank.entity.Account;

public class AdjustmentService {

    public String getAdjustment (Account account, Adjustment adjustment) {
        account.getBill().setAmount(adjustment.getAdjustmentAmount() + account.getBill().getAmount());
        return Message.adjustmentMessage(account, adjustment);
    }
}
