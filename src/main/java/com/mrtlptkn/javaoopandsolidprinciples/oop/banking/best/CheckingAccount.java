package com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

// Vadesiz hesap açısında credit ve debit ile ilgili bir problememiz yok.
// Bunu yapmanın modelimize bir zararı yok
// concrete class -> somut sınıf -> işin detayı burada belli, burada credit debit nasıl hangi algoritma ile yapacağımız belli.

@Slf4j
public class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber) {
        super(accountNumber);
    }

    // polymorphism -> account super class ait kod yerine burada bazlı ara işlemler var bu sebeple ovveride edip
    // bunu bu şekilde kullanacağız.
    @Override
    public void moneyIn(BigDecimal amount, String currency) {
        // Before Log
        log.info("CheckingAccount - Credit operation started. Amount: {}, Currency: {}", amount, currency);
        super.moneyIn(amount, currency);
        // After Log
        log.info("CheckingAccount - Credit operation completed. New Balance: {}", getBalance());

    }
}
