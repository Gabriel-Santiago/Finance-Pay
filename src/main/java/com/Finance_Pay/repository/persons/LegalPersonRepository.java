package com.Finance_Pay.repository.persons;

import com.Finance_Pay.model.persons.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalPersonRepository extends JpaRepository<LegalPerson, Integer> {

    LegalPerson findByCrn(long crn);

    List<LegalPerson> findByName(String name);

    LegalPerson findByEmail(String email);

    LegalPerson findByPhone(String phone);

}
