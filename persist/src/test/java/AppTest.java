import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by guoqing on 2016/3/7 0007.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/persist-applicationContext.xml")
@ActiveProfiles("dev")
public class AppTest {
    public static void main(String[] args) {
        System.out.println("ok");
    }

    @Test
    public void test()
    {
        System.out.println("ok");
    }
}
