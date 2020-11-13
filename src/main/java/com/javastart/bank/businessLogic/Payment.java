package com.javastart.bank.businessLogic;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Payment {

    @NotNull(message = "Please, enter how much cash you want to pay")
    @JsonProperty("Amount")
    private Double paymentAmount;

    public Payment(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Payment() {
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentAmount=" + paymentAmount +
                '}';
    }
}
