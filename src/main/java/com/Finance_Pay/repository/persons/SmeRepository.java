package com.Finance_Pay.repository.persons;

import com.Finance_Pay.model.financialManagements.earnings.Earning;
import com.Finance_Pay.model.financialManagements.expenses.Expense;
import com.Finance_Pay.model.financialManagements.goals.Goal;
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

    List<Sme> findByGoal(Goal goal);

    List<Sme> findByExpense(Expense expense);

    List<Sme> findByEarning(Earning earning);

}
