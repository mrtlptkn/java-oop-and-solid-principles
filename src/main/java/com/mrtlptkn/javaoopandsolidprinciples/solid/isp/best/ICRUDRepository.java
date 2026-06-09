package com.mrtlptkn.javaoopandsolidprinciples.solid.isp.best;

public interface ICRUDRepository<TEntity,TKey> {

    void create(TEntity entity);
    void update(TKey id, TEntity entity);
    void delete(TKey id);

}
