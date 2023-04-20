package org.example.accounts.audit;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@RevisionEntity(AuditLogListener.class)
public class AuditLogEntity extends AuditorEntity {
    private String username;



}
