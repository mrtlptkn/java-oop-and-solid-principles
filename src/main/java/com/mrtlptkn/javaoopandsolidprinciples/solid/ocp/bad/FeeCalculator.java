package com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.bad;

import java.math.BigDecimal;


// Bu sınıf yeni müşteri türleri eklendiğinde değiştirilmek zorunda kalacak, bu da OCP'ye aykırıdır. Yeni müşteri türleri eklendiğinde, mevcut kodun değiştirilmesi gerekecektir, bu da hatalara ve bakım zorluklarına yol açabilir. Bu nedenle, bu sınıf OCP'ye uygun değildir.

public class FeeCalculator {

    BigDecimal calculate(String customerType, BigDecimal amount){
        if(customerType.equals("Standard")){
            return calculateStandardFee(amount);
        } else if (customerType.equals("Premium")) {
            return amount.multiply(new BigDecimal("0.05"));
        } else if (customerType.equals("VIP")) {
            return amount.multiply(new BigDecimal("0.02"));
        } else if (customerType.equals("Employee")) {
            return amount.multiply(new BigDecimal("0.15"));
        } else {
            throw new IllegalArgumentException("Invalid customer type");
        }
    }

    private BigDecimal calculateStandardFee(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.1"));
    }


}
