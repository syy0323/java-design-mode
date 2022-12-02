## 软件设计原则
### 开闭原则
> 对扩展开放，对修改关闭。在程序需要进行拓展时，不能修改原有代码。想达到这种效果，需要使用抽象类和接口

### 里氏代换原则
> 里氏代换原则时面向对象设计的基本原则之一

任何基类可以出现的地方，子类一定可以出现。通俗理解：子类可以拓展父类的功能，但不能改变父类原有的功能。换句话说，子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。

如果通过重写父类的方法来完成新的功能，这样写起来虽然简单，但是整个继承体系的复用性会比较差，特别是运用多态比较频繁时，程序出错的概率会非常大。

示例：

```java
public class Rectangle {

    private double length;

    private double width;


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

public class Square extends Rectangle {

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }
}

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
```





> 如果正方形也使用resize方法，会卡住循环，如果进行替换就无法得到预期的结果。因此类之间的继承违反了里氏代换原则，它们之间的继承不成立，正方形不是长方形



改进：

```java
public interface Quadrilateral {

    /**
     * 获取长
     *
     * @return length
     */
    double getLength();

    /**
     * 获取宽
     *
     * @return width
     */
    double getWidth();
}

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

public class Square implements Quadrilateral {

    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }
}

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
```



### 依赖倒转原则

> 高层模块不应该依赖底层模块，两者应该依赖其抽象；抽象不应该依赖细节，细节应该抽象。简单地说，就是要对抽象进行编程，不要对实现进行编程，这样就降低了客户与实现模块之间的耦合。
>
> 比如组装电脑。只需要，内存，机箱cpu，硬盘，只要这些东西有了，就能运行计算机。但具体的品种可以选择。