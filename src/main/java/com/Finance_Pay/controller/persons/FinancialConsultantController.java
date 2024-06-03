package com.Finance_Pay.controller.persons;

import com.Finance_Pay.model.persons.FinancialConsultant;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Mei;
import com.Finance_Pay.service.persons.FinancialConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping(path = "/financial- consultant")
public class FinancialConsultantController {

    @Autowired
    FinancialConsultantService service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<FinancialConsultant> find(@PathVariable("id") Integer id){
        FinancialConsultant financialConsultant = service.find(id);

        if(financialConsultant != null){
            return new ResponseEntity<>(financialConsultant, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<FinancialConsultant>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/fisical-person")
    public ResponseEntity<List<FisicalPerson>> findByFisicalPerson(@RequestParam("financialConsultantId")Integer financialConsultantId){
        FinancialConsultant financialConsultant = new FinancialConsultant();
        financialConsultant.setId(financialConsultantId);

        List<FisicalPerson> fisicalPersonList = service.findByFisicalPerson(financialConsultant);

        if(!fisicalPersonList.isEmpty()){
            return new ResponseEntity<>(fisicalPersonList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/mei")
    public ResponseEntity<List<Mei>> findByMei(@RequestParam("financialConsultantId")Integer financialConsultantId){
        FinancialConsultant financialConsultant = new FinancialConsultant();
        financialConsultant.setId(financialConsultantId);

        List<Mei> meiList = service.findByMei(financialConsultant);

        if(!meiList.isEmpty()){
            return new ResponseEntity<>(meiList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/city")
    public ResponseEntity<List<FinancialConsultant>> findByCity(@RequestParam("city")String city){
        List<FinancialConsultant> financialConsultants = service.findByCity(city);

        if(!financialConsultants.isEmpty()){
            return new ResponseEntity<>(financialConsultants, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/state")
    public ResponseEntity<List<FinancialConsultant>> findByState(@RequestParam("state")String state){
        List<FinancialConsultant> financialConsultants = service.findByState(state);

        if(!financialConsultants.isEmpty()){
            return new ResponseEntity<>(financialConsultants, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/name")
    public ResponseEntity<FinancialConsultant> findByName(@RequestParam("name")String name){
        FinancialConsultant financialConsultant = service.findByName(name);

        if(financialConsultant != null){
            return new ResponseEntity<>(financialConsultant, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void save(@RequestBody FinancialConsultant financialConsultant) throws Exception {
        service.save(0, financialConsultant);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable("id")Integer id, @RequestBody FinancialConsultant financialConsultant) throws Exception {
        service.save(id, financialConsultant);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id")Integer id){
        service.delete(id);
    }
}
