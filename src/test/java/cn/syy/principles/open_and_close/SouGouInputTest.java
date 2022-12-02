package cn.syy.principles.open_and_close;

import org.junit.jupiter.api.Test;

class SouGouInputTest {

    @Test
    void display() {

        // 创建搜狗输入法对象
        SouGouInput input = new SouGouInput();

        // 创建输入法皮肤对象
        AbstractSkin skin = new HeiMaSkin();

        // 设置皮肤
        input.setSkin(skin);

        // 显示
        input.display();
    }
}