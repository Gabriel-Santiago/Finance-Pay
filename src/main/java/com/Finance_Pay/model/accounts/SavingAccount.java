package com.Finance_Pay.model.accounts;

import com.Finance_Pay.dto.AccountDTO;
import com.Finance_Pay.model.persons.FisicalPerson;
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
@Table(name = "savingAccount")
public class SavingAccount extends  Account{

    @OneToOne(mappedBy = "OwnerFisicalPersonSavingAccount")
    private FisicalPerson fisicalPerson;

    public SavingAccount (AccountDTO accountDTO){
        this.id = accountDTO.id();
        this.accountNumber = accountDTO.accountNumber();
        this.balance = accountDTO.balance();
        this.fisicalPerson = getFisicalPerson();
        this.transaction = getTransaction();
    }
}
