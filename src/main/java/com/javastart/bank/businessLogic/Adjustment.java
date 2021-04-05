package com.javastart.bank.businessLogic;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Adjustment {

    @NotNull(message = "Please, enter how much cash you want to add")
    @JsonProperty("amount")
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
