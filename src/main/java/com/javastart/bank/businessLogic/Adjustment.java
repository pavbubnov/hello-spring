package com.javastart.bank.businessLogic;


public class Adjustment {

    private Double adjustmentAmount;

    public Adjustment(Double adjustmentAmount) {
        this.adjustmentAmount = adjustmentAmount;
    }

    public Adjustment() {
    }

    public Double getAdjustmentAmount() {
        return adjustmentAmount;
    }

    public void setAdjustmentAmount(Double adjustment) {
        this.adjustmentAmount = adjustment;
    }

    @Override
    public String toString() {
        return "Adjustment{" +
                ", adjustmentAmount=" + adjustmentAmount +
                '}';
    }
}
