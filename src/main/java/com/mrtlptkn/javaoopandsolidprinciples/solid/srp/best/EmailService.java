package com.mrtlptkn.javaoopandsolidprinciples.solid.srp.best;


// email gönderimlerini tek bir merkezden güncellemek ve yönetmek için bunu yaptık

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

// email servisin değiştirilmesi için birden fazla sebep var mı ?
// email servis içerisinde methodlar sadece email gönderimi ile mi alakalı ?

// SRp kararı verirken eğer koheszyon açısından bir rsik unsuuru teşkil etmiyorsa her bir methodu bir sınıfa ayırmayı genel olarak yönetilebilir bulmuyoruz. Ama aslında SRp diyor ki bir sınıfın değişmesi için tek bir sebep olmalı
// isEmailFormat methodu eklenince değişmek için 2. bir sebep ortaya çıkıyor.

@Slf4j
@Service
public class EmailService {

    public void sendEmail() {
        log.info("Email sent to user");
    }

    // kohesyon açısında isEmailformat methodu yazmanın bir zararı yok.
    private Boolean isEmailFormat(){
        return  true;
    }


}
