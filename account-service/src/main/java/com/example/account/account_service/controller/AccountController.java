package com.example.account.account_service.controller;

import com.example.account.account_service.model.Account;
import com.example.account.account_service.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Account> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return repository.save(account);
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> getByCustomer(@PathVariable Long customerId) {
        return repository.findByCustomerId(customerId);
    }
}
