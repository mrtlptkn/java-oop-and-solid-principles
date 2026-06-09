package com.mrtlptkn.javaoopandsolidprinciples.solid.dip.best;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
@Primary
public class NormalFraudDetectionEngine implements IFraudDetector {
    @Override
    public Boolean isSuspiciousTransfer(String sourceAccount, String destinationAccount, BigDecimal amount) {
        log.info("Normal fraud detection engine: All transfers are considered safe");
        return false; // Normal bir sahtecilik tespit motoru, tüm transferleri güvenli olarak kabul eder
    }
}
