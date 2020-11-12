package com.javastart.bank.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionRequestDTO {

    @JsonProperty("SenderId")
    private Long senderId;
    @JsonProperty("RecipientId")
    private Long recipientId;
    @JsonProperty("TransferAmount")
    private Double transferAmount;

    public TransactionRequestDTO(Long transactionId, Long senderId, Long recipientId, Double transferAmount) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.transferAmount = transferAmount;
    }

    public TransactionRequestDTO() {
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
