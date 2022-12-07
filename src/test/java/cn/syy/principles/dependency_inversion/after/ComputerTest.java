package cn.syy.principles.dependency_inversion.after;


import junit.framework.TestCase;

public class ComputerTest extends TestCase {

    public void testTestRun() {

        Computer computer=new Computer();

        IHardDisk hardDisk=new XiJieHardDisk();

        computer.setHardDisk(hardDisk);

        ICpu cpu=new InterCpu();

        computer.setCpu(cpu);

        IMemory memory=new KingstonMemory();

        computer.setMemory(memory);

        computer.run();
    }
}