package com.javastart.bank.businessLogic;

public class Payment {

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
