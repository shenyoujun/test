import OP.Services.UserServiceI;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-21
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */

public class SpringTest {
    @Test
    public void testString() {
        String str = "acc.pdf";

        int i = str.lastIndexOf(".");
        String str1 = str.substring(i);

        System.out.println(str + " " + i + " " + str1);
    }

}

