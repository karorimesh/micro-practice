package org.example.accounts.service;

import org.example.accounts.dto.AccountCreateRequest;
import org.example.accounts.dto.AccountCreateResponse;
import org.example.accounts.entities.Account;
import org.example.accounts.enums.AppConstants;
import org.example.accounts.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountCreateResponse createAccount(AccountCreateRequest accountCreateRequest) {
        int accountNumber = new Random().nextInt(10000000);
        Account account = Account.builder()
                .accountBalance(accountCreateRequest.balance())
                .accountNumber(Integer.toString(accountNumber))
                .accountOwner(accountCreateRequest.accountOwner())
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
}
