package org.example.accounts.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.example.accounts.dto.AccountCreateRequest;
import org.example.accounts.dto.AccountCreateResponse;
import org.example.accounts.dto.History;
import org.example.accounts.entities.Account;
import org.example.accounts.service.AccountService;
import org.json.JSONObject;
import org.springframework.data.history.Revision;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @PatchMapping
    public ResponseEntity<String> updateAccount(@RequestBody Map<String, Object> updateRequest) {
        String response = accountService.updateAccount(updateRequest);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(HttpStatus.SC_CREATED));
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<List<History>> getAccountHistory (@PathVariable String id) {
        return new ResponseEntity<>(
                accountService.getAllHistory(UUID.fromString(id)),
                HttpStatusCode.valueOf(HttpStatus.SC_OK));
    }
}
