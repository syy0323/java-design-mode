package cn.syy.principles.richter_substitution.after;

import cn.syy.AppTest;
import junit.framework.TestCase;

class RectangleDemoTest extends TestCase {

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