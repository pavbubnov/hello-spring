package com.javastart.bank.controller;

import com.javastart.bank.controller.dto.AccountRequestDTO;
import com.javastart.bank.controller.dto.AccountResponseDTO;
import com.javastart.bank.entity.Bill;
import com.javastart.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public Long createAccount(@Valid @RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO.getName(),
                accountRequestDTO.getAge(), accountRequestDTO.getBill());
    }

    @GetMapping("/accounts/{id}")
    @Transactional
    public AccountResponseDTO getAccount(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.getAccountById(id));
    }

    @GetMapping("/accounts")
    public List<AccountResponseDTO> getAll() {
        return accountService.getAll().stream()
                .map(AccountResponseDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/accounts/{id}")
    public AccountResponseDTO delete(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.deleteById(id));
    }

    @DeleteMapping("/accounts")
    public String deleteAll() {
        return accountService.deleteAll();
    }

    @PatchMapping("/accounts/{id}")
    public String updateAccount(@PathVariable Long id, @Valid @RequestBody Bill bill) {
        return accountService.patchById(id, bill);
    }

}
