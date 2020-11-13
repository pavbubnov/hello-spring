package com.javastart.bank.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javastart.bank.entity.Bill;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AccountRequestDTO {

    @JsonProperty("Name")
    @NotNull(message = "Please, enter your name")
    private String name;

    @JsonProperty("Age")
    @NotNull(message = "Please, enter your age")
    @Min(value = 18, message = "You should be 18 y.o.")
    @Max(value = 150, message = "Please, call to Guinness")
    private Integer age;

    @JsonProperty("Bill")
    @NotNull(message = "Please, enter your Bill")
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
