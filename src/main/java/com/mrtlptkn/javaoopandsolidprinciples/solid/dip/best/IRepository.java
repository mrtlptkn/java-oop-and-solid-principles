package com.mrtlptkn.javaoopandsolidprinciples.solid.dip.best;

import com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best.CheckingAccount;

public interface IRepository {

    CheckingAccount find(String accountNumber);
    void save(CheckingAccount account);

}
