package com.mrtlptkn.javaoopandsolidprinciples.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FeeRequest {
    private String customerType;
    private BigDecimal amount;
}
