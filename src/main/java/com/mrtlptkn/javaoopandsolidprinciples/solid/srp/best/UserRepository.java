package com.mrtlptkn.javaoopandsolidprinciples.solid.srp.best;

import lombok.extern.slf4j.Slf4j;


// veri erişiminde sorumlu sınıf
// servisin değiştirilmesi için birden fazla sebep var mı ?
// servisin içerisinde methodlar sadece user kaydı ile mi alakalı ?
// Genel bir repository açmanın faydası veya zararı ne olurdu tartışalım.

@Slf4j
public class UserRepository {

    public void create(){
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
}
