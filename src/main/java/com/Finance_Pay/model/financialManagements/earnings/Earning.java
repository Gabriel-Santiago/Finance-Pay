package com.Finance_Pay.model.financialManagements.earnings;

import com.Finance_Pay.dto.FinancialManagementDTO;
import com.Finance_Pay.enums.TypeOfIncomes;
import com.Finance_Pay.model.financialManagements.FinancialManagement;
import com.Finance_Pay.model.persons.FisicalPerson;
import com.Finance_Pay.model.persons.Mei;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "earning")
public class Earning extends FinancialManagement {

    private String description;

    @ManyToOne
    private FisicalPerson fisicalPerson;

    @ManyToOne
    private Mei mei;

    @Enumerated(EnumType.ORDINAL)
    private TypeOfIncomes typeOfIncomes;

    public Earning(FinancialManagementDTO financialManagementDTO){
        this.id = financialManagementDTO.id();
        this.value = financialManagementDTO.value();
        this.name = financialManagementDTO.name();
        this.description = getDescription();
        this.fisicalPerson = getFisicalPerson();
        this.mei = getMei();
        this.typeOfIncomes = getTypeOfIncomes();
    }
}
