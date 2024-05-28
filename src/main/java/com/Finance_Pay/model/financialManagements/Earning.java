package com.Finance_Pay.model.financialManagements;

import com.Finance_Pay.enums.TypeOfIncomes;
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

@EqualsAndHashCode()
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "earning")
public class Earning{

    private Integer id;
    private double value;
    private String name;
    private String description;

    @ManyToOne
    private FisicalPerson fisicalPerson;

    @ManyToOne
    private Mei mei;

    @Enumerated(EnumType.ORDINAL)
    private TypeOfIncomes typeOfIncomes;
}
