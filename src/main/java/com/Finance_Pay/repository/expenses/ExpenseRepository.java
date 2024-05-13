package com.Finance_Pay.repository.expenses;

import com.Finance_Pay.enums.Type;
import com.Finance_Pay.model.expenses.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    List<Expense> findByDate(Date date);

    List<Expense> findByName(String name);

    Expense findByType(Type type);

}
