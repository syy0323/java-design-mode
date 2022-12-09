package cn.syy.pattern.singleton.demo1;

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
