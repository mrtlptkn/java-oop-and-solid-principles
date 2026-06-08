package com.mrtlptkn.javaoopandsolidprinciples.solid.srp.bad;

import lombok.extern.slf4j.Slf4j;

// cohesion için ne diyebiliriz ?
// srp için ne diyebiliriz  ?


// SRP -> Sınıfın değişmek için tek bir sebebinin olması lazım.
// Eğer birden fazla sebebimiz varsa methodları başka sınıflara ayırmamız lazım.

// Cohesion -> sınıfın içindeki methodların sınıfa olan uyumluluğu -> Eğer uyumlu değilse
// uyumlu olacak şekilde methodları sınıflara ayırmalıyız.

@Slf4j
public class UserManager {

    public void  create() {
      log.info("User created");
    }

    public void delete() {
        log.info("User deleted");
    }


    public void update() {
        log.info("User updated");
    }


    public void get() {
        log.info("User get");
    }


    public void validate() {
        log.info("User validated");
    }

    public void sendEmail() {
        log.info("Email sent to user");
    }


    public void generateReport() {
        log.info("Report generated for user");
    }

}
