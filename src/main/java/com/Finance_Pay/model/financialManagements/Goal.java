package com.Finance_Pay.model.financialManagements;

import com.Finance_Pay.enums.TypeOfCosts;
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

import java.util.Date;

@EqualsAndHashCode()
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "goal")
public class Goal{

    private Integer id;
    private double value;
    private String name;
    private String description;
    private Date dayOfPurchase;

    @ManyToOne
    private FisicalPerson fisicalPerson;

    @ManyToOne
    private Mei mei;

    @Enumerated(EnumType.ORDINAL)
    private TypeOfCosts typeOfCosts;
}
