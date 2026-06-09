package com.mrtlptkn.javaoopandsolidprinciples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaOopAndSolidPrinciplesApplication {

    public static void main(String[] args) {
       ApplicationContext context =  SpringApplication.run(JavaOopAndSolidPrinciplesApplication.class, args);

       String result =  context.getBean("getName").toString();
        System.out.println(result);;


    }

    @Bean
    public String getName(){
        return "ASli";
    }

}
