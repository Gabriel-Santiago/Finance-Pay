package com.Finance_Pay.service.financialManagements;

import com.Finance_Pay.enums.TypeOfCosts;
import com.Finance_Pay.model.financialManagements.Expense;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Mei;
import com.Finance_Pay.repository.financialManagements.ExpenseRepository;
import com.Finance_Pay.repository.persons.FisicalPersonRepository;
import com.Finance_Pay.repository.persons.MeiRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    ExpenseRepository expenseRepository;

    MeiRepository meiRepository;

    FisicalPersonRepository fisicalPersonRepository;

    public void saveByMei(int id, Expense expense){
        Optional<Mei> optionalMei = meiRepository.findById(id);

        if(optionalMei.isPresent()){
            Mei mei = optionalMei.get();
            expense.setMei(mei);
            expenseRepository.save(expense);
        }else{
            throw new IllegalArgumentException("O ID " + id + " não foi encontrado no repositório");
        }
    }

    public void saveByFisicalPerson(int id, Expense expense){
        Optional<FisicalPerson> optionalFisicalPerson = fisicalPersonRepository.findById(id);

        if(optionalFisicalPerson.isPresent()){
            FisicalPerson fisicalPerson = optionalFisicalPerson.get();
            expense.setFisicalPerson(fisicalPerson);
            expenseRepository.save(expense);
        }else{
            throw new IllegalArgumentException("O ID " + id + " não foi encontrado no repositório");
        }
    }

    public Expense find(int id){
        if(id < 1){
            return null;
        }

        Optional<Expense> expense = expenseRepository.findById(id);

        return expense.orElse(null);
    }

    public List<Expense> findAll(){
        return expenseRepository.findAll();
    }

    public List<Expense> findByDate(Date date){
        return expenseRepository.findByDate(date);
    }

    public List<Expense> findByName(String name){
        return expenseRepository.findByName(name);
    }

    public List<Expense> findByType(TypeOfCosts typeOfCosts){
        return expenseRepository.findByType(typeOfCosts);
    }

    public void update(int id, Expense expense){
        expense.setId(id);
        expenseRepository.save(expense);
    }

    public void delete(int id){
        Expense expense = find(id);
        expenseRepository.delete(expense);
    }
}
