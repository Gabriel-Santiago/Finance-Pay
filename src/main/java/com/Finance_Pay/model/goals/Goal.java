package com.Finance_Pay.model.goals;

import com.Finance_Pay.dto.GoalDTO;
import com.Finance_Pay.model.persons.FisicalPerson;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "goal")
public class Goal {

    private Integer id;
    private double value;
    private String name;
    private String description;
    private Date dayOfPurchase;

    @ManyToOne
    private FisicalPerson fisicalPerson;

    public Goal (GoalDTO goalDTO){
        this.id = goalDTO.id();
        this.value = goalDTO.value();
        this.dayOfPurchase = goalDTO.dayOfPurchase();
        this.name = goalDTO.name();
        this.description = goalDTO.description();
        this.fisicalPerson = getFisicalPerson();
    }
}
