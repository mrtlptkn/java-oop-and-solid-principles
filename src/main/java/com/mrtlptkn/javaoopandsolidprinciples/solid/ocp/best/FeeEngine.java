package com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.best;


// Hizmet Bedeli hesaplama motoru
// İçerisinde birden fazla hizmete dair bilgileri liste olarak tutalım daha sonra
// hangi hizmet bedeline göre hesaplama yapmak istersek onu çağıralım

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// Buradaki temel amaç fee tipine göre hesaplama hiçbir if else komutu yazmadan
// runtimeda karar verebilmek. Yeni bir fee tipi eklemek istediğimizde sadece yeni bir class oluşturup onu register etmemiz yeterli olacak. Mevcut kodu değiştirmemize gerek kalmayacak. Bu da OCP'ye uygun bir tasarım sağlar.

@Component
public class FeeEngine {

    @Getter
    private final Map<String,IFeeCalculator> calculatorMap = new HashMap<>();





    public void register(String key,IFeeCalculator calculator){
        calculatorMap.put(key,calculator);
    }

    public BigDecimal calculate(String key, BigDecimal amount){
        IFeeCalculator calculator = calculatorMap.get(key);
        // eğer engine içerisinde bu calculator tipi yoksa hata ver.
        // Varsa hesapla.
        if(calculator == null){
            throw new IllegalArgumentException("No calculator found for key: " + key);
        }

        // ifeecalcultor tipindeki herhangi bir class çalıştırabiliriz.
        // esnek bir mimari yapı oluşturmuş olduk.
        return calculator.calculate(amount);
    }
}
