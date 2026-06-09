package com.mrtlptkn.javaoopandsolidprinciples.solid.dip.bad;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FraudDetectionEngine {

    public boolean isSuspiciousTransfer(String sourceAccount, String destinationAccount, double amount) {
        // Basit bir sahtecilik kontrolü örneği
        if (amount > 10000) {
            log.info("Suspicious transfer detected: Amount exceeds threshold");
            return true; // Büyük transferler şüpheli olarak işaretlenir
        }
        if (sourceAccount.equals(destinationAccount)) {
            log.info("Suspicious transfer detected: Source and destination accounts are the same");
            return true; // Aynı hesaba yapılan transferler şüpheli olarak işaretlenir
        }
        return false; // Diğer durumlar normal kabul edilir
    }

}
