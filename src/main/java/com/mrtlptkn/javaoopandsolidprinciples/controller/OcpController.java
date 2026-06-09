package com.mrtlptkn.javaoopandsolidprinciples.controller;

import com.mrtlptkn.javaoopandsolidprinciples.dto.FeeRequest;
import com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.bad.FeeCalculator;
import com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.best.FeeEngine;
import com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.best.IFeeCalculator;
import com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.best.StandardFee;
import com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.best.VIPFee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("api/ocp")
public class OcpController {


    private final FeeEngine feeEngine;
    private final Map<String, IFeeCalculator> feeCalculators;

    public OcpController(FeeEngine feeEngine, Map<String, IFeeCalculator> feeCalculators) {
        this.feeEngine = feeEngine;
        this.feeCalculators = feeCalculators;
    }



    @PostMapping("calculateFee")
    public ResponseEntity<String> calculateFee() {
        // OCP -> Open Closed Principle -> Açık Kapalı Prensibi
        // Bir sınıfın değiştirilmeden yeni özellikler eklenebilmesi prensibidir.
        // Yeni bir müşteri tipi eklemek istediğimizde mevcut kodu değiştirmeden yeni bir sınıf ekleyerek bu işlemi gerçekleştirebiliriz. Mevcut kodu değiştirmediğimiz için mevcut kodun çalışmasını etkilemez ve yeni özellikler ekleyebiliriz.

        IFeeCalculator standardFeeCalculator = new StandardFee();
        IFeeCalculator vipFee = new VIPFee();


        // Fee engine hesaplanacak şeyleri ekle
        feeEngine.register("Standard", standardFeeCalculator);
        feeEngine.register("VIP", vipFee);

        // Fee engine içerisinde hesaplanacak şeyleri çağır.
        BigDecimal standart =  feeEngine.calculate("Standard", new BigDecimal("1000"));
        BigDecimal vip = feeEngine.calculate("VIP", new BigDecimal("1000"));


        return ResponseEntity.ok("Standard Fee: " + standart + " VIP Fee: " + vip);
    }


    @PostMapping("calculateFeeV2")
    public ResponseEntity<String> calculateFeeV2(@RequestBody FeeRequest request) {
        // OCP -> Open Closed Principle -> Açık Kapalı Prensibi
        // Bir sınıfın değiştirilmeden yeni özellikler eklenebilmesi prensibidir.
        // Yeni bir müşteri tipi eklemek istediğimizde mevcut kodu değiştirmeden yeni bir sınıf ekleyerek bu işlemi gerçekleştirebiliriz. Mevcut kodu değiştirmediğimiz için mevcut kodun çalışmasını etkilemez ve yeni özellikler ekleyebiliriz.

        BigDecimal result =  feeCalculators.get(request.getCustomerType()).calculate(request.getAmount());



        return ResponseEntity.ok("Fee Result ->" + result);
    }


}
