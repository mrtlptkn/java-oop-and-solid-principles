package com.mrtlptkn.javaoopandsolidprinciples.solid.ocp.best;

import java.math.BigDecimal;


// Hizmet Bedeli Hesapla, Çalışan Hakediş Hesaplama, Müşteri Tipine Göre Hizmet Bedeli Hesaplama gibi farklı hesaplama türleri eklenebilir, ancak mevcut kodun değiştirilmesi gerekmez. Yeni hesaplama türleri eklemek için yeni sınıflar oluşturulabilir ve mevcut kodun değiştirilmesine gerek kalmaz. Bu nedenle, bu sınıf OCP'ye uygundur.
public interface IFeeCalculator {
    BigDecimal calculate(BigDecimal amount);
}
