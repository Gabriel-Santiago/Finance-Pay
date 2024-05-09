package com.Finance_Pay.model.persons;

import com.Finance_Pay.dto.PersonDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String name;
    protected String city;
    protected String state;
    protected String email;
    protected String password;
    protected String phone;

    public Person (PersonDTO personDTO){
        this.id = personDTO.id();
        this.name = personDTO.name();
        this.city = personDTO.city();
        this.state = personDTO.state();
        this.email = personDTO.email();
        this.password = personDTO.password();
        this.phone = personDTO.phone();
    }
}
