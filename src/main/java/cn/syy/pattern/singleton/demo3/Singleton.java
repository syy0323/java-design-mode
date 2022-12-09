package cn.syy.pattern.singleton.demo3;

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
