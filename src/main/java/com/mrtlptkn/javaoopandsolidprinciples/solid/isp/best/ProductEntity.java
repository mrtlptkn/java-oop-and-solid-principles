package com.mrtlptkn.javaoopandsolidprinciples.solid.isp.best;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ProductEntity implements IRepository {
    @Override
    public void create(PayrollEntity payrollEntity) {

    }

    @Override
    public void update(Long id, PayrollEntity payrollEntity) {

    }

    @Override
    public void delete(Long id) {

    }

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
}
