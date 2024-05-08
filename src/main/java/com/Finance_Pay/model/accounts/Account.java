package com.Finance_Pay.model.accounts;

import com.Finance_Pay.dto.AccountDTO;
import com.Finance_Pay.model.transactions.Transaction;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    protected String accountNumber;
    protected double balance;

    @OneToMany
    protected List<Transaction> transaction;

    public Account (AccountDTO accountDTO){
        this.accountNumber = accountDTO.accountNumber();
        this.balance = accountDTO.balance();
    }
}
