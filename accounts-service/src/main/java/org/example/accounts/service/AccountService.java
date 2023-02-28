package org.example.accounts.service;

import org.example.accounts.dto.AccountCreateRequest;
import org.example.accounts.dto.AccountCreateResponse;

public interface AccountService {

    AccountCreateResponse createAccount(AccountCreateRequest accountCreateRequest);
}
