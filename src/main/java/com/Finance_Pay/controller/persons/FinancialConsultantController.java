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
@RequestMapping(path = "/financial-consultant")
public class FinancialConsultantController {

    @Autowired
    FinancialConsultantService service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<FinancialConsultant> find(@PathVariable("id") Integer id){
        FinancialConsultant financialConsultant = service.find(id);

        return new ResponseEntity<>(financialConsultant, financialConsultant != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<FinancialConsultant>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{financialConsultantId}/fisical-person")
    public ResponseEntity<List<FisicalPerson>> findByFisicalPerson(@PathVariable("financialConsultantId")Integer financialConsultantId){
        FinancialConsultant financialConsultant = new FinancialConsultant();
        financialConsultant.setId(financialConsultantId);

        List<FisicalPerson> fisicalPersonList = service.findByFisicalPerson(financialConsultant);

        return new ResponseEntity<>(fisicalPersonList, !fisicalPersonList.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/{financialConsultantId}/mei")
    public ResponseEntity<List<Mei>> findByMei(@PathVariable("financialConsultantId")Integer financialConsultantId){
        FinancialConsultant financialConsultant = new FinancialConsultant();
        financialConsultant.setId(financialConsultantId);

        List<Mei> meiList = service.findByMei(financialConsultant);

        return new ResponseEntity<>(meiList, !meiList.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/city")
    public ResponseEntity<List<FinancialConsultant>> findByCity(@RequestParam("city")String city){
        List<FinancialConsultant> financialConsultants = service.findByCity(city);

        return new ResponseEntity<>(financialConsultants, !financialConsultants.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/state")
    public ResponseEntity<List<FinancialConsultant>> findByState(@RequestParam("state")String state){
        List<FinancialConsultant> financialConsultants = service.findByState(state);

        return new ResponseEntity<>(financialConsultants, !financialConsultants.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/name")
    public ResponseEntity<FinancialConsultant> findByName(@RequestParam("name")String name){
        FinancialConsultant financialConsultant = service.findByName(name);

        return new ResponseEntity<>(financialConsultant, financialConsultant != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody FinancialConsultant financialConsultant) throws Exception {
        service.save(0, financialConsultant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@PathVariable("id")Integer id, @RequestBody FinancialConsultant financialConsultant) throws Exception {
        service.save(id, financialConsultant);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
