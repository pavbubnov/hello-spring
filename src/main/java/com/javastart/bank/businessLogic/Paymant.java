package com.javastart.bank.businessLogic;

public class Paymant {

    private Double paymantAmount;

    public Paymant(Double paymantAmount) {
        this.paymantAmount = paymantAmount;
    }

    public Paymant() {
    }

    public Double getPaymantAmount() {
        return paymantAmount;
    }

    public void setPaymantAmount(Double paymantAmount) {
        this.paymantAmount = paymantAmount;
    }

    @Override
    public String toString() {
        return "Paymant{" +
                "paymantAmount=" + paymantAmount +
                '}';
    }
}
