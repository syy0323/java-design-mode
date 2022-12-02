package cn.syy.principles.open_and_close;

/**
 * 搜狗输入法
 *
 * @author syy
 */
public class SouGouInput {

    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display() {
        skin.display();
    }
}
