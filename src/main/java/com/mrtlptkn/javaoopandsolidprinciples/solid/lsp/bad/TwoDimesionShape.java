package com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.bad;


import lombok.Getter;
import lombok.Setter;

// Liskov için kalıtım zincirinin doğru kurulması ve bu zincirdeki hernhangi bir kalıtım alan sınıfın birbiri yerine kulanılabilmesi gerekir.

public abstract class TwoDimesionShape {

    @Getter
    @Setter
   private Double width;

    @Getter
    @Setter
    private Double height;

    @Getter
    @Setter
    private Double radius;

    public abstract Double getPerimeter();
   public abstract Double getArea();



}
