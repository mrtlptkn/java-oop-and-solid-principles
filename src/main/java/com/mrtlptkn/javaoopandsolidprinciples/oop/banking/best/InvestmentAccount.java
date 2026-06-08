package com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best;

import com.mrtlptkn.javaoopandsolidprinciples.contact.InvestmentContact;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

// Inheritance uyguladık
@Slf4j
public class InvestmentAccount extends Account implements InvestmentContact {
    public InvestmentAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void moneyOut(BigDecimal amount, String currency) {
        log.info("InvestmentAccount - Debit operation started. Amount: {}, Currency: {}", amount, currency);
        moneyOut(amount, currency);
    }

    @Override
    public void moneyIn(BigDecimal amount, String currency) {
        log.info("InvestmentAccount - Credit operation started. Amount: {}, Currency: {}", amount, currency);
        moneyIn(amount, currency);
    }

    @Override
    public void apply(BigDecimal amount, String currency) {
        log.info("InvestmentAccount - Apply operation started. Amount: {}, Currency: {}", amount, currency);
        // yatırım hesabına para yatırma işlemi
    }

    @Override
    public BigDecimal investmentIntoCash() {
        log.info("InvestmentAccount - Investment into cash operation started.");
        return null;
    }
}
