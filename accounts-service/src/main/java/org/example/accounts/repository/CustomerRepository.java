package org.example.accounts.repository;

import org.example.accounts.entities.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    @EntityGraph(value = "Customer.accounts")
    List<Customer> findAll();
}
