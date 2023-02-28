package org.example.accounts.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.example.accounts.dto.AccountCreateRequest;
import org.example.accounts.dto.AccountCreateResponse;
import org.example.accounts.service.AccountService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountResource {

    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountCreateResponse> createAccount (@RequestBody AccountCreateRequest createRequest){
        AccountCreateResponse response = accountService.createAccount(createRequest);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(HttpStatus.SC_CREATED));
    }
}
