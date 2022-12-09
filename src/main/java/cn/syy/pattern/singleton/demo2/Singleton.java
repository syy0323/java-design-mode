package cn.syy.pattern.singleton.demo2;

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
