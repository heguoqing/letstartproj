import com.springapp.controller.HelloController;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by guoqing on 2016/3/7 0007.
 */
public class AppTest {
    public static void main(String[] args) {
        System.out.println("ok");
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-applicationContext.xml");

        FileSystemXmlApplicationContext ftx = new FileSystemXmlApplicationContext("D:\\work\\projects\\letstart\\let-start-proj\\springmvc\\src\\main\\webapp\\WEB-INF\\spring\\spring-applicationContext.xml");

        HelloController helloController = (HelloController) ftx.getBean("HelloController");
        helloController.printWelcome(null);
    }
}
