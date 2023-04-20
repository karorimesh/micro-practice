package org.example.accounts.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "customer")
@NamedEntityGraph(
        name = "Customer.accounts",
        attributeNodes = {
                @NamedAttributeNode("accounts")
        }
)
public class Customer {
    @Id
    private UUID id;

    @JsonBackReference
//    @JsonManagedReference
    @OneToMany(mappedBy = "accountOwner")
    private List<Account> accounts;

}
