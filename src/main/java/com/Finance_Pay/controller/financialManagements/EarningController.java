package com.Finance_Pay.controller.financialManagements;

import com.Finance_Pay.enums.TypeOfIncomes;
import com.Finance_Pay.model.financialManagements.Earning;
import com.Finance_Pay.service.financialManagements.EarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EarningController {

    @Autowired
    EarningService service;

    @GetMapping(path = "/earning/{id}")
    public ResponseEntity<Earning> find(@PathVariable("id") Integer id){
        Earning earning = service.find(id);

        return new ResponseEntity<>(earning, earning != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/earning")
    public ResponseEntity<List<Earning>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/earning/{name}")
    public  ResponseEntity<List<Earning>> findByName(@PathVariable("name")String name){
        if(name == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Earning earning = new Earning();
        earning.setName(name);

        List<Earning> earningList = service.findByName(name);

        return new ResponseEntity<>(earningList, !earningList.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/earning/{typeOfIncomes}")
    public  ResponseEntity<List<Earning>> findByType(@PathVariable("typeOfIncomes")TypeOfIncomes typeOfIncomes){
        if(typeOfIncomes == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Earning earning = new Earning();
        earning.setTypeOfIncomes(typeOfIncomes);

        List<Earning> earningList = service.findByType(typeOfIncomes);

        return new ResponseEntity<>(earningList, !earningList.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/mei/{id}/earning")
    public ResponseEntity<Void> saveByMei(@PathVariable("id")Integer id, @RequestBody Earning earning){
        service.saveByMei(id, earning);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/fisical-person/{id}/earning")
    public ResponseEntity<Void> saveByFisicalPerson(@PathVariable("id")Integer id, @RequestBody Earning earning){
        service.saveByFisicalPerson(id, earning);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/earning/{id}")
    public ResponseEntity<Void> update(@PathVariable("id")Integer id, @RequestBody Earning earning){
        service.update(id, earning);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/earning/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
