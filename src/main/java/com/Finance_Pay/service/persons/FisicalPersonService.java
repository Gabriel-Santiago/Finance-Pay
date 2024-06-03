package com.Finance_Pay.service.persons;

import com.Finance_Pay.apiConsume.ViaCep;
import com.Finance_Pay.exception.EmailInvalidException;
import com.Finance_Pay.model.financialManagements.Earning;
import com.Finance_Pay.model.financialManagements.Expense;
import com.Finance_Pay.model.financialManagements.Goal;
import com.Finance_Pay.model.persons.FinancialConsultant;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Mei;
import com.Finance_Pay.repository.persons.FinancialConsultantRepository;
import com.Finance_Pay.repository.persons.FisicalPersonRepository;
import com.Finance_Pay.validations.CpfValidation;
import com.Finance_Pay.validations.EmailValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FisicalPersonService {

    FisicalPersonRepository fisicalPersonRepository;

    FinancialConsultantRepository financialConsultantRepository;

    EmailValidation emailValidation;

    CpfValidation cpfValidation;

    ViaCep viaCep;

    public void save(int financialConsultantId, FisicalPerson fisicalPerson) throws Exception{
        FinancialConsultant financialConsultant= financialConsultantRepository.findById(financialConsultantId)
                .orElseThrow(() ->
                        new RuntimeException("Financial Consultant not found with id " + financialConsultantId));

        fisicalPerson.setFinancialConsultant(financialConsultant);
        emailValidation.emailValidation(fisicalPerson.getEmail());
        cpfValidation.cpfValidation(fisicalPerson.getCpf());
        viaCep.viaCep(fisicalPerson.getCep());
        fisicalPersonRepository.save(fisicalPerson);
    }

    public FisicalPerson find(int id){
        if(id < 1){
            return null;
        }

        Optional<FisicalPerson> fisicalPerson = fisicalPersonRepository.findById(id);

        return fisicalPerson.orElse(null);
    }

    public List<FisicalPerson> findAll(){
        return fisicalPersonRepository.findAll();
    }

    public FisicalPerson findByCpf(String cpf) throws Exception {
        cpfValidation.cpfValidation(cpf);

        return fisicalPersonRepository.findByCpf(cpf);
    }

    public FisicalPerson findByName(String name){
        return fisicalPersonRepository.findByName(name);
    }

    public FisicalPerson findByEmail(String email) throws EmailInvalidException {
        emailValidation.emailValidation(email);
        return fisicalPersonRepository.findByEmail(email);
    }

    public FisicalPerson findByPhone(String phone){
        return fisicalPersonRepository.findByPhone(phone);
    }

    public List<FisicalPerson> findByAge(int age){
        return fisicalPersonRepository.findByAge(age);
    }

    public List<Goal> findByGoal(Mei mei){
        return fisicalPersonRepository.findByGoal(mei);
    }

    public List<Expense> findByExpense(Mei mei){
        return fisicalPersonRepository.findByExpense(mei);
    }

    public List<Earning> findByEarning(Mei mei){
        return fisicalPersonRepository.findByEarning(mei);
    }

    public void update(int id, FisicalPerson fisicalPerson){
        fisicalPerson.setId(id);
        fisicalPersonRepository.save(fisicalPerson);
    }

    public void delete(int id){
        FisicalPerson fisicalPerson = find(id);
        fisicalPersonRepository.delete(fisicalPerson);
    }
}
