package com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.bad;

import java.util.Objects;

public class Square extends TwoDimesionShape {


    @Override
    public Double getPerimeter() {

        // Şu yazılan kod liskova aykırı bir kod örneği.
        if(!Objects.equals(getHeight(), getWidth())) {
            throw new RuntimeException("Square must have equal width and height");
        }

        return 2* (getHeight() + getHeight());
    }

    @Override
    public Double getArea() {

        if(!Objects.equals(getHeight(), getWidth())) {
            throw new RuntimeException("Square must have equal width and height");
        }

        return 4 * getWidth();
    }
}
