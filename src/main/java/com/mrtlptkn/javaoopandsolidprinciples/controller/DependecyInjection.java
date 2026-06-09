package com.mrtlptkn.javaoopandsolidprinciples.controller;

import com.mrtlptkn.javaoopandsolidprinciples.contact.InvestmentContact;
import com.mrtlptkn.javaoopandsolidprinciples.oop.banking.best.InvestmentAccount;
import com.mrtlptkn.javaoopandsolidprinciples.oop.fund.InvestmentFund;
import com.mrtlptkn.javaoopandsolidprinciples.solid.srp.best.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/dependency-injection")
@Tag(name = "Dependency Injection", description = "APIs demonstrating Dependency Injection patterns")
public class DependecyInjection {

    // controller seviyesinde de bir dependecy injection olmalı.


    // DI -> (1.Contructor Injection, 2.Setter Injection, 3.Method Injection)

    // yeni projelerde contructor injection kullanalım. Örnek olsun diye kullandık.
    @Autowired
    private UserManagerService userManagerService; // Setter Injection

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
    @Operation(
            summary = "Demonstrate No Dependency Injection",
            description = "Shows how dependencies are created manually without using dependency injection pattern"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully demonstrated manual dependency creation"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public String noDependecyInjection() {

        // UserManagerService servis ile UserValidator ve diğer sınıfların birbirleri bağımlılık yönetimleri DependecyInjection Controller sınıfı üzerinden yürütülüyor. UserManagerService sınıfında bağımlılık yönetimi yok. Sadece bağımlılıkları enjecte ediyoruz. UserManagerService sınıfında UserValidator, UserRepository, EmailService ve UserReportService sınıflarının instance üretme işlemi yok. Bu işlemi controller seviyesinde yaparak bağımlılık yönetimini controller seviyesine taşımış oluyoruz.

        UserManagerService userManagerService = new UserManagerService(new UserValidator(), new UserRepository(), new EmailService(), new UserReportService());
        userManagerService.createUserAccount();



        return "Investment information";
    }


    @GetMapping("withDependencyInjection")
    @Operation(
            summary = "Demonstrate With Dependency Injection",
            description = "Shows how dependencies are injected through constructor and managed properly"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully demonstrated dependency injection pattern"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public String withDepedencyInjection() {

        // UserManagerService servis ile UserValidator ve diğer sınıfların birbirleri bağımlılık yönetimleri DependecyInjection Controller sınıfı üzerinden yürütülüyor. UserManagerService sınıfında bağımlılık yönetimi yok. Sadece bağımlılıkları enjecte ediyoruz. UserManagerService sınıfında UserValidator, UserRepository, EmailService ve UserReportService sınıflarının instance üretme işlemi yok. Bu işlemi controller seviyesinde yaparak bağımlılık yönetimini controller seviyesine taşımış oluyoruz.

        userManagerService.createUserAccount();

//        UserManagerService userManagerService = new UserManagerService(userValidator, userRepository, emailService, userReportService);
//        userManagerService.createUserAccount();



        return "DI information";
    }



}
