package com.mrtlptkn.javaoopandsolidprinciples;

import com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.best.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class JavaOopAndSolidPrinciplesApplication {

    @Autowired
    private FeeEngine feeEngine;


    public static void main(String[] args) {
       SpringApplication.run(JavaOopAndSolidPrinciplesApplication.class, args);
    }

    @Bean
    public String getName(){
        return "ASli";
    }


    // FeeCalculator Initialize Bean
    // Uygulama içerisinde Butün Feeleri uygulama genelinde tek 1 sefer register etmek için kullandık.
    @Bean
    public Map<String, IFeeCalculator> feeCalculators(Map<String, IFeeCalculator> feeCalculators) {

        feeEngine.register("Standard",new StandardFee());
        feeEngine.register("VIP",new VIPFee());
        feeEngine.register("Premium",new PremiumFee());

        return feeEngine.getCalculatorMap();
    }


}
