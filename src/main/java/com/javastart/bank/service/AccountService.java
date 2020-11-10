package com.javastart.bank.service;

import com.javastart.bank.businessLogic.AdjustmentService;
import com.javastart.bank.businessLogic.Paymant;
import com.javastart.bank.businessLogic.PaymantService;
import com.javastart.bank.entity.Account;
import com.javastart.bank.businessLogic.Adjustment;
import com.javastart.bank.entity.Bill;
import com.javastart.bank.exception.AccountNotFoundException;
import com.javastart.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long createAccount(String name, Integer age, Bill bill) {
        Account account = new Account(name, age, bill);
        return accountRepository.save(account).getAccountId();
    }

    public Account getAccountById (Long id) {
        return accountRepository.findById(id).orElseThrow(() ->
                new AccountNotFoundException("Can't find account with id: " + id));
    }

    public String adjustAmount (Long id, Adjustment adjustment) {
        Account account = getAccountById(id);
        AdjustmentService adjustmentService = new AdjustmentService();
        String message = adjustmentService.getAdjustment(account, adjustment);
        accountRepository.save(account);
        return message;
    }

    public String payBill (Long id, Paymant paymant) {
        Account account = getAccountById(id);
        PaymantService paymantService = new PaymantService();
        String message = paymantService.getPaymant(account, paymant);
        accountRepository.save(account);
        return message;
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account deleteById(Long id) {
        Account account = getAccountById(id);
        accountRepository.deleteById(id);
        return account;
    }

    public String deleteAll() {
        accountRepository.deleteAll();
        return "All accounts delete";
    }

    public String patchById(Long id, Bill bill) {
        Account account = getAccountById(id);
        account.setBill(bill);
        accountRepository.save(account);
        return "bill update";
    }
}
