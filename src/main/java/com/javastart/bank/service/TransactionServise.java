package com.javastart.bank.service;

import com.javastart.bank.businessLogic.Adjustment;
import com.javastart.bank.businessLogic.Payment;
import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Transaction;
import com.javastart.bank.exception.TransactionNotFoundException;
import com.javastart.bank.repository.AccountRepository;
import com.javastart.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServise {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    private final AdjustmentAndPaymantService adjustmentAndPaymantService;

    @Autowired
    public TransactionServise(TransactionRepository transactionRepository, AccountRepository accountRepository, AccountService accountService, AdjustmentAndPaymantService adjustmentAndPaymantService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.adjustmentAndPaymantService = adjustmentAndPaymantService;
    }

    public String createTransaction(Long senderId, Long recipientId, Double transactionAmount) {
        Transaction transaction = new Transaction(senderId, recipientId, transactionAmount);
        transactionRepository.save(transaction);
        return doTransaction(transaction);
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() ->
                new TransactionNotFoundException("Can't find transaction with id: " + id));
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }


    private String doTransaction(Transaction transaction) {
        Account senderAccount = accountService.getAccountById(transaction.getSenderId());
        Account recipientAccount = accountService.getAccountById(transaction.getRecipientId());
        String message;
        message = adjustmentAndPaymantService.payBill(senderAccount.getAccountId(), new Payment(transaction.getTransferAmount()));
        if (message.startsWith(senderAccount.getName() + " pay")) {
            message = message + "\n" + adjustmentAndPaymantService.adjustAmount(recipientAccount.getAccountId(), new Adjustment(transaction.getTransferAmount()));
        }
        return message;
    }



}
