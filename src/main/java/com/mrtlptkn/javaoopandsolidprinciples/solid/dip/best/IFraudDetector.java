package com.mrtlptkn.javaoopandsolidprinciples.solid.dip.best;

import java.math.BigDecimal;

public interface IFraudDetector {
   Boolean isSuspiciousTransfer(String sourceAccount, String destinationAccount, BigDecimal amount);
}
