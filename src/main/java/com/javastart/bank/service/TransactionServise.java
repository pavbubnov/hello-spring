package com.javastart.bank.service;

import com.javastart.bank.businessLogic.Adjustment;
import com.javastart.bank.businessLogic.AdjustmentService;
import com.javastart.bank.businessLogic.Paymant;
import com.javastart.bank.businessLogic.PaymantService;
import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Transaction;
import com.javastart.bank.exception.TransactionNotFoundException;
import com.javastart.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServise {

    private final TransactionRepository transactionRepository;

    private final AccountService accountService;

    @Autowired
    public TransactionServise(TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    public String createTransaction(Long senderId, Long recipientId, Double transactionAmount) {
        Transaction transaction = new Transaction(senderId, recipientId, transactionAmount);
        transactionRepository.save(transaction);
        return doTransaction(transaction);
    }

    private String doTransaction(Transaction transaction) {
        Account senderAccount = accountService.getAccountById(transaction.getSenderId());
        Account recipientAccount = accountService.getAccountById(transaction.getRecipientId());
        String message;
        message = accountService.payBill(senderAccount.getAccountId(), new Paymant(transaction.getTransferAmount()));
        if (message.startsWith(senderAccount.getName() + " pay")){
            message = message + "\n" + accountService.adjustAmount(recipientAccount.getAccountId(), new Adjustment(transaction.getTransferAmount()));
        }
        return message;
    }

    public Transaction getTransactionById (Long id) {
        return transactionRepository.findById(id).orElseThrow(() ->
                new TransactionNotFoundException("Can't find transaction with id: " + id));
    }

    public List<Transaction> getTransactions () {
        return transactionRepository.findAll();
    }
}
