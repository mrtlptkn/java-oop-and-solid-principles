package com.mrtlptkn.javaoopandsolidprinciples.controller;

import com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.bad.KochSnowFlake;
import com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.bad.Rectangle;
import com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.bad.Square;
import com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.bad.TwoDimesionShape;
import com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.best.PlaneGeometricShape;
import com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.best.Rect;
import com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.best.Sqrt;
import com.mrtlptkn.javaoopandsolidprinciples.solid.lsp.best.TwoDimensionalShape;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lsp")
public class LspController {


    @PostMapping("bad")
    public ResponseEntity<String> lspBad() {

        TwoDimesionShape rect = new Rectangle();
        rect.setHeight(10.0);
        rect.setWidth(5.0);

        rect.getPerimeter();
        rect.getArea();

        // Rectangle ile Square new kısımlarının yerini değiştirince kod çalışabiliyor mu ?

        TwoDimesionShape square = new Square();
        square.setWidth(10.0);

        // yukarıdaki bir setter aşağısı için anlamasız
        // radius setter ikisi içinde anlamsın.

//        square.getPerimeter();
//        square.getArea();


        TwoDimesionShape koch = new KochSnowFlake();
        koch.getArea(); // Exception




        return ResponseEntity.ok("LSP");
    }


    @PostMapping("best")
    public ResponseEntity<String> lspBest() {

        PlaneGeometricShape rect = new Sqrt(5.0);
        rect.setX(5.0);
        rect.setY(10.5);
        rect.getPerimeter();
        rect.getArea();

        // Rectangle ile Square new kısımlarının yerini değiştirince kod çalışabiliyor mu ?

        PlaneGeometricShape square = new Rect(15.0,20.0);
        rect.setX(20.5);
        rect.setY(40.2);


        // yukarıdaki bir setter aşağısı için anlamasız
        // radius setter ikisi içinde anlamsın.

        square.getPerimeter();
        square.getArea();





        return ResponseEntity.ok("LSP");
    }

}
