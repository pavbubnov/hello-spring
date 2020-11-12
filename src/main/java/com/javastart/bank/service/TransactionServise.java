package com.javastart.bank.service;

import com.javastart.bank.businessLogic.Adjustment;
import com.javastart.bank.businessLogic.Message;
import com.javastart.bank.businessLogic.Payment;
import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Transaction;
import com.javastart.bank.exception.NotEnoughMoneyException;
import com.javastart.bank.exception.TransactionNotFoundException;
import com.javastart.bank.repository.AccountRepository;
import com.javastart.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServise {

    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;

    private final AccountService accountService;

    @Autowired
    public TransactionServise(TransactionRepository transactionRepository, AccountRepository accountRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.accountService = accountService;
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

    public String adjustAmount(Long id, Adjustment adjustment) {
        Account account = accountService.getAccountById(id);
        String message = doAdjustment(account, adjustment);
        accountRepository.save(account);
        return message;
    }

    public String payBill(Long id, Payment payment) {
        Account account = accountService.getAccountById(id);
        String message = doPayment(account, payment);
        accountRepository.save(account);
        return message;
    }

    private String doTransaction(Transaction transaction) {
        Account senderAccount = accountService.getAccountById(transaction.getSenderId());
        Account recipientAccount = accountService.getAccountById(transaction.getRecipientId());
        String message;
        message = payBill(senderAccount.getAccountId(), new Payment(transaction.getTransferAmount()));
        if (message.startsWith(senderAccount.getName() + " pay")) {
            message = message + "\n" + adjustAmount(recipientAccount.getAccountId(), new Adjustment(transaction.getTransferAmount()));
        }
        return message;
    }

    private static String doAdjustment(Account account, Adjustment adjustment) {
        account.getBill().setAmount(adjustment.getAdjustmentAmount() + account.getBill().getAmount());
        return Message.adjustmentMessage(account, adjustment);
    }

    private static String doPayment(Account account, Payment payment) {
        if (account.getBill().getAmount() - payment.getPaymentAmount() >= 0) {
            account.getBill().setAmount(account.getBill().getAmount() - payment.getPaymentAmount());
            return Message.paymentSuccessMessage(account, payment);
        } else throw new NotEnoughMoneyException(account, payment);
    }

}
