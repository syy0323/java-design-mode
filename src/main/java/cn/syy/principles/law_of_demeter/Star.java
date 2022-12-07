package cn.syy.principles.law_of_demeter;

/**
 * 明星类
 *
 * @author syy
 */
public class Star {

    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
