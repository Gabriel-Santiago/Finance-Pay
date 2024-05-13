package com.Finance_Pay.model.goals;

import com.Finance_Pay.dto.GoalDTO;
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
@Table(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double value;
    private String name;
    private String description;
    private Date dayOfPurchase;

    @ManyToOne
    private FisicalPerson fisicalPerson;

    @ManyToOne
    private Sme sme;

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    public Goal(GoalDTO goalDTO) {
        this.id = goalDTO.id();
        this.value = goalDTO.value();
        this.dayOfPurchase = goalDTO.dayOfPurchase();
        this.name = goalDTO.name();
        this.description = goalDTO.description();
        this.fisicalPerson = getFisicalPerson();
        this.sme = getSme();
        this.type = getType();
    }
}
