package com.Finance_Pay.model.financialManagements;

import com.Finance_Pay.dto.FinancialManagementDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public double value;
    public String name;

    public FinancialManagement(FinancialManagementDTO financialManagementDTO){
        this.id = financialManagementDTO.id();
        this.value = financialManagementDTO.value();
        this.name = financialManagementDTO.name();
    }
}
