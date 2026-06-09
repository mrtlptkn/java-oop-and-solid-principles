package com.mrtlptkn.javaoopandsolidprinciples.controller;

import com.mrtlptkn.javaoopandsolidprinciples.solid.isp.best.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/isp")
public class IspController {

    @PostMapping
    public ResponseEntity<String> best(){

        ITimeSeriesReportOnly<PayrollEntity,Long> timeSeriesReportOnly = new PayrollRepository();

        IReadOnlyRepo<PayrollEntity,Long> readOnlyRepo = new PayrollRepository();

        readOnlyRepo.findAll();

        // code defensing -> kodu modin bozulmalarından korur ve yanlış bir modelleme üzerinden olmayan bir özelliği göre kod yazmamızı engeller.
        // IRepository<PayrollEntity,Long> repository = new PayrollRepository();

        return ResponseEntity.ok("ISP");


    }


}
