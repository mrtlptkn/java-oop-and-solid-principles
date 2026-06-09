package com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.bad;

public class Rectangle extends TwoDimesionShape {
    @Override
    public Double getPerimeter() {
        return this.getWidth() * 2 + this.getHeight() * 2;
    }

    @Override
    public Double getArea() {
        return this.getWidth()* this.getHeight();
    }
}
