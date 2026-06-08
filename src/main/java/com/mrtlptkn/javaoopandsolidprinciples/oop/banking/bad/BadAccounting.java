package com.mrtlptkn.javaoopandsolidprinciples.oop.banking.bad;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

// Veri tabanında tek tablo -> Program tarafında Tek Entity ve Bu entity bağlı tek bir Service
// Bu kod bloğu bir süre sonra bir anti pattern dönüşüyor ->
// Bu antipatterne Anemic Domain Class -> Kanayan İş Sınıfı
// Bu eğer bir servis ise ve içerisinde hem veri işleleri hem analogic kullanıcı use case herşey bir sınıf içerisinde yönetilmeye başlanıyorsa anti pattern God Object
// Validasyonda var, request var, mapping de var, save var.
public class BadAccounting {

    // ortak alan
    @Getter
    @Setter
    private String accountNumber; // init only setter
    // 10 karakter kontrolü yok

    @Getter
    @Setter
    private  BigDecimal balance;
    // > 0 kontrolü yok negatif olabilir

    @Getter
    @Setter
    private  String currency;


    @Getter
    private final String type; // type göre hareket etmek gerekiyor. String yanlış girilebilir.

    public BadAccounting(String type){
        this.type = type;
    }


    // 1.Kötü yazım şekli
    // Method büyüme eğliminde
    public  void moneyIn(BigDecimal amount, String currency) {;


        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        // clean code dan çıkacaktık.
        if(type.equals("SavingsAccount")){
            // sadece savingsAccount ile ilgili alanları doldur.
            savingsAccountMoneyIn(amount,currency);
        } else if (type.equals("CheckingAccount")) {
            checkingAccountMoneyIn(amount,currency);

        } else if (type.equals("InvestmentAccount")) {
            investmentAccountMoneyIn(amount,currency);
        }


        balance.add(amount);
    }


    // geliştirici satırlarca uzayıp okunması zorlaşmasın diye private methodlara ayırıyor iş süreçlerini
    // hem methodu unit testini yazması daha kolay oluyor.
    private void savingsAccountMoneyIn(BigDecimal amount, String currency) {
        // sadece savingsAccount ile ilgili alanları doldur.
    }

    private void checkingAccountMoneyIn(BigDecimal amount, String currency) {
        // sadece checkingAccount ile ilgili alanları doldur.
    }

    private void investmentAccountMoneyIn(BigDecimal amount, String currency) {
        // sadece investmentAccount ile ilgili alanları doldur.
    }


    public  void moneyOut(BigDecimal amount, String currency) {;
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance.add(amount);
    }


}
