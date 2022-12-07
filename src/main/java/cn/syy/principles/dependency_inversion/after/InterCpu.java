package cn.syy.principles.dependency_inversion.after;

public class InterCpu implements ICpu {


    public void run() {

        System.out.println("使用inter处理器");
    }
}
