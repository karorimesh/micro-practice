package org.example.accounts.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.accounts.audit.AuditLogEntity;
import org.example.accounts.audit.AuditorEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
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

    @ToString.Exclude
    @JoinColumn(name = "account_owner")
    @JdbcTypeCode(SqlTypes.UUID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
//    @JsonBackReference
    private Customer accountOwner;

}