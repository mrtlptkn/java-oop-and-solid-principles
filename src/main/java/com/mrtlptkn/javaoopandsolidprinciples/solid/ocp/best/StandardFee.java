package com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.best;

public class StandardFee implements IFeeCalculator {
    @Override
    public java.math.BigDecimal calculate(java.math.BigDecimal amount) {
        return amount.add(amount.multiply(new java.math.BigDecimal("0.1")));
    }
}
