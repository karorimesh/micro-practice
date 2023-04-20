package org.example.accounts.audit;

import org.hibernate.envers.RevisionListener;

public class AuditLogListener implements RevisionListener {

    @Override
    public void newRevision(Object o) {
        ((AuditLogEntity) o).setUsername("mesh");
    }
}
