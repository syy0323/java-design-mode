package cn.syy.principles.interface_isolation.before;

/**
 * 黑马安全门
 *
 * @author syy
 */
public class HeiMaSafetyDoor implements ISafetyDoor {
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
