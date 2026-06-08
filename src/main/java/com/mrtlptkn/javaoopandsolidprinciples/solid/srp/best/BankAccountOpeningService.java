package com.mrtlptkn.javaoopandsolidprinciples.solid.srp.best;


import lombok.extern.slf4j.Slf4j;


// Eğer bir hesap açılışı işleminin logici değişirse sadece bu servisi güncellemek başka methodlara dokunmadan işlem yapmak, diğer süreçlerden izole olmak istersek o zaman bunu genelde ayrı sınıf olarak servis olarak yaparız.

// BankAccountCloseService

@Slf4j
public class BankAccountOpeningService {

    // VeriTabanı Management
    // Validation Management
    // Log Management
    // Entity Relation Management
    // Rule Management
    // Applition Integration Management

    public void open(){
        log.info("Bank account opened");
    }

}


// BankService
// open,close,bloke, moneyIn, moneyOut, transfer

