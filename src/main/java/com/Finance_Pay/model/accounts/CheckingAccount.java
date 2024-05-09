package com.Finance_Pay.model.accounts;


import com.Finance_Pay.dto.AccountDTO;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.LegalPerson;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "checkingAccount")
public class CheckingAccount extends Account{

    @OneToOne(mappedBy = "OwnerLegalPersonCheckingAccount")
    private LegalPerson legalPerson;

    @OneToOne(mappedBy = "OwnerFisicalPersonCheckingAccount")
    private FisicalPerson fisicalPerson;

    public CheckingAccount (AccountDTO accountDTO){
        this.id = accountDTO.id();
        this.accountNumber = accountDTO.accountNumber();
        this.balance = accountDTO.balance();
        this.legalPerson = getLegalPerson();
        this.fisicalPerson = getFisicalPerson();
        this.transaction = getTransaction();
    }
}
