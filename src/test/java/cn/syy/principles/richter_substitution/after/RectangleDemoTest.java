package cn.syy.principles.richter_substitution.after;

import org.junit.jupiter.api.Test;

class RectangleDemoTest {

    @Test
    void print() {

        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(10);
        rectangle.setLength(20);

        RectangleDemo rectangleDemo = new RectangleDemo();

        rectangleDemo.resize(rectangle);

        rectangleDemo.print(rectangle);


        Square square = new Square();

        square.setSide(10);

        rectangleDemo.print(square);
    }
}