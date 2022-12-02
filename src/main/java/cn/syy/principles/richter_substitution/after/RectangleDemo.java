package cn.syy.principles.richter_substitution.after;


/**
 * @author syy
 */
public class RectangleDemo {

    public void resize(Rectangle rectangle) {

        while (rectangle.getWidth() <= rectangle.getLength()) {

            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    public void print(Quadrilateral quadrilateral) {

        System.out.println(quadrilateral.getWidth() + ":" + quadrilateral.getLength());
    }
}
