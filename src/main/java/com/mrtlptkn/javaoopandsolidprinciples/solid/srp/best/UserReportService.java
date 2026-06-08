package com.mrtlptkn.javaoopandsolidprinciples.solid.srp.best;

import lombok.extern.slf4j.Slf4j;


// userReport servisin değiştirilmesi için birden fazla sebep var mı ?
// userReport servisin methodlar sadece userReport ile mi alakalı ?
// Neden genel bir Report Servis açmadık ?  açamaz mıydık ?

@Slf4j
public class UserReportService {

    public void generateReport() {
        log.info("Report generated for user");
    }
}
