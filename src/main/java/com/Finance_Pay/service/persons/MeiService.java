package com.Finance_Pay.service.persons;

import com.Finance_Pay.apiConsume.ViaCep;
import com.Finance_Pay.exception.EmailInvalidException;
import com.Finance_Pay.model.financialManagements.earnings.Earning;
import com.Finance_Pay.model.financialManagements.expenses.Expense;
import com.Finance_Pay.model.financialManagements.goals.Goal;
import com.Finance_Pay.model.persons.FinancialConsultant;
import com.Finance_Pay.model.persons.Mei;
import com.Finance_Pay.repository.persons.FinancialConsultantRepository;
import com.Finance_Pay.repository.persons.MeiRepository;
import com.Finance_Pay.validations.CnpjValidation;
import com.Finance_Pay.validations.EmailValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeiService {

    MeiRepository meiRepository;

    FinancialConsultantRepository financialConsultantRepository;

    EmailValidation emailValidation;

    CnpjValidation cnpjValidation;

    ViaCep viaCep;

    public void save(int financialConsultantId, Mei mei) throws Exception{
        FinancialConsultant financialConsultant = financialConsultantRepository.findById(financialConsultantId)
                .orElseThrow(() ->
                        new RuntimeException("Financial Consultant not found with id " + financialConsultantId));

        mei.setFinancialConsultant(financialConsultant);
        emailValidation.emailValidation(mei.getEmail());
        cnpjValidation.cnpjValidation(mei.getCnpj());
        viaCep.viaCep(mei.getCep());
        meiRepository.save(mei);
    }

    public Mei find(int id){
        if(id < 1){
            return null;
        }

        Optional<Mei> mei = meiRepository.findById(id);

        return mei.orElse(null);
    }

    public List<Mei> findAll(){
        return meiRepository.findAll();
    }

    public Mei findByCnpj(String cnpj) throws Exception {
        cnpjValidation.cnpjValidation(cnpj);
        return meiRepository.findByCnpj(cnpj);
    }

    public Mei findByName(String name){
        return meiRepository.findByName(name);
    }

    public Mei findByEmail(String email) throws EmailInvalidException {
        emailValidation.emailValidation(email);
        return meiRepository.findByEmail(email);
    }

    public Mei findByPhone(String phone){
        return meiRepository.findByPhone(phone);
    }

    public List<Mei> findByGoal(Goal goal){
        return meiRepository.findByGoal(goal);
    }

    public List<Mei> findByExpense(Expense expense){
        return meiRepository.findByExpense(expense);
    }

    public List<Mei> findByEarning(Earning earning){
        return meiRepository.findByEarning(earning);
    }

    public void update(int id, Mei mei){
        mei.setId(id);
        meiRepository.save(mei);
    }

    public void delete(int id){
        Mei mei = find(id);
        meiRepository.delete(mei);
    }
}
