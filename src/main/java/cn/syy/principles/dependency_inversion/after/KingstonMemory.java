package cn.syy.principles.dependency_inversion.after;

public class KingstonMemory implements  IMemory{

    public void save() {
        System.out.println("使用金士顿内存条");
    }
}
