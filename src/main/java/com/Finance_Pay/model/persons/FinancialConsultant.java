package com.Finance_Pay.model.persons;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode()
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financialConsultant")
public class FinancialConsultant{

    private Integer id;
    private String name;
    private String cep;
    private String city;
    private String state;
    private String email;
    private String phone;
    private String password;

    @OneToMany
    private List<FisicalPerson> fisicalPersons;

    @OneToMany
    private List<Mei> meis;
}
