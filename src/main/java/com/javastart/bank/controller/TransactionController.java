package com.javastart.bank.controller;

import com.javastart.bank.businessLogic.Adjustment;
import com.javastart.bank.businessLogic.Payment;
import com.javastart.bank.controller.dto.TransactionRequestDTO;
import com.javastart.bank.controller.dto.TransactionResponseDTO;
import com.javastart.bank.service.TransactionServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransactionController {

    private final TransactionServise transactionServise;

    @Autowired
    public TransactionController(TransactionServise transactionServise) {
        this.transactionServise = transactionServise;
    }

    @PatchMapping("/accounts/adjustment/{id}")
    public String getAdjustment(@PathVariable Long id, @RequestBody Adjustment adjustment) {
        return transactionServise.adjustAmount(id, adjustment);
    }

    @PatchMapping("/accounts/payment/{id}")
    public String getPayment(@PathVariable Long id, @RequestBody Payment payment) {
        return transactionServise.payBill(id, payment);
    }

    @PostMapping("/transactions")
    public String createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        return transactionServise.createTransaction(transactionRequestDTO.getSenderId(),
                transactionRequestDTO.getRecipientId(), transactionRequestDTO.getTransferAmount());
    }

    @GetMapping("/transactions/{id}")
    public TransactionResponseDTO getTransactionById(@PathVariable Long id) {
        return new TransactionResponseDTO(transactionServise.getTransactionById(id));
    }

    @GetMapping("/transactions")
    public List<TransactionResponseDTO> getAllTransactions() {
        return transactionServise.getTransactions().stream()
                .map(TransactionResponseDTO::new)
                .collect(Collectors.toList());
    }
}
