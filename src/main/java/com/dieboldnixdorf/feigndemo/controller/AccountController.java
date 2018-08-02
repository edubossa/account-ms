package com.dieboldnixdorf.feigndemo.controller;

import com.dieboldnixdorf.feigndemo.model.Account;
import com.dieboldnixdorf.feigndemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountRepository repository;

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> customers = repository.getAccounts();
        log.info("accounts --> " + customers.toString());
        return ResponseEntity.ok(repository.getAccounts());
    }

    @GetMapping("/{token}")
    public ResponseEntity<Account> getCustomer(@PathVariable("token") String token) {
        log.info("/accounts/" + token);
        return ResponseEntity.ok(repository.findByToken(token));
    }

    @PostMapping
    public ResponseEntity<Account> postCustomers(@RequestBody Account account) {
        account.setToken(UUID.randomUUID().toString());
        log.info("accounts --> " + account.toString());
        repository.save(account);
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public String test() {
        return "OK!";
    }

}
