package com.mrtlptkn.javaoopandsolidprinciples.solid.srp.best;


// yeni kullanıcı hesabı oluşturma işlemi

// Belirli operasyonları yapabilmek için
// 0. User Validate et
// 1. EmailService ile çalışmak zorunda
// 2. UserRepository ile çalışmak zorunda
// 3. UserReportService ile çalışmak zorunda

// Spring Ioc Yarının konusu olsun @Component, @Service, @Respository

import org.springframework.stereotype.Service;

@Service
public class UserManagerService {

    // DI ile bu sınıf artık, loose coupled çalışıyor. tam olabilmesi için bu örnekteki sınıfların interface sahip olması lazım. Not: Yarın bunuda yapalım.


    // private final UserValidator userValidator = new UserValidator();
    // yukarıdaki yazım şekli tight coupled bir yaklaşım.
    private final UserValidator userValidator;
    private final UserRepository userRepository;
    private final UserReportService userReportService;
    private final EmailService emailService;

    // dependecy injection pattern ile servis instance üretme işlemini usermanager sınıfındn dışından yapaarak. sadece bağımlılığı enjecte ediyoruz.
    // Bağımlılık yönetimi bu sınıfta olmuyor
    public UserManagerService(UserValidator userValidator,UserRepository userRepository,EmailService emailService, UserReportService userReportService){
        this.emailService = emailService;
        this.userReportService = userReportService;
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }




    public  void createUserAccount(){

        this.userValidator.validate();
        this.userRepository.create();

        this.userRepository.get(); // gerçekten user create edildi mi? emin olmak için.

        this.emailService.sendEmail();
        this.userReportService.generateReport();
    }








}
