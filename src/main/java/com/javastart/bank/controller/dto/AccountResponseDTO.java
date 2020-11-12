package com.javastart.bank.controller.dto;

import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Bill;

public class AccountResponseDTO {

    private Long accountId;
    private String name;
    private Integer age;
    private Bill bill;

    public AccountResponseDTO(Long accountId, String name, Integer age, Bill bill) {
        this.accountId = accountId;
        this.name = name;
        this.age = age;
        this.bill = bill;
    }

    public AccountResponseDTO(Account account) {
        accountId = account.getAccountId();
        name = account.getName();
        age = account.getAge();
        bill = account.getBill();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
