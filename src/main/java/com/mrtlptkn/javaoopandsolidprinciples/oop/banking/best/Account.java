package com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best;




// Eğer sistemimizde brikim hesabı, yatırım hesabı gibi farklı hesap türleri varsa, Account sınıfı bizim için hesap ile ilgili ortak özellikleri yönetebileceğimiz bir abstract sınıf olmalıdır.

// abstact tek başına instance alınmayan ama zihnimizde bir anlam ifade eden sınıflar

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


// credit(); -> bankaya borçlanma  ve debit(); ->  bankaya borç ödeme
// SavingAccount -> birikim hesabı (altın,döviz,gümüş,bitcoin) -> hedef checking account üzerinden aktarılan para ile bir birikim yapmak. Acil nakit ihtiyacın oldu paraya çevirebilirsin.
// applySaving(); bu methodlar olmalı
// savingIntoCash(); // birikimi nakte çevir

// Checking Account -> Vadesiz hesap (kredi kullanabilir, kredi kartı talep edebilir, maaşım yatar)
// credit ve debit yapılabilir.

// InvestmentAccount -> yatırım hesabı (çek, hisse senedi) -> uzun vadede para kazandıran varlıklar, hemen satın paraya dönüştüremezsin. yaparsan zarar edersin.
// applyInvestment();
// investmentIntoCash(); // yatırım hesabındaki varlıkları nakde çevir

// Abtractionda yaptık
// 1. Hesap denilen bir nesnin -> Hesap Numarası ve bakiyesinin olması gerektiğini söyledik.
// 2. Hesap üzerinden bu ortak özelliklere sahip farklı hesap yönetim nesneleri türeyebilir.
// 3. account nesnesi üzerinden tüm hesaplarda ortak olan bir davranışıda burada yönetebiliriz.
// Soyut sınıflara yaklaşırken ? Ne tür birikimler var ? Ne tür yatırımlar yapabilirim ?
// Ne tür krediler kullanabilirim ?
public abstract class Account {

    // ortak alan
    @Getter
    private final String accountNumber; // init only setter

    @Getter
    private  final BigDecimal balance;

    @Getter
    @Setter
    private  String currency;


    public Account(String accountNumber) {

        // account number accountNumber field'a set ederken data kontrol yaptık.
        // encapsulation yaptık.
        // dışarıya açık olan getter ve setter ile açık olan attibute'un değerini field aktarmadan önce iç kontrolü yaptık.
        if(accountNumber.length() != 10) {
            throw new IllegalArgumentException("Account number must be 10 characters long");
        }

        this.accountNumber = accountNumber; // benzersiz bir hesap numarası oluşturmak için UUID kullanıyoruz
        this.balance = BigDecimal.valueOf(0);
    }


    // credit ve debit özelliği olmayan sınıflarda sıkıntı.
    // encapsulation için diğer örnek ise credit ve debit methodlarıda çünkü balance değeri negatif olamaz
    // bu verinin kontrolü bir şekilde yönetilmesi gerekir. credit ve debir methodaları public ama balance private bir field'dır.
    public  void moneyIn(BigDecimal amount, String currency) {;
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance.add(amount);
    }


    public  void moneyOut(BigDecimal amount, String currency) {;
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance.subtract(amount);
    }


    // bir hesaba para transferi olacak


}


