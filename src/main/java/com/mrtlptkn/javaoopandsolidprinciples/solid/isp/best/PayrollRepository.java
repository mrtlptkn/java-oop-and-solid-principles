package com.mrtlptkn.javaoopandsolidprinciples.solid.isp.best;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


// Bu sayede hem read Only hemde raport Only oluşturabildik.
// ISP en güzel özelliği modellemeyi sınıf için esnek bir şekilde inşaa edebilmek.

@Repository
public class PayrollRepository implements ITimeSeriesReportOnly<PayrollEntity,Long>, IPayrollRepository {
    @Override
    public List<PayrollEntity> findAll(LocalDate startAt, LocalDate endAt) {
        return List.of();
    }

    @Override
    public List<PayrollEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<PayrollEntity> findOne(Long Id) {
        return Optional.empty();
    }

    @Override
    public List<PayrollEntity> filterByDepartment(String department) {
        return List.of();
    }
}
