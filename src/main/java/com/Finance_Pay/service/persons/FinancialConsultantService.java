package com.Finance_Pay.service.persons;

import com.Finance_Pay.apiConsume.ViaCep;
import com.Finance_Pay.model.persons.FinancialConsultant;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Mei;
import com.Finance_Pay.repository.persons.FinancialConsultantRepository;
import com.Finance_Pay.security.Authorization;
import com.Finance_Pay.validations.EmailValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialConsultantService {

    FinancialConsultantRepository financialConsultantRepository;

    EmailValidation emailValidation;

    Authorization authorization;

    ViaCep viaCep;

    public void save(int id, FinancialConsultant financialConsultant) throws Exception {
        if(id != 0){
            financialConsultant.setId(id);
        }
        emailValidation.emailValidation(financialConsultant.getEmail());
        financialConsultant.setPassword(authorization.encoder().encode(financialConsultant.getPassword()));
        viaCep.viaCep(financialConsultant.getCep());
        financialConsultantRepository.save(financialConsultant);
    }

    public FinancialConsultant find(int id){
        if(id < 1){
            return null;
        }

        Optional<FinancialConsultant> financialConsultant = financialConsultantRepository.findById(id);

        return financialConsultant.orElse(null);
    }

    public List<FinancialConsultant> findAll(){
        return financialConsultantRepository.findAll();
    }

    public List<FinancialConsultant> findByFisicalPerson(FisicalPerson fisicalPerson){
        return financialConsultantRepository.findByFisicalPerson(fisicalPerson);
    }

    public List<FinancialConsultant> findByMei(Mei mei){
        return financialConsultantRepository.findByMei(mei);
    }

    public List<FinancialConsultant> findByCity(String city){
        return financialConsultantRepository.findByCity(city);
    }

    public List<FinancialConsultant> findByState(String state){
        return financialConsultantRepository.findByState(state);
    }

    public FinancialConsultant findByName(String name){
        return financialConsultantRepository.findByName(name);
    }

    public void update(int id, FinancialConsultant financialConsultant){
        financialConsultant.setId(id);
        financialConsultantRepository.save(financialConsultant);
    }

    public void delete(int id){
        FinancialConsultant financialConsultant = find(id);
        financialConsultantRepository.delete(financialConsultant);
    }

}
