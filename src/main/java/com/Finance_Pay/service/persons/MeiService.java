package com.Finance_Pay.service.persons;

import com.Finance_Pay.apiConsume.ViaCep;
import com.Finance_Pay.exception.EmailInvalidException;
import com.Finance_Pay.model.financialManagements.Earning;
import com.Finance_Pay.model.financialManagements.Expense;
import com.Finance_Pay.model.financialManagements.Goal;
import com.Finance_Pay.model.persons.FinancialConsultant;
import com.Finance_Pay.model.persons.Mei;
import com.Finance_Pay.repository.persons.FinancialConsultantRepository;
import com.Finance_Pay.repository.persons.MeiRepository;
import com.Finance_Pay.validations.CnpjValidation;
import com.Finance_Pay.validations.EmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeiService {

    private final MeiRepository meiRepository;
    private final FinancialConsultantRepository financialConsultantRepository;
    private final EmailValidation emailValidation;
    private final CnpjValidation cnpjValidation;
    private final ViaCep viaCep;

    @Autowired
    public MeiService(MeiRepository meiRepository,
                      FinancialConsultantRepository financialConsultantRepository,
                      EmailValidation emailValidation,
                      CnpjValidation cnpjValidation,
                      ViaCep viaCep) {
        this.meiRepository = meiRepository;
        this.financialConsultantRepository = financialConsultantRepository;
        this.emailValidation = emailValidation;
        this.cnpjValidation = cnpjValidation;
        this.viaCep = viaCep;
    }

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
            throw new IllegalArgumentException("ID must be greater than zero");
        }

        return meiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mei not found with id " + id));
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

    public List<Goal> findByGoal(Mei mei){
        List<Goal> goals = meiRepository.findByGoal(mei);
        return goals != null ? goals : new ArrayList<>();
    }

    public List<Expense> findByExpense(Mei mei){
        List<Expense> expenses = meiRepository.findByExpense(mei);
        return expenses != null ? expenses : new ArrayList<>();
    }

    public List<Earning> findByEarning(Mei mei){
        List<Earning> earnings = meiRepository.findByEarning(mei);
        return earnings != null ? earnings : new ArrayList<>();
    }

    public void update(int id, Mei mei){
        if(!meiRepository.existsById(id)){
            throw new RuntimeException("Mei not found with id " + id);
        }

        mei.setId(id);
        meiRepository.save(mei);
    }

    public void delete(int id){
        if(!meiRepository.existsById(id)){
            throw new RuntimeException("Mei not found with id " + id);
        }

        Mei mei = find(id);
        meiRepository.delete(mei);
    }
}
