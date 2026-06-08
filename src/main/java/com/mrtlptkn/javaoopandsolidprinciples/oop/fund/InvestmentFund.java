package com.mrtlptkn.javaoopandsolidprinciples.oop.fund;

import com.mrtlptkn.javaoopandsolidprinciples.contact.InvestmentContact;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class InvestmentFund implements InvestmentContact {
    @Override
    public void apply(java.math.BigDecimal amount, String currency) {
        // yatırım fonuna para yatırma işlemi
        log.info("Applying to investment fund. Amount: {}, Currency: {}", amount, currency);
    }

    @Override
    public java.math.BigDecimal investmentIntoCash() {
        // yatırım fonundan nakit çekme işlemi
        log.info("Converting investment fund into cash.");
        return null;
    }
}
