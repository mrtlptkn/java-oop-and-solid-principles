package com.mrtlptkn.javaoopandsolidprinciples.controller;

import com.mrtlptkn.javaoopandsolidprinciples.contact.InvestmentContact;
import com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best.InvestmentAccount;
import com.mrtlptkn.javaoopandsolidprinciples.oop.fund.InvestmentFund;
import com.mrtlptkn.javaoopandsolidprinciples.solid.srp.best.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/dependency-injection")
public class DependecyInjection {

    // controller seviyesinde de bir dependecy injection olmalı.


    private final UserValidator userValidator;
    private final  UserRepository userRepository;
    private final EmailService emailService;
    private final UserReportService userReportService;

    public DependecyInjection(UserValidator userValidator, UserRepository userRepository, EmailService emailService, UserReportService userReportService) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.userReportService = userReportService;
    }


    @GetMapping("noDependencyInjection")
    public String noDependecyInjection() {

        // UserManagerService servis ile UserValidator ve diğer sınıfların birbirleri bağımlılık yönetimleri DependecyInjection Controller sınıfı üzerinden yürütülüyor. UserManagerService sınıfında bağımlılık yönetimi yok. Sadece bağımlılıkları enjecte ediyoruz. UserManagerService sınıfında UserValidator, UserRepository, EmailService ve UserReportService sınıflarının instance üretme işlemi yok. Bu işlemi controller seviyesinde yaparak bağımlılık yönetimini controller seviyesine taşımış oluyoruz.

        UserManagerService userManagerService = new UserManagerService(new UserValidator(), new UserRepository(), new EmailService(), new UserReportService());
        userManagerService.createUserAccount();



        return "Investment information";
    }


    @GetMapping("withDependencyInjection")
    public String withDepedencyInjection() {

        // UserManagerService servis ile UserValidator ve diğer sınıfların birbirleri bağımlılık yönetimleri DependecyInjection Controller sınıfı üzerinden yürütülüyor. UserManagerService sınıfında bağımlılık yönetimi yok. Sadece bağımlılıkları enjecte ediyoruz. UserManagerService sınıfında UserValidator, UserRepository, EmailService ve UserReportService sınıflarının instance üretme işlemi yok. Bu işlemi controller seviyesinde yaparak bağımlılık yönetimini controller seviyesine taşımış oluyoruz.

        UserManagerService userManagerService = new UserManagerService(userValidator, userRepository, emailService, userReportService);
        userManagerService.createUserAccount();



        return "Investment information";
    }



}
