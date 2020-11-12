package com.javastart.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @NotNull(message = "Please, enter senderId")
    private Long senderId;

    @NotNull(message = "Please, enter recipientId")
    private Long recipientId;

    @NotNull(message = "Please, enter amount")
    @Min(value = 0, message = "Please, enter correct value")
    private Double transferAmount;

    public Transaction(Long senderId, Long recipientId, Double transferAmount) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.transferAmount = transferAmount;
    }

    public Transaction() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public Double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Double transferAmount) {
        this.transferAmount = transferAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", senderId=" + senderId +
                ", recipientId=" + recipientId +
                ", transferAmount=" + transferAmount +
                '}';
    }
}
