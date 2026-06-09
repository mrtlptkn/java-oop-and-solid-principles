package com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.best;

public class Rect extends PlaneGeometricShape {

    private final Double width;
    private final Double height;

    public Rect(Double width, Double height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public Double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public Double getArea() {
        return width  * height;
    }



}
