package cn.syy.principles.interface_isolation.before;

import junit.framework.TestCase;

public class ISafetyDoorTest extends TestCase {


    public void test() {

        ISafetyDoor safetyDoor = new HeiMaSafetyDoor();

        safetyDoor.firePrevention();

        safetyDoor.waterproof();

        safetyDoor.antiTheft();
    }

}