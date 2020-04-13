import com.leeyaonan.dao.AccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Author leeyaonan
 * @Date 2020/4/13 8:40
 */
public class IoCTest {

    @Test
    public void testIoC() throws Exception {

        // 通过读取classpath下的xml文件来启动容器（xml模式下SE应用下推荐）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        // 不推荐使用，因为采用的是绝对路径
        // ApplicationContext applicationContext1 = new FileSystemXmlApplicationContext("文件的绝对路径");

        // JavaSE下如何使用纯注解启动IoC容器
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        System.out.println(accountDao);

        // Spring实例化bean的第二种方式
        Object connectionUtils = applicationContext.getBean("connectionUtils");
        System.out.println(connectionUtils);
    }

}
