package com.Finance_Pay.repository.financialManagements;

import com.Finance_Pay.enums.TypeOfCosts;
import com.Finance_Pay.model.financialManagements.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    List<Expense> findByDate(Date date);

    List<Expense> findByName(String name);

    List<Expense> findByType(TypeOfCosts typeOfCosts);

}
