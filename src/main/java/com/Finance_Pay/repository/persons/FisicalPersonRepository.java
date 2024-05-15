package com.Finance_Pay.repository.persons;

import com.Finance_Pay.model.financialManagements.earnings.Earning;
import com.Finance_Pay.model.financialManagements.expenses.Expense;
import com.Finance_Pay.model.financialManagements.goals.Goal;
import com.Finance_Pay.model.persons.FisicalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FisicalPersonRepository extends JpaRepository<FisicalPerson, Integer> {

    FisicalPerson findByCpf(long cpf);

    FisicalPerson findByName(String name);

    FisicalPerson findByEmail(String email);

    FisicalPerson findByPhone(String phone);

    List<FisicalPerson> findByAge(int age);

    List<FisicalPerson> findByGoal(Goal goal);

    List<FisicalPerson> findByExpense(Expense expense);

    List<FisicalPerson> findByEarning(Earning earning);

}
