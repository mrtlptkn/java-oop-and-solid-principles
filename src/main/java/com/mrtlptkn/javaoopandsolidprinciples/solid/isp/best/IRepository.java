package com.mrtlptkn.javaoopandsolidprinciples.solid.isp.best;


// Tüm repository özellikleri IRepository interfaceden gelsin
// Ama isteyen IReadOnlyRepo veya TimeSeriesReport Repoyu ve sadece CrudRepoyu kullanabilsin.

// Interface tanımlarken olabildiğince atomic özellikler ile tanımlanmalıdır. Yani tek bir sorumluluğu olmalıdır. Bu sayede istemeyen özellikleri kullanmaz ve kod daha temiz olur.
public interface IRepository extends ICRUDRepository<PayrollEntity,Long>, IReadOnlyRepo<PayrollEntity,Long>, ITimeSeriesReportOnly<PayrollEntity,Long> {
}
