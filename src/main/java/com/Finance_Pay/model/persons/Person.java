package com.Finance_Pay.model.persons;

import com.Finance_Pay.dto.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    protected int id;
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
