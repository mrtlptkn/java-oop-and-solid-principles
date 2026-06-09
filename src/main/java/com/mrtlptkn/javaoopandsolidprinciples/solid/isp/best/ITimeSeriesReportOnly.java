package com.mrtlptkn.javaoopandsolidprinciples.solid.isp.best;

import java.time.LocalDate;

public interface ITimeSeriesReportOnly<TEntity,TKey> extends IReadOnlyRepo<TEntity, TKey> {
    java.util.List<TEntity> findAll(LocalDate startAt,LocalDate endAt);
}
