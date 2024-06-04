package com.Finance_Pay.controller.persons;

import com.Finance_Pay.model.financialManagements.Earning;
import com.Finance_Pay.model.financialManagements.Expense;
import com.Finance_Pay.model.financialManagements.Goal;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.service.persons.FisicalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FisicalPersonController {

    @Autowired
    FisicalPersonService service;

    @GetMapping(path = "/fisical-person/{id}")
    public ResponseEntity<FisicalPerson> find(@PathVariable("id")Integer id){
        FisicalPerson fisicalPerson = service.find(id);

        return new ResponseEntity<>(fisicalPerson, fisicalPerson != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/fisical-person")
    public ResponseEntity<List<FisicalPerson>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/fisical-person/{fisicalPersonId}/goal")
    public ResponseEntity<List<Goal>> findByGoal(@PathVariable("fisicalPersonId")Integer fisicalPersonId){
        if(fisicalPersonId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        FisicalPerson fisicalPerson = new FisicalPerson();
        fisicalPerson.setId(fisicalPersonId);

        List<Goal> goals = service.findByGoal(fisicalPerson);

        return new ResponseEntity<>(goals, !goals.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/fisical-person/{fisicalPersonId}/earning")
    public ResponseEntity<List<Earning>> findByEarning(@PathVariable("fisicalPersonId")Integer fisicalPersonId){
        if(fisicalPersonId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        FisicalPerson fisicalPerson = new FisicalPerson();
        fisicalPerson.setId(fisicalPersonId);

        List<Earning> earnings = service.findByEarning(fisicalPerson);

        return new ResponseEntity<>(earnings, !earnings.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/fisical-person/{fisicalPersonId}/expense")
    public ResponseEntity<List<Expense>> findByExpense(@PathVariable("fisicalPersonId")Integer fisicalPersonId){
        if(fisicalPersonId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        FisicalPerson fisicalPerson = new FisicalPerson();
        fisicalPerson.setId(fisicalPersonId);

        List<Expense> expenses = service.findByExpense(fisicalPerson);

        return new ResponseEntity<>(expenses, !expenses.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/fisical-person/{age}")
    public ResponseEntity<List<FisicalPerson>> findByAge(@PathVariable("age")Integer age){
        if(age == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        FisicalPerson fisicalPerson = new FisicalPerson();
        fisicalPerson.setAge(age);

        List<FisicalPerson> fisicalPersonList = service.findByAge(age);

        return new ResponseEntity<>(fisicalPersonList, !fisicalPersonList.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    //cpf, name, email, phone
    @GetMapping("/fisical-person/search")
    public ResponseEntity<FisicalPerson> findByAttribute(@RequestParam(required = false) String cpf,
                                                         @RequestParam(required = false) String name,
                                                         @RequestParam(required = false) String email,
                                                         @RequestParam(required = false) String phone) throws Exception{

        FisicalPerson fisicalPerson = null;

        if(cpf != null){
            fisicalPerson = service.findByCpf(cpf);
        }else if(name != null){
            fisicalPerson = service.findByName(name);
        }else if(email != null){
            fisicalPerson = service.findByEmail(email);
        }else if(phone != null){
            fisicalPerson = service.findByPhone(phone);
        }

        return new ResponseEntity<>(fisicalPerson, fisicalPerson != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/financialConsultant/{id}/fisical-person")
    public ResponseEntity<Void> save(@PathVariable("id")Integer id, @RequestBody FisicalPerson fisicalPerson) throws Exception {
        service.save(id, fisicalPerson);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/fisical-person/{id}")
    public ResponseEntity<Void> update(@PathVariable("id")Integer id, @RequestBody FisicalPerson fisicalPerson){
        service.update(id, fisicalPerson);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/fisical-person/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
