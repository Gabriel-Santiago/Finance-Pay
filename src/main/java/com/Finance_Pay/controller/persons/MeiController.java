package com.Finance_Pay.controller.persons;

import com.Finance_Pay.model.financialManagements.Earning;
import com.Finance_Pay.model.financialManagements.Expense;
import com.Finance_Pay.model.financialManagements.Goal;
import com.Finance_Pay.model.persons.Mei;
import com.Finance_Pay.service.persons.MeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("")
public class MeiController {

    @Autowired
    MeiService service;

    @GetMapping(path = "/meis/{id}")
    public ResponseEntity<Mei> find(@PathVariable("id") Integer id){
        Mei mei = service.find(id);

        return new ResponseEntity<>(mei, mei != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Mei>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/meis/{meiId}/goal")
    public ResponseEntity<List<Goal>> findByGoal(@PathVariable("meiId")Integer meiId){
        if(meiId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Mei mei = new Mei();
        mei.setId(meiId);

        List<Goal> goals = service.findByGoal(mei);

        return new ResponseEntity<>(goals, !goals.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/meis/{meiId}/expense")
    public ResponseEntity<List<Expense>> findByExpense(@PathVariable("meiId")Integer meiId){
        if(meiId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Mei mei = new Mei();
        mei.setId(meiId);

        List<Expense> expenses = service.findByExpense(mei);

        return new ResponseEntity<>(expenses, !expenses.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/meis/{meiId}/earning")
    public ResponseEntity<List<Earning>> findByEarning(@PathVariable("meiId")Integer meiId){
        if(meiId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Mei mei = new Mei();
        mei.setId(meiId);

        List<Earning> earnings = service.findByEarning(mei);

        return new ResponseEntity<>(earnings, !earnings.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/meis/search")
    public ResponseEntity<Mei> findByAttribute(@RequestParam(required = false) String cnpj,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String phone,
                                               @RequestParam(required = false) String email) throws Exception {
        Mei mei = null;
        if (cnpj != null) {
            mei = service.findByCnpj(cnpj);
        } else if (name != null) {
            mei = service.findByName(name);
        } else if (phone != null) {
            mei = service.findByPhone(phone);
        } else if (email != null) {
            mei = service.findByEmail(email);
        }

        return new ResponseEntity<>(mei, mei != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/financialConsultant/{id}/meis")
    public ResponseEntity<Void> save(@PathVariable("id")Integer id, @RequestBody Mei mei) throws Exception {
        service.save(id, mei);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/meis/{id}")
    public ResponseEntity<Void> update(@PathVariable("id")Integer id, @RequestBody Mei mei){
        service.update(id, mei);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/meis/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
