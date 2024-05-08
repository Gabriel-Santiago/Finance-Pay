package com.Finance_Pay.model.persons;


import com.Finance_Pay.dto.PersonDTO;
import com.Finance_Pay.model.accounts.CheckingAccount;
import com.Finance_Pay.model.accounts.SavingAccount;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "legalPerson", uniqueConstraints = {@UniqueConstraint(columnNames = {"crn"})})
public class LegalPerson extends Person {

    private long crn; // Company Registration Number

    @OneToOne(mappedBy = "legalPersonCheckingAccount")
    private CheckingAccount checkingAccount;

    public LegalPerson(PersonDTO personDTO){
        this.id = personDTO.id();
        this.name = personDTO.name();
        this.city = personDTO.city();
        this.state = personDTO.state();
        this.email = personDTO.email();
        this.password = personDTO.password();
        this.phone = personDTO.phone();
        this.crn = getCrn();
        this.checkingAccount = getCheckingAccount();
    }
}
