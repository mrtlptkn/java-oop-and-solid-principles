package com.mrtlptkn.javaoopandsolidprinciples.contact;

import java.math.BigDecimal;

// Intefacelerde Abstraction sağlar
// Asbtraction ile birlikte Polymorphismde sağlar.
// Interfaceler ancak bir class'a imğplemnte edilince bir anlam ifade eder.
public interface InvestmentContact {

    // Bu methodun investment account ile investment fund bu method farklı şekillerde uygular ama aynı arayüzü kullanarak ortak bir sözleşme üzerinden bunu yapar.
    void apply(BigDecimal amount, String currency);
    BigDecimal investmentIntoCash();

}
