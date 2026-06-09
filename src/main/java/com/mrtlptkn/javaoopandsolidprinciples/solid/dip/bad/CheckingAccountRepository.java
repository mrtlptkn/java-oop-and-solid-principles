package com.mrtlptkn.javaoopandsolidprinciples.solid.dip.bad;

import com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best.CheckingAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CheckingAccountRepository {

    CheckingAccount find(String accountNumber) {
        log.info("MS SQL Save Account");
        return  new CheckingAccount(accountNumber);
    }

    public void save(CheckingAccount account) {
      log.info("MS SQL Save Account");
    }
}
