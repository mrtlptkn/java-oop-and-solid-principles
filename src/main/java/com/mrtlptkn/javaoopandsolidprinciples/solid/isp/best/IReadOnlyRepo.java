package com.mrtlptkn.javaoopandsolidprinciples.solid.isp.best;

import java.util.List;
import java.util.Optional;

public interface IReadOnlyRepo<TEntity,TKey> {

    List<TEntity> findAll();
    Optional<TEntity> findOne(TKey Id);

}
