package com.Finance_Pay.repository.accounts;

import com.Finance_Pay.model.accounts.SavingAccount;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, Integer> {

    List<SavingAccount> findByLegalPerson(LegalPerson legalPerson);

    List<SavingAccount> findByFisicalPerson(FisicalPerson fisicalPerson);

}
