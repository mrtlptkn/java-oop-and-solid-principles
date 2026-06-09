package com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.best;


// Herhangi bir 2 boyutlu bir geometrik şekil çevresi varmıdır
// herhangi bir 2 boyutlu şeklin alanı hesaplanabilir mi ?

import lombok.Getter;
import lombok.Setter;

// ancak koordinat düzlemindeki yeri için x, y konumu bütün hepsinde ortak olduğu için bu sınıfı oluşturduk. Diğer sınıflarımızda ortak olan x, y koordinatlarını bu sınıfta tanımladık. Diğer sınıflarımızda ise sadece kendilerine özgü özellikleri tanımlayacağız.

public abstract class TwoDimensionalShape {

    @Setter
    @Getter
    private Double x;

    @Getter
    @Setter
    private Double y;


}
