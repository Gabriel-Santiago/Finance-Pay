package com.Finance_Pay.model.expenses;

import com.Finance_Pay.dto.ExpenseDTO;
import com.Finance_Pay.enums.Type;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Sme;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double value;
    private Date date;
    private String name;

    @ManyToOne
    private FisicalPerson fisicalPerson;

    @ManyToOne
    private Sme sme;

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    public Expense(ExpenseDTO expenseDTO) {
        this.id = expenseDTO.id();
        this.value = expenseDTO.value();
        this.date = expenseDTO.date();
        this.name = expenseDTO.name();
        this.fisicalPerson = getFisicalPerson();
        this.sme = getSme();
        this.type = getType();
    }
}
