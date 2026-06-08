package com.mrtlptkn.javaoopandsolidprinciples.controller;

import com.mrtlptkn.javaoopandsolidprinciples.contact.InvestmentContact;
import com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best.InvestmentAccount;
import com.mrtlptkn.javaoopandsolidprinciples.oop.fund.InvestmentFund;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/investment")
public class InvestmentController {


    @GetMapping
    public String getInvestmentInfo() {

        // 2. olarak ise Bir servisin InvestmentContact interface'inden implemente olan herhangi bir sınıf ile çalışma esnekliği uygulama genelinde sağlamış olurum.

        // Farklı sınıflar aynı yetenekleri interfaceler vasıtası ile tek bir çatı altından alabilir.
        // İnterface kullanımının yazılım yaşam döngüsündeki en hayati özelliği budur.

        InvestmentContact investmentContract = new InvestmentAccount("123456789");
        investmentContract.apply(BigDecimal.valueOf(10.000), "USD");
        BigDecimal money1 = investmentContract.investmentIntoCash();

        InvestmentContact investmentContact2 = new InvestmentFund();
        investmentContact2.apply(BigDecimal.valueOf(10.000), "USD");
        BigDecimal money2 = investmentContact2.investmentIntoCash();



        return "Investment information";
    }

}
