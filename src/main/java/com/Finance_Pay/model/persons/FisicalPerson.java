package com.Finance_Pay.model.persons;

import com.Finance_Pay.dto.PersonDTO;
import com.Finance_Pay.model.accounts.CheckingAccount;
import com.Finance_Pay.model.accounts.SavingAccount;
import com.Finance_Pay.model.goals.Goal;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "fisicalPerson", uniqueConstraints = {@UniqueConstraint(columnNames = {"itr"})})
public class FisicalPerson extends Person {

    private long itr; // Individual Taxpayer Registration
    private int age;

    @OneToOne(mappedBy = "fisicalPersonCheckingAccount")
    private CheckingAccount checkingAccount;

    @OneToOne(mappedBy = "fisicalPersonSavingAccount")
    private SavingAccount savingAccount;

    @OneToMany
    private Goal goal;

    public FisicalPerson(PersonDTO personDTO){
        this.id = personDTO.id();
        this.name = personDTO.name();
        this.city = personDTO.city();
        this.state = personDTO.state();
        this.email = personDTO.email();
        this.password = personDTO.password();
        this.phone = personDTO.phone();
        this.itr = getItr();
        this.age = getAge();
        this.checkingAccount = getCheckingAccount();
        this.savingAccount = getSavingAccount();
        this.goal = getGoal();
    }
}
