package com.mrtlptkn.javaoopandsolidprinciples.solid.srp.best;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


// servisin değiştirilmesi için birden fazla sebep var mı ?
// servisin içerisinde methodlar sadece user kaydı ile mi alakalı ?

@Slf4j
@Component
public class UserValidator {

    public void validate() {
        log.info("User validated");
    }

}
