package cn.syy.principles.richter_substitution;

import cn.syy.principles.richter_substitution.before.Rectangle;
import cn.syy.principles.richter_substitution.before.RectangleDemo;
import cn.syy.principles.richter_substitution.before.Square;
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

        square.setWidth(10);

        rectangleDemo.resize(square);

        rectangleDemo.print(square);

    }
}