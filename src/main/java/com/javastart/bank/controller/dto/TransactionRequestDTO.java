package com.javastart.bank.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TransactionRequestDTO {

    @JsonProperty("sender_id")
    @NotNull(message = "Please, enter senderId")
    private Long senderId;

    @JsonProperty("recipient_id")
    @NotNull(message = "Please, enter recipientId")
    private Long recipientId;

    @JsonProperty("transfer_amount")
    @NotNull(message = "Please, enter amount")
    @Min(value = 0, message = "Please, enter correct value")
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
