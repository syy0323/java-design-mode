package cn.syy.principles.dependency_inversion.before;

public class XiJieHardDisk {

    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据为:" + data);
    }

    public String get(){
        System.out.println("使用希捷硬盘返回数据");
        return "数据";
    }
}
