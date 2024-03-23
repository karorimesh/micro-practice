package org.example.accounts.service;

import org.example.accounts.dto.AccountCreateRequest;
import org.example.accounts.dto.AccountCreateResponse;
import org.example.accounts.dto.History;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface AccountService {

    AccountCreateResponse createAccount(AccountCreateRequest accountCreateRequest);
    String updateAccount(Map<String, Object> accountUpdateRequest);
    List<History> getAllHistory(UUID id);
}
