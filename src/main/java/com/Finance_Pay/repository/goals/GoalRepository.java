package com.Finance_Pay.repository.goals;

import com.Finance_Pay.enums.Type;
import com.Finance_Pay.model.expenses.Expense;
import com.Finance_Pay.model.goals.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<GoalRepository, Integer> {

    List<Goal> findByName(String name);

    List<Goal> findByDayOfPurchase(Date dayOfPurchase);

    Expense findByType(Type type);

}
