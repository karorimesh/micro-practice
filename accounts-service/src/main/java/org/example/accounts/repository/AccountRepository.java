package org.example.accounts.repository;

import org.example.accounts.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID>, RevisionRepository<Account,UUID,Integer> {
}
