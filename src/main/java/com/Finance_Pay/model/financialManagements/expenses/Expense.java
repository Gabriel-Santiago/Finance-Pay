package com.Finance_Pay.model.financialManagements.expenses;

import com.Finance_Pay.dto.FinancialManagementDTO;
import com.Finance_Pay.enums.TypeOfCosts;
import com.Finance_Pay.model.financialManagements.FinancialManagement;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Sme;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expense")
public class Expense extends FinancialManagement {

    private Date date;

    @ManyToOne
    private FisicalPerson fisicalPerson;

    @ManyToOne
    private Sme sme;

    @Enumerated(EnumType.ORDINAL)
    private TypeOfCosts typeOfCosts;

    public Expense(FinancialManagementDTO financialManagementDTO) {
        this.id = financialManagementDTO.id();
        this.value = financialManagementDTO.value();
        this.name = financialManagementDTO.name();
        this.date = getDate();
        this.fisicalPerson = getFisicalPerson();
        this.sme = getSme();
        this.typeOfCosts = getTypeOfCosts();
    }
}
