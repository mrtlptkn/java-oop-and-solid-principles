package com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.bad;

public class KochSnowFlake extends TwoDimesionShape {

    @Override
    public Double getPerimeter() {
        return null;
    }


    // Her 2 boyutlu shape alanı hesaplanamadığı için bu şekilde bir tanımlama yapmak zorunda kaldık. Bu da Liskov Substitution Principle'a aykırıdır. Çünkü getArea() methodunu çağıran herhangi bir kod bloğu bu sınıfın bir örneği ile karşılaştığında UnsupportedOperationException hatası alacaktır.
    @Override
    public Double getArea() {
        throw new UnsupportedOperationException("KochSnowFlake alanı hesaplanamaz");
    }
}
