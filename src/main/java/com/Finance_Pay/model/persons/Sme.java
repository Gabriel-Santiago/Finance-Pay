package com.Finance_Pay.model.persons;


import com.Finance_Pay.dto.PersonDTO;
import com.Finance_Pay.model.expenses.Expense;
import com.Finance_Pay.model.goals.Goal;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "legalPerson", uniqueConstraints = {@UniqueConstraint(columnNames = {"crn"})})
public class Sme extends Person {

    private long crn; // Company Registration Number

    @OneToMany
    private Goal goal;

    @OneToMany
    private Expense expense;

    @ManyToOne
    private FinancialConsultant financialConsultant;

    public Sme(PersonDTO personDTO){
        this.id = personDTO.id();
        this.name = personDTO.name();
        this.city = personDTO.city();
        this.state = personDTO.state();
        this.email = personDTO.email();
        this.password = personDTO.password();
        this.phone = personDTO.phone();
        this.crn = getCrn();
        this.goal = getGoal();
        this.expense = getExpense();
        this.financialConsultant = getFinancialConsultant();
    }
}
