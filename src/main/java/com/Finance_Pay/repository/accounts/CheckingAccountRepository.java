package com.Finance_Pay.repository.accounts;

import com.Finance_Pay.model.accounts.CheckingAccount;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Integer> {

    CheckingAccount findByAccountNumber(String accountNumber);

    List<CheckingAccount> findByLegalPerson(LegalPerson legalPerson);

    List<CheckingAccount> findByFisicalPerson(FisicalPerson fisicalPerson);

}
