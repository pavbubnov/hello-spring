package com.javastart.bank.service;

import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Bill;
import com.javastart.bank.exception.AccountNotFoundException;
import com.javastart.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() ->
                new AccountNotFoundException("Can't find account with id: " + id));
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

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }


}
