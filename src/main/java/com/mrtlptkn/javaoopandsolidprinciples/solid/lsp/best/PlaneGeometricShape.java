package com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.best;

public abstract class PlaneGeometricShape extends TwoDimensionalShape {

    // Nasıl hesaplanacağı hakkında bir bilgiye sahip değiliz. Bu sebeple abstract tanımlıyoruz
    abstract public Double getPerimeter();
    abstract public Double getArea();

    // uzunluk, yarı çap, genişlik somut geometrik sınıfı ilgilendirir.
}
