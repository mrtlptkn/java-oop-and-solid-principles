package com.mrtlptkn.javaoopandsolidprinciples.solid.dip.best;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// High Level Class

@Component
@Slf4j
public class TransferOrcService {

    // Low Level Class (MSSQLCheckingRepo veya PostgresCheckingRepo)
    private final IRepository repository;
    // İnterfaceler ise iki sınıfı birbirleri ile konuşturan kapılar (PORT)

    // Low Level (AI veya Normal Fraud)
    private final IFraudDetector fraudDetector;


    // DI da interface üzerinden alarak. DI interface injecte etme zorunluluğu yok.
    public TransferOrcService(IRepository repository, IFraudDetector fraudDetector) {
        this.repository = repository;
        this.fraudDetector = fraudDetector;
    }

    public void transfer(String sourceAccountNumber, String destinationAccountNumber, BigDecimal amount) {
        log.info("Starting transfer process");

        if (fraudDetector.isSuspiciousTransfer(sourceAccountNumber, destinationAccountNumber, amount)) {
            log.warn("Suspicious transfer detected. Aborting transfer.");
            return;
        }

        var sourceAccount = repository.find(sourceAccountNumber);
        var destinationAccount = repository.find(destinationAccountNumber);

        sourceAccount.moneyOut(amount,"TL");
        destinationAccount.moneyIn(amount,"TL");

        repository.save(sourceAccount);
        repository.save(destinationAccount);

        log.info("Transfer completed successfully");
    }

}
