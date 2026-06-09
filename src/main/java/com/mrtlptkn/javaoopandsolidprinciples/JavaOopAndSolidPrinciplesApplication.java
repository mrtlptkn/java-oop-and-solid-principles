package com.mrtlptkn.javaoopandsolidprinciples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaOopAndSolidPrinciplesApplication {

    public static void main(String[] args) {
       SpringApplication.run(JavaOopAndSolidPrinciplesApplication.class, args);
    }

    @Bean
    public String getName(){
        return "ASli";
    }

}
