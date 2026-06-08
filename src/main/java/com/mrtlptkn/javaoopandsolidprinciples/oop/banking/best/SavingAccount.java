package com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best;

// SavingAccount is a Account -> getBalance, getAccountAccount -> ortak.


import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class SavingAccount extends Account {


    public SavingAccount(String accountNumber) {
        super(accountNumber);
    }

    // dummy code -> anlamsız mecburiyetten yazılan kod bloğu
    // aslında saving account credit ve debit yapamıyor ama account üzerinden kalıtım aldığımızdan
    // bu methodlardan exception fırlatma mecburiyetinde kaldık.

    @Override
    public void moneyIn(BigDecimal amount, String currency) {
        log.info("SavingAccount - Credit operation started. Amount: {}, Currency: {}", amount, currency);
       super.moneyIn(amount, currency);
    }

    @Override
    public void moneyOut(BigDecimal amount, String currency) {
        log.info("SavingAccount - Debit operation started. Amount: {}, Currency: {}", amount, currency);
        super.moneyIn(amount, currency);
    }
}
