package org.example.accounts.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "port_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "account_number", unique = true, length = 50)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String accountNumber;

    @Column(name = "active")
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private Boolean active;

    @Column(name = "account_balance")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double accountBalance;

    @Column(name = "account_owner")
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID accountOwner;

}