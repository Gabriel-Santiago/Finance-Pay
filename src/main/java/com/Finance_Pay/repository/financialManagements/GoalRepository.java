package com.Finance_Pay.repository.financialManagements;

import com.Finance_Pay.enums.TypeOfCosts;
import com.Finance_Pay.model.financialManagements.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {

    List<Goal> findByName(String name);

    List<Goal> findByDayOfPurchase(Date dayOfPurchase);

    List<Goal> findByType(TypeOfCosts typeOfCosts);

}
