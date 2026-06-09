package com.mrtlptkn.javaoopandsolidprinciples.controller;

import com.mrtlptkn.javaoopandsolidprinciples.solid.dip.best.TransferOrcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/dip")
public class DipController {

    private final TransferOrcService transferOrcService;


    public DipController(TransferOrcService transferOrcService) {
        this.transferOrcService = transferOrcService;
    }

    @PostMapping("/best")
    public ResponseEntity<String> best() {

        transferOrcService.transfer("123456789", "987654321",  BigDecimal.valueOf(1000));


        return ResponseEntity.ok("DIP Best");
    }

}
