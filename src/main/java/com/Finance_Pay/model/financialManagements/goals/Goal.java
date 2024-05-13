package com.Finance_Pay.model.financialManagements.goals;

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
@Table(name = "goal")
public class Goal extends FinancialManagement {

    private String description;
    private Date dayOfPurchase;

    @ManyToOne
    private FisicalPerson fisicalPerson;

    @ManyToOne
    private Sme sme;

    @Enumerated(EnumType.ORDINAL)
    private TypeOfCosts typeOfCosts;

    public Goal(FinancialManagementDTO financialManagementDTO) {
        this.id = financialManagementDTO.id();
        this.value = financialManagementDTO.value();
        this.dayOfPurchase = getDayOfPurchase();
        this.name = financialManagementDTO.name();
        this.description = getDescription();
        this.fisicalPerson = getFisicalPerson();
        this.sme = getSme();
        this.typeOfCosts = getTypeOfCosts();
    }
}
