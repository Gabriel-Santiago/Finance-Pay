package com.Finance_Pay.model.persons;

import com.Finance_Pay.model.financialManagements.Earning;
import com.Finance_Pay.model.financialManagements.Expense;
import com.Finance_Pay.model.financialManagements.Goal;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.ManyToOne;
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
@Table(name = "legalPerson", uniqueConstraints = {@UniqueConstraint(columnNames = {"cnpj"})})
public class Mei{

    private Integer id;
    private String name;
    private String cep;
    private String city;
    private String state;
    private String email;
    private String phone;
    private String cnpj;

    @OneToMany
    private List<Goal> goals;

    @OneToMany
    private List<Expense> expenses;

    @OneToMany
    private List<Earning> earnings;

    @ManyToOne
    private FinancialConsultant financialConsultant;
}
