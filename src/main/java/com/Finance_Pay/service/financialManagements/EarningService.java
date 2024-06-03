package com.Finance_Pay.service.financialManagements;

import com.Finance_Pay.enums.TypeOfIncomes;
import com.Finance_Pay.model.financialManagements.Earning;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Mei;
import com.Finance_Pay.repository.financialManagements.EarningRepository;
import com.Finance_Pay.repository.persons.FisicalPersonRepository;
import com.Finance_Pay.repository.persons.MeiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EarningService {

    private final EarningRepository earningRepository;
    private final MeiRepository meiRepository;
    private final FisicalPersonRepository fisicalPersonRepository;

    @Autowired
    public EarningService(EarningRepository earningRepository,
                          MeiRepository meiRepository,
                          FisicalPersonRepository fisicalPersonRepository) {
        this.earningRepository = earningRepository;
        this.meiRepository = meiRepository;
        this.fisicalPersonRepository = fisicalPersonRepository;
    }

    public void saveByMei(int id, Earning earning){
        Optional<Mei> optionalMei = meiRepository.findById(id);

        if(optionalMei.isPresent()){
            Mei mei = optionalMei.get();
            earning.setMei(mei);
            earningRepository.save(earning);
        }else{
            throw new IllegalArgumentException("O ID " + id + " não foi encontrado no repositório");
        }
    }

    public void saveByFisicalPerson(int id, Earning earning){
        Optional<FisicalPerson> optionalFisicalPerson = fisicalPersonRepository.findById(id);

        if(optionalFisicalPerson.isPresent()){
            FisicalPerson fisicalPerson = optionalFisicalPerson.get();
            earning.setFisicalPerson(fisicalPerson);
            earningRepository.save(earning);
        }else{
            throw new IllegalArgumentException("O ID " + id + " não foi encontrado no repositório");
        }
    }

    public Earning find(int id){
        if(id < 1){
            return null;
        }

        Optional<Earning> earning = earningRepository.findById(id);

        return earning.orElse(null);
    }

    public List<Earning> findAll(){
        return earningRepository.findAll();
    }

    public List<Earning> findByName(String name){
        return earningRepository.findByName(name);
    }

    public List<Earning> findByType(TypeOfIncomes typeOfIncomes){
        return earningRepository.findByType(typeOfIncomes);
    }

    public void update(int id, Earning earning){
        earning.setId(id);
        earningRepository.save(earning);
    }

    public void delete(int id){
        Earning earning = find(id);
        earningRepository.delete(earning);
    }
}
