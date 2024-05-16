package com.Finance_Pay.repository.persons;

import com.Finance_Pay.model.persons.FinancialConsultant;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Mei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialConsultantRepository extends JpaRepository<FinancialConsultant, Integer> {

    List<FinancialConsultant> findByFisicalPerson(FisicalPerson fisicalPerson);

    List<FinancialConsultant> findByMei(Mei mei);

    FinancialConsultant findByName(String name);

    List<FinancialConsultant> findByCity(String city);

    List<FinancialConsultant> findByState(String state);

}
