package cn.syy.principles.law_of_demeter;

/**
 * 测试类
 *
 * @author syy
 */
public class Client {

    public static void main(String[] args) {


        Agent agent = new Agent();

        Star star = new Star("林青霞");

        agent.setStar(star);

        Fans fans = new Fans("小A");

        agent.setFans(fans);

        Company company = new Company("笑果文化");
        agent.setCompany(company);

        agent.meeting();

        agent.business();
    }
}
