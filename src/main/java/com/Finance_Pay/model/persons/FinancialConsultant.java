package com.Finance_Pay.model.persons;

import com.Finance_Pay.dto.PersonDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financialConsultant")
public class FinancialConsultant extends Person {

    @OneToMany
    private List<FisicalPerson> fisicalPersons;

    @OneToMany
    private List<Sme> smes;

    public FinancialConsultant(PersonDTO personDTO){
        this.id = personDTO.id();
        this.name = personDTO.name();
        this.city = personDTO.city();
        this.state = personDTO.state();
        this.email = personDTO.email();
        this.password = personDTO.password();
        this.phone = personDTO.phone();
        this.fisicalPersons = getFisicalPersons();
        this.smes = getSmes();
    }
}
