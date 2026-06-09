package com.mrtlptkn.javaoopandsolidprinciples.solid.isp.bad;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// ReadOnly bir table olsun Reporları okuyacağımız bir tablo bu
// OLAP -> aylık, quarter, yıllık -> Bazı verileri raporluyoruz
// table partition gibi yapılar ile time series ayrılmış kayıt girişi raporlama uzmanları tarafında belirli dönemlerde yapılan. Hakedişleri hesaplama

// Bu tarz raporlama tabloları çok fazla veri hacmine sahip olduğu için ve her bir insert,update,delete işlemi indexleri bozacağı için. OLTP çalışmak bu tarz tablolara tercih edilmez. Bu tarz tablolar sadece SELECT yapılır.

// Bu raporu üretmek için 30 tabloyu joinlersek de bu viewde çok performanslı çalışmaz. Denormalize tutarız. Bu tablolarda normalizyon aramayız.

// Raprolana aya ait çeyreğe ait veriler arşivlenir. Bir daha dokulmaz.

// Sırf bu duruma özel repsoitory açarsam bu durumda genel repository mantığını bozlmuş oluruz.

// Amaç mantıkı bozmadan readOnly ilgili tablolarla çalışabilmek.


@Component
@Slf4j
public class CategoryRepo implements IRepo<CategoryEntity,Long>   {
    @Override
    public List<CategoryEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<CategoryEntity> findOne(Long Id) {
        throw  new RuntimeException("CategoryRepo is read only, findOne method is not implemented") ;
    }

    @Override
    public void create(CategoryEntity categoryEntity) {
        log.info("Category created");
        throw new UnsupportedOperationException("CategoryRepo is read only, create method is not implemented");
    }

    @Override
    public void update(Long id, CategoryEntity categoryEntity) {
        log.info("Category updated");
        throw new UnsupportedOperationException("CategoryRepo is read only, update method is not implemented");
    }

    @Override
    public void delete(Long id) {
        log.info("Category deleted");
        throw new UnsupportedOperationException("CategoryRepo is read only, delete method is not implemented");
    }
}
