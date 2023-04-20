package org.example.accounts.service;

import org.example.accounts.dto.AccountCreateRequest;
import org.example.accounts.dto.AccountCreateResponse;
import org.example.accounts.dto.History;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    AccountCreateResponse createAccount(AccountCreateRequest accountCreateRequest);
    List<History> getAllHistory(UUID id);
}
