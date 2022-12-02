package cn.syy.principles.richter_substitution.before;

/**
 * @author syy
 */
public class RectangleDemo {

    public void resize(Rectangle rectangle) {

        while (rectangle.getWidth() <= rectangle.getLength()) {

            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    public void print(Rectangle rectangle) {

        System.out.println(rectangle.getWidth() + ":" + rectangle.getLength());
    }
}
