package com.mrtlptkn.javaoopandsolidprinciples.solid.dip.best;

import com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best.CheckingAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Slf4j
@Component
public class MsSqlCheckingAccountRepository implements IRepository {
    @Override
    public CheckingAccount find(String accountNumber) {
        log.info("MS SQL Find Account");
        return new CheckingAccount(accountNumber);
    }

    @Override
    public void save(CheckingAccount account) {
        log.info("MS SQL Save Account");
    }
}
