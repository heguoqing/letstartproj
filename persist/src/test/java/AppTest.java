import com.springapp.model.BaseEntity;
import com.springapp.model.WXTemplateMsgTo;
import com.springapp.persist.dao.IBaseDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired(required = true)
    protected SqlSession sqlSessionTemplate;

    @Autowired
    protected IBaseDao<BaseEntity> iBaseDao;

    public static void main(String[] args) {
        System.out.println("ok");
    }

    @Test
    public void test()
    {
        System.out.println("ok");
    }

    @Test
    public void testSqlSessionTemplate()
    {
        System.out.println(sqlSessionTemplate);
    }

    @Test
    public void testBaseDao()
    {
        WXTemplateMsgTo msgTo = new WXTemplateMsgTo();
        msgTo.setName("guoqing222");
        msgTo.setOpenId("xxxxx222");
        msgTo.setStatus("A");
        iBaseDao.add(msgTo);
    }
}
