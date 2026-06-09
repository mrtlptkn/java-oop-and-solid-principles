package com.mrtlptkn.javaoopandsolidprinciples.solid.dip.bad;


import com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// Fraud Detection Moduülü ile Engine tabanlı bir süpheli para tranfer kontrolü yapar.
// Senaryo: Uygulama içerisinde farklı finansal modüllerde fraudDetectionEngine servisi kullanılıyor. +100 referances
// accountRepository -> uygulamada 200+ referansı var ve şuan MSSQL altyapısna bağımlı.


// İstenilen şey ise -> Artık altyapı olarak Postgres'e geçiyoruz. Checking Account Repository gibi binlerce repository güncellemesi yapmamız lazım
// BDDK bir regülasyon yayınladı buna göre kodda bir çok yer güncellenmeli. Security Regülasyonu yayınlandı, bu regülasyona göre para transferlerinde ekstra bir güvenlik kontrolü eklenmeli. Bu sebeple kodda bir çok yer güncellenmeli. vs vs vs // Fraud Detection artık AI tabanlı olucak, bu sebeple belirli bir para transfer hacminin üstünde normal engine kullanmayacağız. Üst Yönetim Kararı.

// Şuanki koda göre başımıza gelenler
// 1. Refactor sürecimiz var
// 2. Unit Test sürecimiz var
// 3. Daha önce çalışan modülleri tekrar test otomastonundan geçirmemiz lazım
// 4. Yeni yazılan kodları sonarqube üzerinden analiz etme var.


@Slf4j
@Component
public class TransferOrchestratorService {

    // Checking Account repository'sine doğrudan bağımlıyız. Eğer başka bir tür hesap eklemek istersek bu sınıfı değiştirmemiz gerekecek. Bu da DIP'e aykırıdır.
    private final CheckingAccountRepository accountRepository = new CheckingAccountRepository();
    // FraudDetectionEngine direkt olarak bağımlıyız.
    private final FraudDetectionEngine fraudDetectionEngine = new FraudDetectionEngine();

    // eğer süpheli bir durum yoksa para taransferini gerçekleştir.
    public void tranfer(Account source, Account to, BigDecimal amount){
        // fraud detection

        if (fraudDetectionEngine.isSuspiciousTransfer(source.getAccountNumber(), to.getAccountNumber(), amount.doubleValue())) {
            log.warn("Transfer flagged as suspicious and blocked.");
            return; // Şüpheli transferler engellenir
        }

        var sourceEntity = accountRepository.find(source.getAccountNumber());
        sourceEntity.moneyOut(amount,"TL");
        var destinationEntity = accountRepository.find(to.getAccountNumber());
        destinationEntity.moneyIn(amount,"TL");

        accountRepository.save(sourceEntity);
        accountRepository.save(destinationEntity);

        log.info("Initiating transfer from {} to {} for amount {}", source.getAccountNumber(), to.getAccountNumber(), amount);

    }
}
