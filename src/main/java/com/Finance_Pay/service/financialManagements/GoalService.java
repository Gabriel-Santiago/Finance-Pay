package com.Finance_Pay.service.financialManagements;

import com.Finance_Pay.enums.TypeOfCosts;
import com.Finance_Pay.model.financialManagements.Goal;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Mei;
import com.Finance_Pay.repository.financialManagements.GoalRepository;
import com.Finance_Pay.repository.persons.FisicalPersonRepository;
import com.Finance_Pay.repository.persons.MeiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final MeiRepository meiRepository;
    private final FisicalPersonRepository fisicalPersonRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository,
                       MeiRepository meiRepository,
                       FisicalPersonRepository fisicalPersonRepository) {
        this.goalRepository = goalRepository;
        this.meiRepository = meiRepository;
        this.fisicalPersonRepository = fisicalPersonRepository;
    }

    public void saveByMei(int id, Goal goal){
        Optional<Mei> optionalMei = meiRepository.findById(id);

        if(optionalMei.isPresent()){
            Mei mei = optionalMei.get();
            goal.setMei(mei);
            goalRepository.save(goal);
        }else{
            throw new IllegalArgumentException("O ID " + id + " não foi encontrado no repositório");
        }
    }

    public void saveByFisicalPerson(int id, Goal earning){
        Optional<FisicalPerson> optionalFisicalPerson = fisicalPersonRepository.findById(id);

        if(optionalFisicalPerson.isPresent()){
            FisicalPerson fisicalPerson = optionalFisicalPerson.get();
            earning.setFisicalPerson(fisicalPerson);
            goalRepository.save(earning);
        }else{
            throw new IllegalArgumentException("O ID " + id + " não foi encontrado no repositório");
        }
    }

    public Goal find(int id){
        if(id < 1){
            return null;
        }

        Optional<Goal> goal = goalRepository.findById(id);

        return goal.orElse(null);
    }

    public List<Goal> findAll(){
        return goalRepository.findAll();
    }

    public List<Goal> findByName(String name){
        return goalRepository.findByName(name);
    }

    public List<Goal> findByDayOfPurchase(Date dayOfPurchase){
        return goalRepository.findByDayOfPurchase(dayOfPurchase);
    }

    public List<Goal> findByType(TypeOfCosts typeOfCosts){
        return goalRepository.findByType(typeOfCosts);
    }

    public void update(int id, Goal goal){
        goal.setId(id);
        goalRepository.save(goal);
    }

    public void delete(int id){
        Goal goal = find(id);
        goalRepository.delete(goal);
    }
}
