package com.Finance_Pay.repository.transactions;

import com.Finance_Pay.model.accounts.Account;
import com.Finance_Pay.model.transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByAccount(Account account);

    List<Transaction> findByDate(Date date);

    List<Transaction> findByName(String name);
}
