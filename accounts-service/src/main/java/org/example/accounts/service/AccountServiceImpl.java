package org.example.accounts.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.accounts.dto.AccountCreateRequest;
import org.example.accounts.dto.AccountCreateResponse;
import org.example.accounts.dto.History;
import org.example.accounts.entities.Account;
import org.example.accounts.enums.AppConstants;
import org.example.accounts.repository.AccountRepository;
import org.example.accounts.repository.CustomerRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountCreateResponse createAccount(AccountCreateRequest accountCreateRequest) {
        int accountNumber = new Random().nextInt(10000000);
        Account account = Account.builder()
                .accountBalance(accountCreateRequest.balance())
                .accountNumber(Integer.toString(accountNumber))
                .accountOwner(customerRepository
                        .findById(accountCreateRequest.accountOwner())
                        .orElse(null))
                .active(accountCreateRequest.active())
                .build();
        try {
            accountRepository.save(account);
            return new AccountCreateResponse(AppConstants.SUCCESS.getValue(),
                    AppConstants.SUCCESS_ACCOUNT_CREATE.getValue(),
                    account.getId(),
                    account.getAccountNumber(),
                    new Date());
        } catch (Exception e) {
            return new AccountCreateResponse(AppConstants.FAILED.getValue(),
                    AppConstants.FAIL_ACCOUNT_CREATE.getValue(),
                    null,
                    null,
                    new Date());
        }
    }

    @Override
    public List<History> getAllHistory(UUID id) {
        return accountRepository.findRevisions(id)
                .stream()
                .map(h -> new History(
                        h.getRevisionNumber().orElse(0),
                        h.getEntity().toString()))
                .collect(Collectors.toList());
    }
}
