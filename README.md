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

```java
public class XiJieHardDisk {

    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据为:" + data);
    }

    public String get(){
        System.out.println("使用希捷硬盘返回数据");
        return "数据";
    }
}

public class KingstonMemory {

    public void save() {
        System.out.println("使用金士顿内存条");
    }
}

public class InterCpu {

    public void run() {

        System.out.println("使用inter处理器");
    }
}

public class Computer {


    private XiJieHardDisk hardDisk;

    private InterCpu cpu;

    private KingstonMemory memory;


    public XiJieHardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(XiJieHardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public InterCpu getCpu() {
        return cpu;
    }

    public void setCpu(InterCpu cpu) {
        this.cpu = cpu;
    }

    public KingstonMemory getMemory() {
        return memory;
    }

    public void setMemory(KingstonMemory memory) {
        this.memory = memory;
    }


    public void run() {

        System.out.println("运行计算机");

        String data = hardDisk.get();

        System.out.println("从硬盘上获取的数据是：" + data);

        cpu.run();

        memory.save();
    }
}

 public void testTestRun() {

        Computer computer=new Computer();

        XiJieHardDisk hardDisk=new XiJieHardDisk();

        computer.setHardDisk(hardDisk);

        InterCpu cpu=new InterCpu();

        computer.setCpu(cpu);

        KingstonMemory memory=new KingstonMemory();

        computer.setMemory(memory);

        computer.run();
    }
```

上面的代码已经组装了一台电脑，但是组装的电脑cpu，内存，硬盘都是固定的，对用户是不友好的，用户需要可以自行挑选喜欢的配件。

根据依赖倒转原则进行改进：只需要修改Computer类，让Computer类依赖抽象，而不是依赖于各个组件具体的实现类

### 接口隔离原则

> 客户端不应该被迫依赖于它不适用的方法。一个类对另一个类的依赖应该建立在最小的接口上。

### 迪米特法则

> 只和你的直接朋友交谈，不跟“陌生人”说话。
>
>   其含义是：如果两个软件实体无须直接通信，那么就不应当发生直接的互相调用，可以通过第三方（包含了这两个软件）转发该调用。其目的是降低类之间的耦合度，提高模块的相对独立性。
>
>   迪米特法则中的“朋友”是指：当前对象本身、当前对象的成员对象，当前对象创建的对象、当前对象的方法参数等。这些对象同当前对象存在关联、聚合或者组合关系，可以直接访问对象的方法。

```java
public class Star {

    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Fans {

    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Company {

    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Agent {

    private Star star;

    private Fans fans;

    private Company company;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void meeting() {
        System.out.println(fans.getName() + "与明星" + star.getName() + "见面了");
    }

    public void business() {
        System.out.println(company.getName() + "与明星" + star.getName() + "洽谈业务");
    }
}

public class Client {

    public static void main(String[] args) {


        Agent agent = new Agent();

        Star star = new Star("林青霞");

        agent.setStar(star);

        Fans fans = new Fans("小A");

        agent.setFans(fans);

        Company company = new Company("笑果文化");
        agent.setCompany(company);

        agent.meeting();

        agent.business();
    }
}
```



### 合成复用原则

> 尽量使用组合或者聚合等关联关系来实现，其次才考虑使用继承关系来实现。
>
> 通常类的复用分为继承复用和合成复用两种
>
> 继承复用虽然简单和易实现，但是存在以下缺点
>
> - 继承复用破坏了类的封装性。因为继承会将父类的实现细节暴露给子类，父类对子类是透明的，所以这种复用又称为”白箱“复用
> - 子类和父类的耦合度高。父类的实现的任何改变都会导致子类的实现发生变化，不利于类的扩展和维护
> - 它限制了复用的灵活性。从父类继承而来的实现是静态的，在编译时已经定义，所以在运行时不可能发生变化
>
> 采用组合或者聚合复用时，可以将已有对象纳入新对象中，使之成为新对象的一部分，新对象可以调用已有对象的功能。
>
> - 维持了类的封装性。因为成分对象的内部细节是新对象看不见的，所以这种复用又称为”黑箱“复用
> - 对象间的耦合度低。可以在类的成员位置声明抽象
> - 复用的灵活性高。这种复用可以在运行时动态进行，新对象可以动态地引用与成分对象类型相同的对象



## 创建者模式

> 创建者模式的主要关注点是”怎么创建对象？“，它的主要特点是”将对象的创建与使用分离“

- 单例模式
- 工厂方法模式
- 抽象工程模式
- 原型模式
- 建造者模式

### 单例设计模式

> 单例模式(Singleton Pattern)是Java中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
>
> 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一对象的方式，可以直接访问，不需要实例化该类的对象。



> 单例模式分为两种
>
> - 饿汉式：类加载就会创建该单例实例
> - 懒汉式：类加载不会创建该单例实例，在首次使用时才会被创建



饿汉式两种

```java
/**
 * 单例模式
 * <p>
 * 饿汉式 静态成员变量方式
 */
public class Singleton {

    // 构造方法私有化
    private Singleton() {
    }

    // 在本类中创建对象
    private static final Singleton instance = new Singleton();

    // 提供一个公共的获取实例的方法
    public static Singleton getInstance() {

        return instance;
    }
}
```

```java
/**
 * 单例模式
 * <p>
 * 饿汉式 静态代码块方式
 */
public class Singleton {

    // 构造方法私有化
    private Singleton() {
    }

    // 声明Singleton类型的变量
    private static final Singleton instance;

    // 静态代码块中进行赋值
    static {
        instance = new Singleton();
    }

    // 提供一个公共的获取实例的方法
    public static Singleton getInstance() {

        return instance;
    }
}
```

懒汉式

```java
/**
 * 单例模式
 * <p>
 * 懒汉式
 */
public class Singleton {

    // 构造方法私有化
    private Singleton() {
    }

    // 声明Singleton类型的变量
    private static Singleton instance;

    // 提供一个公共的获取实例的方法,锁
    public static synchronized Singleton getInstance() {

        if (instance == null) {

            instance = new Singleton();
        }

        return instance;
    }
}
```

该方式实现了懒加载效果，同时也解决了线程安全问题。但是在getInstance()方法上添加了synchronized关键字，导致执行效率过低。
