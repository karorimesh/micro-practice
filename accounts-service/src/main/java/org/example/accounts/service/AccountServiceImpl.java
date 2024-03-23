package org.example.accounts.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
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
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager entityManager;

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
    @Transactional
    public String updateAccount(Map<String, Object> accountUpdateRequest) {
        try {
            CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
            CriteriaUpdate<Account> update = criteriaBuilder.createCriteriaUpdate(Account.class);
            Root<Account> root = update.from(Account.class);
            Stream<String> accountFields = Arrays
                    .stream(Account.class.getFields())
                    .filter(f -> entityManager
                            .getMetamodel()
                            .getEntities()
                            .contains(f.getType()))
                    .map(Field::getName);
            update.where(criteriaBuilder.equal(root.get("id"), UUID.fromString((String) accountUpdateRequest.get("id"))));
            accountUpdateRequest.remove("id");
            accountUpdateRequest.forEach((k,v) -> {
                if (accountFields.anyMatch(m -> Objects.equals(m, k))) {
                    update.set(k, UUID.fromString((String) v));
                } else {
                    update.set(k, v);
                }
            });
            this.entityManager.createQuery(update).executeUpdate();
            return "Update Successful";
        } catch (Exception e) {
            return e.getMessage();
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
