package com.Finance_Pay.model.transactions;

import com.Finance_Pay.dto.TransactionDTO;
import com.Finance_Pay.model.accounts.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double value;
    private Date date;
    private String name;
    private String description;

    @ManyToOne
    private Account account;

    public Transaction (TransactionDTO transactionDTO){
        this.id = transactionDTO.id();
        this.value = transactionDTO.value();
        this.date = transactionDTO.date();
        this.name = transactionDTO.name();
        this.description = transactionDTO.description();
        this.account = getAccount();
    }
}
