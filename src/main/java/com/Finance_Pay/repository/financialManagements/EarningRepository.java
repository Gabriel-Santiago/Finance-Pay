package com.Finance_Pay.repository.financialManagements;

import com.Finance_Pay.enums.TypeOfIncomes;
import com.Finance_Pay.model.financialManagements.Earning;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EarningRepository extends JpaRepository<Earning, Integer> {

    List<Earning> findByName(String name);

    List<Earning> findByType(TypeOfIncomes typeOfIncomes);

}
