package com.Finance_Pay.repository.persons;

import com.Finance_Pay.model.expenses.Expense;
import com.Finance_Pay.model.goals.Goal;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Sme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmeRepository extends JpaRepository<Sme, Integer> {

    Sme findByCrn(long crn);

    Sme findByName(String name);

    Sme findByEmail(String email);

    Sme findByPhone(String phone);

    List<FisicalPerson> findByGoal(Goal goal);

    List<FisicalPerson> findByExpense(Expense expense);

}
