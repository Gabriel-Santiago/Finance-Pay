package com.Finance_Pay.repository.persons;

import com.Finance_Pay.model.financialManagements.Earning;
import com.Finance_Pay.model.financialManagements.Expense;
import com.Finance_Pay.model.financialManagements.Goal;
import com.Finance_Pay.model.persons.Mei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeiRepository extends JpaRepository<Mei, Integer> {

    Mei findByCnpj(String cnpj);

    Mei findByName(String name);

    Mei findByEmail(String email);

    Mei findByPhone(String phone);

    List<Goal> findByGoal(Mei mei);

    List<Expense> findByExpense(Mei mei);

    List<Earning> findByEarning(Mei mei);

}
