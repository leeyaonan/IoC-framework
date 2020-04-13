import com.leeyaonan.SpringConfig;
import com.leeyaonan.dao.AccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Author leeyaonan
 * @Date 2020/4/13 8:40
 */
public class IoCTest {

    @Test
    public void testIoC() throws Exception {

        // SE
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

        System.out.println(accountDao);
    }

}
