package cn.syy.principles.law_of_demeter;

/**
 * 粉丝类
 *
 * @author syy
 */
public class Fans {

    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
