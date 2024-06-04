package com.Finance_Pay.repository.persons;

import com.Finance_Pay.model.financialManagements.Earning;
import com.Finance_Pay.model.financialManagements.Expense;
import com.Finance_Pay.model.financialManagements.Goal;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Mei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FisicalPersonRepository extends JpaRepository<FisicalPerson, Integer> {

    FisicalPerson findByCpf(String cpf);

    FisicalPerson findByName(String name);

    FisicalPerson findByEmail(String email);

    FisicalPerson findByPhone(String phone);

    List<FisicalPerson> findByAge(int age);

    List<Goal> findByGoal(FisicalPerson fisicalPerson);

    List<Expense> findByExpense(FisicalPerson fisicalPerson);

    List<Earning> findByEarning(FisicalPerson fisicalPerson);

}
