package cn.syy.principles.law_of_demeter;

/**
 * 公司类
 *
 * @author syy
 */
public class Company {

    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
