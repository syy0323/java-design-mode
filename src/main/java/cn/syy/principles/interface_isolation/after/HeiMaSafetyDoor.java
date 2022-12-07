package cn.syy.principles.interface_isolation.after;

/**
 * 改造后的防盗门，遵循接口隔离原则，需要什么功能就继承什么接口
 *
 * @author syy
 */
public class HeiMaSafetyDoor implements IAntiTheft, IFirePrevention, IWaterproof {
    public void antiTheft() {

        System.out.println("防盗");
    }

    public void firePrevention() {

        System.out.println("防火");
    }

    public void waterproof() {

        System.out.println("防水");
    }
}
