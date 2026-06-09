package com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.best;

import java.math.BigDecimal;

public class VIPFee implements IFeeCalculator{
    @Override
    public BigDecimal calculate(BigDecimal amount) {
        return amount.add(amount.multiply(new BigDecimal("0.02")));
    }
}
