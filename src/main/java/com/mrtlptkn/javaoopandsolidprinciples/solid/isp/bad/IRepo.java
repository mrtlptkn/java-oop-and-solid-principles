package com.mrtlptkn.javaoopandsolidprinciples.solid.isp.bad;


// Amaç: Veritabanı erişim katmanına daha bağımsız bir şekilde bağlanmak

import java.util.List;
import java.util.Optional;



public interface IRepo<TEntity, TKey> {

    List<TEntity> findAll();
    Optional<TEntity> findOne(TKey Id);

    void create(TEntity entity);
    void update(TKey id, TEntity entity);
    void delete(TKey id);

}
