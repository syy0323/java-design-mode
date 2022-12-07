package cn.syy.principles.dependency_inversion.before;

import junit.framework.TestCase;

public class ComputerTest extends TestCase {

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
}