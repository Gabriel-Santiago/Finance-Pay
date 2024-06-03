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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FisicalPersonService {

    private final FisicalPersonRepository fisicalPersonRepository;
    private final FinancialConsultantRepository financialConsultantRepository;
    private final EmailValidation emailValidation;
    private final CpfValidation cpfValidation;
    private final ViaCep viaCep;

    @Autowired
    public FisicalPersonService(FisicalPersonRepository fisicalPersonRepository,
                                FinancialConsultantRepository financialConsultantRepository,
                                EmailValidation emailValidation,
                                CpfValidation cpfValidation, ViaCep viaCep) {
        this.fisicalPersonRepository = fisicalPersonRepository;
        this.financialConsultantRepository = financialConsultantRepository;
        this.emailValidation = emailValidation;
        this.cpfValidation = cpfValidation;
        this.viaCep = viaCep;
    }

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
            throw new IllegalArgumentException("ID must be greater than zero");
        }

        return fisicalPersonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fisical Person not found with id " + id));
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
        List<Goal> goals = fisicalPersonRepository.findByGoal(mei);
        return goals != null ? goals : new ArrayList<>();
    }

    public List<Expense> findByExpense(Mei mei){
        List<Expense> expenses = fisicalPersonRepository.findByExpense(mei);
        return expenses != null ? expenses : new ArrayList<>();
    }

    public List<Earning> findByEarning(Mei mei){
        List<Earning> earnings = fisicalPersonRepository.findByEarning(mei);
        return earnings != null ? earnings : new ArrayList<>();
    }

    public void update(int id, FisicalPerson fisicalPerson){
        if(!fisicalPersonRepository.existsById(id)){
            throw new RuntimeException("Fisical Person not found with id " + id);
        }

        fisicalPerson.setId(id);
        fisicalPersonRepository.save(fisicalPerson);
    }

    public void delete(int id){
        if(!fisicalPersonRepository.existsById(id)){
            throw new RuntimeException("Fisical Person not found with id " + id);
        }

        FisicalPerson fisicalPerson = find(id);
        fisicalPersonRepository.delete(fisicalPerson);
    }
}
