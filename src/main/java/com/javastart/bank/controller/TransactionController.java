package com.javastart.bank.controller;

import com.javastart.bank.controller.dto.TransactionRequestDTO;
import com.javastart.bank.controller.dto.TransactionResponseDTO;
import com.javastart.bank.service.TransactionServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
public class TransactionController {

    private final TransactionServise transactionServise;

    @Autowired
    public TransactionController(TransactionServise transactionServise) {
        this.transactionServise = transactionServise;
    }

    @PostMapping("/transactions")
    public String createTransaction(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO) {
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
