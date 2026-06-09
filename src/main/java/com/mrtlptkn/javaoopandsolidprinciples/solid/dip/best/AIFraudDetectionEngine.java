package com.mrtlptkn.javaoopandsolidprinciples.solid.dip.best;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class AIFraudDetectionEngine implements IFraudDetector {
    @Override
    public Boolean isSuspiciousTransfer(String sourceAccount, String destinationAccount, BigDecimal amount) {
        log.info("AI fraud detection engine: Analyzing transfer with AI algorithms");
        return false;
    }
}
