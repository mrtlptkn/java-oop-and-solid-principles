package com.mrtlptkn.javaoopandsolidprinciples.solid.dip.best;

import com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best.CheckingAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PostgresCheckingAccountRepository implements IRepository {
    @Override
    public CheckingAccount find(String accountNumber) {
        log.info("PostgreSQL Find Account");
        return new CheckingAccount(accountNumber);
    }

    @Override
    public void save(CheckingAccount account) {
    log.info("PostgreSQL Save Account");
    }
}
