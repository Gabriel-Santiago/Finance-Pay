package com.Finance_Pay.service.persons;

import com.Finance_Pay.apiConsume.ViaCep;
import com.Finance_Pay.model.persons.FinancialConsultant;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Mei;
import com.Finance_Pay.repository.persons.FinancialConsultantRepository;
import com.Finance_Pay.security.Authorization;
import com.Finance_Pay.validations.EmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinancialConsultantService {

    private final FinancialConsultantRepository financialConsultantRepository;
    private final EmailValidation emailValidation;
    private final Authorization authorization;
    private final ViaCep viaCep;

    @Autowired
    public FinancialConsultantService(FinancialConsultantRepository financialConsultantRepository,
                                      EmailValidation emailValidation,
                                      Authorization authorization, ViaCep viaCep) {
        this.financialConsultantRepository = financialConsultantRepository;
        this.emailValidation = emailValidation;
        this.authorization = authorization;
        this.viaCep = viaCep;
    }

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
            throw new IllegalArgumentException("ID must be greater than zero");
        }

        return financialConsultantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Financial Consultant not found with id " + id));
    }

    public List<FinancialConsultant> findAll(){
        return financialConsultantRepository.findAll();
    }

    public List<FisicalPerson> findByFisicalPerson(FinancialConsultant financialConsultant){
        List<FisicalPerson> fisicalPersonList = financialConsultantRepository.findByFisicalPerson(financialConsultant);
        return fisicalPersonList != null ? fisicalPersonList : new ArrayList<>();
    }

    public List<Mei> findByMei(FinancialConsultant financialConsultant){
        List<Mei> meiList = financialConsultantRepository.findByMei(financialConsultant);
        return meiList != null ? meiList : new ArrayList<>();
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

    public void delete(int id){
        if(!financialConsultantRepository.existsById(id)){
            throw new RuntimeException("Financial Consultant not found with id " + id);
        }

        FinancialConsultant financialConsultant = find(id);
        financialConsultantRepository.delete(financialConsultant);
    }

}
