package cn.syy.principles.richter_substitution.after;


/**
 * @author syy
 */
public class Rectangle implements Quadrilateral {

    private double width;

    private double length;

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getLength() {
        return this.length;
    }

    @Override
    public double getWidth() {
        return this.width;
    }
}
