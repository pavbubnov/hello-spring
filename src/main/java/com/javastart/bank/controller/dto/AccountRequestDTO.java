package com.javastart.bank.controller.dto;

import com.javastart.bank.entity.Bill;

public class AccountRequestDTO {

    private String name;
    private Integer age;
    private Bill bill;

    public AccountRequestDTO(String name, Integer age, Bill bill) {
        this.name = name;
        this.age = age;
        this.bill = bill;
    }

    public AccountRequestDTO() {
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
