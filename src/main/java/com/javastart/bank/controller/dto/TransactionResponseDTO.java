package com.javastart.bank.controller.dto;

import com.javastart.bank.entity.Transaction;

public class TransactionResponseDTO {

    private Long transactionId;
    private Long senderId;
    private Long recipientId;
    private Double transferAmount;

    public TransactionResponseDTO(Long transactionId, Long senderId, Long recipientId, Double transferAmount) {
        this.transactionId = transactionId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.transferAmount = transferAmount;
    }

    public TransactionResponseDTO(Transaction transaction) {
        this.transactionId = transaction.getTransactionId();
        this.senderId = transaction.getSenderId();
        this.recipientId = transaction.getRecipientId();
        this.transferAmount = transaction.getTransferAmount();
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
}
