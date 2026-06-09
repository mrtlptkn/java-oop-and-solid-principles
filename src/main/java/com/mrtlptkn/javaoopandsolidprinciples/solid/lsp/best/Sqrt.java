package com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.best;

public class Sqrt extends PlaneGeometricShape {


    private final Double width;

    public Sqrt(Double width) {
        super();
        this.width = width;
    }


    @Override
    public Double getPerimeter() {
        return 4 * width;
    }

    @Override
    public Double getArea() {
        return width * width;
    }


}
