package com.Finance_Pay.model.persons;


import com.Finance_Pay.dto.PersonDTO;
import com.Finance_Pay.model.financialManagements.earnings.Earning;
import com.Finance_Pay.model.financialManagements.expenses.Expense;
import com.Finance_Pay.model.financialManagements.goals.Goal;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "legalPerson", uniqueConstraints = {@UniqueConstraint(columnNames = {"crn"})})
public class Mei extends Person {

    private String cnpj;

    @OneToMany
    private Goal goal;

    @OneToMany
    private Expense expense;

    @OneToMany
    private Earning earning;

    @ManyToOne
    private FinancialConsultant financialConsultant;

    public Mei(PersonDTO personDTO){
        this.id = personDTO.id();
        this.name = personDTO.name();
        this.cep = personDTO.cep();
        this.city = personDTO.city();
        this.state = personDTO.state();
        this.email = personDTO.email();
        this.phone = personDTO.phone();
        this.cnpj = getCnpj();
        this.goal = getGoal();
        this.expense = getExpense();
        this.earning = getEarning();
        this.financialConsultant = getFinancialConsultant();
    }
}
